package com.zinio.web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;

import com.zinio.web.element.BasePage;
import com.zinio.web.utilities.Logging;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;

public class ReaderPage extends BasePage{

	public ReaderPage(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * *****Declaration Elements ****
	 */

	@FindBy(xpath = "//*[@class='ControlsLayer-exitReader']//i")
	WebElementFacade exitReader;
	
	@FindBy(id = "arrow-next")
	WebElementFacade nextPageBtn;
	
	@FindBy(id = "arrow-previous")
	WebElementFacade previousPageBtn;
	
	@FindBy(id = "reader")
	WebElementFacade readerPage;
	
	@FindBy(className = "//*[@id='SvgView']/div[2]/div/div")
	WebElementFacade svgView;
	
	@FindBy(className = "Sidebar-item--logo")
	WebElementFacade itemLogo;
	
	@FindBy(id = "toc-toggle")
	WebElementFacade tableOfContent;
	
	@FindBy(id = "thumbs-toggle")
	WebElementFacade skipToPage;
	
	@FindBy(id = "bookmarks-toggle")
	WebElementFacade bookmarks;
	
	@FindBy(id = "fullscreen-toggle")
	WebElementFacade fullScreen;
	
	@FindBy(id = "zoom-toggle")
	WebElementFacade zoom;
	
	@FindBy(xpath = "//*[@class='Zoom-out']/i")
	WebElementFacade zoomOut;
	
	@FindBy(xpath = "//*[@class='Zoom-in']/i")
	WebElementFacade zoomIn;
	
	@FindBy(id = "print-button")
	WebElementFacade printBtn;
	
	// Table of Contents Element
	
	@FindBy(className = "TocItem--header")
	WebElementFacade tocHeader;
	
	@FindBy(className = "TocItem")
	List<WebElementFacade> contentList;
	
	@FindBy(className = "TocItem-title")
	List<WebElementFacade> tableOfContentTitle;
	
	@FindBy(className = "TocItem-divider")
	List<WebElementFacade> tocLine;
	
	@FindBy(xpath = "//*[@id='page_0']/imag")
	WebElementFacade outsideSection;
	
	@FindBy(className = "TocSubItem")
	List<WebElementFacade> tocSubItemList;
	
	// Skip to page

	@FindBy(id = "thumbId_Cover")
	WebElementFacade thumbCover;
	
	@FindBy(xpath = "//*[contains(@class, 'Thumbnails')]")
	WebElementFacade thumbnailsSize;
	
	@FindBy(xpath = "//*[contains(@class, 'Sidebar-wrapper')]//*[contains(text(), 'chevron_right')]")
	WebElementFacade expandThumbnail;
	
	@FindBy(xpath = "//*[contains(@class, 'Sidebar-wrapper')]//*[contains(text(), 'chevron_left')]")
	WebElementFacade narrowThumbnail;

	// Bookmarks list
	
	@FindBy(className = "Bookmark-header")
	WebElementFacade bookmarkHeader;
	
	@FindBy(className = "Bookmark-header-title")
	WebElementFacade bookmarkHeaderTitle;
	
	@FindBy(className = "Bookmark-add")
	WebElementFacade addBookmark;
	
	@FindBy(className = "BookmarkItem")
	List<WebElementFacade> itemBookmarkList;
	
	@FindBy(id = "bookmark-modal")
	WebElementFacade bookmarkDialog;
	
	@FindBy(id = "bookmark-form-label")
	WebElementFacade bookmarkTitle;
	
	@FindBy(id = "bookmark-user-description")
	WebElementFacade bookmarkDescription;
	
	@FindBy(xpath = "//*[@id='bookmark-form']/input")
	WebElementFacade submitBookmark;
	
	
	
	
	
	
	
	
	
	
	
	
	 
	// Action 
	
	public void exitReaderMode() {
		System.out.println("Exit Reader Mode");
		clickOutsideSectionList();
		exitReader.click();
	}
	
	public boolean checkReaderModeIsPresent() {
		Logging.info("Check Reader Mode page is present");
		try {
			return readerPage.isDisplayed();
		} catch (Exception noSuchElement) {
			Logging.info("Reader Mode page is not present");
			return false;
		}
	}
	
	public boolean checkZinioIconPresent() {
		Logging.info("Check Zinio Icon is present");
		try {
			return itemLogo.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public boolean checkTableOfContentIconPresent() {
		Logging.info("Check Table Of Content Icon is present");
		try {
			return tableOfContent.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public boolean checkSkipToPageIconPresent() {
		Logging.info("CheckSkip to Page Icon is present");
		try {
			return skipToPage.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public boolean checkBookmarksIconPresent() {
		Logging.info("Check Bookmarks Icon is present");
		try {
			return bookmarks.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public boolean checkFullScreenIconPresent() {
		Logging.info("Check Full Screen Icon is present");
		try {
			return fullScreen.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public boolean checkZoomIconPresent() {
		Logging.info("Check Full Screen Icon is present");
		try {
			return zoom.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public boolean checkPrintIconPresent() {
		Logging.info("Check Print Icon is present");
		try {
			return printBtn.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public String getToolTipTableOfContent(){
		return getToolTip(tableOfContent);
	}
	
	public String getToolTipPageNavigation(){
		return getToolTip(skipToPage);
	}
	
	public String getToolTipBookmarks(){
		return getToolTip(bookmarks);
	}
	
	public String getToolTipFullScreen(){
		return getToolTip(fullScreen);
	}
	
	public String getToolTipZoom(){
		return getToolTip(zoom);
	}
	
	public String getToolTipPrintBtn(){
		return getToolTip(printBtn);
	}
	
	public void clickTableOfContentIcon() {
		Logging.info("Click on Table Of Content Icon");
		tableOfContent.click();
	}
	
	public void clickSkipToPageIcon() {
		Logging.info("Click Skip To Page Icon");
		skipToPage.click();
	}
	
	public void clickBookmarksIcon() {
		Logging.info("Click Bookmarks Icon");
		bookmarks.click();
	}
	
	public void clickFullScreenIcon() {
		Logging.info("Click Full Screen Icon");
		fullScreen.click();
	}
	
	public void clickZoomIcon() {
		Logging.info("Click Zoom Icon");
		zoom.click();
	}
	
	public void clickZoomInIcon() {
		Logging.info("Click Zoom In Icon");
		zoomIn.click();
	}
	
	public void clickZoomOutIcon() {
		Logging.info("Click Zoom Out Icon");
		zoomOut.click();
	}
	
	public void clickPrintIcon() {
		Logging.info("Click Print Icon");
		printBtn.click();
	}
	
	public boolean checkViewListIsShown() {
		Logging.info("Check View List is shown");
		try {
			return tocHeader.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public String getTocItemHearder() {
		Logging.info("Get toc item title");
		return tocHeader.findElement(By.xpath("//span")).getText();
	}
	
	public int getNumViewListItem() {
		Logging.info("Get number of View List Items of Table Contents");
		return tableOfContentTitle.size();
	}
	
	public int getNumTocLine() {
		Logging.info("Get total line divider in Table Of Contents");
		return tocLine.size();
	}
	
	public List<String> getViewListItem() {
		Logging.info("Get View List Items of Table Contents");
		ArrayList<String> viewListItem = new ArrayList<String>();
		for(int i =0; i<tableOfContentTitle.size(); i++) {
			viewListItem.add(tableOfContentTitle.get(i).getText());
			Logging.info("Item in table is :  " + tableOfContentTitle.get(i).getText());
		}
		return viewListItem;
	}
	
	public void clickOutsideSectionList() {
		Logging.info("Click Outside the section list panel");
		Actions action = new Actions(getDriver());
		WebElement elem = getDriver().findElement(By.xpath("//*[@id='SvgView']//div/div"));
//		action.moveToElement(elem).build().perform();
		action.moveToElement(elem).click().build().perform();
	}
	
	public void clickOnSectionNameOnTheList() {
		Logging.info("Click on a Section name on the list");
		contentList.get(0).click();
		waitABit(2000);
	}
	
	public void scrollToViewTocItem() {
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("arguments[0].scrollIntoView(true)", tocSubItemList.get(tocSubItemList.size()-1));
		waitABit(3000);
		Logging.info("Is present or not : " + tocSubItemList.get(0).isCurrentlyVisible());
		jse.executeScript("arguments[0].scrollIntoView(true)", tocSubItemList.get(0));
		waitABit(4000);
		Logging.info("Is present or not : " + tocSubItemList.get(tocSubItemList.size()-1).isCurrentlyVisible());
		
	}
	
	public boolean checkArticleListLayout() {
		
		Logging.info("Check the article list layout");
		
		for(int i =0; i < tocSubItemList.size(); i++) {
			Logging.info("Get article title");
			String articleTitle = tocSubItemList.get(i).findElement(By.className("TocSubItem-title")).getText();
			if (articleTitle.equals(null)) return false ;
			
			Logging.info("Get author name");
			String authorName = tocSubItemList.get(i).findElement(By.className("TocSubItem-subtitle")).getText();
			if (authorName.equals(null)) return false ;
			
			Logging.info("Check article thumbnail");
			boolean articleThumbnail = tocSubItemList.get(i).findElement(By.xpath("//*[@class='TocSubItem-imgBlock']//img")).isDisplayed();
			if (articleThumbnail == false) return false ;
			
			Logging.info("Get page number on the thumbnail");
			String pageNumber = tocSubItemList.get(i).findElement(By.className("TocSubItem-imageNumber")).getText();
			if (pageNumber.equals(null)) return false;
		}
		return true;
	}
	
	public boolean checkThumbnailsIsPresent() {
		Logging.info("Check thumbnail is present");
		try {
			return thumbCover.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public boolean checkArticleListPresent() {
		Logging.info("Check article list is present");
		try {
			return tocSubItemList.get(0).isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public int getThumbnailsSize() {
		Logging.info("Get thumbnail size");
		try {
			return thumbnailsSize.getSize().width;
		} catch (Exception noSuchElement) {
			return 0;
		}
	}
	
	public void clickExpandThumbnail() {
		Logging.info("Click expand thumbnail");
		expandThumbnail.click();
	}
	
	public void clickNarrowThumbnail() {
		Logging.info("Click narrow thumbnail");
		narrowThumbnail.click();
	}
	
	public void clickNextPageBtn() {
		Logging.info("Click next page button");
		nextPageBtn.click();
	}
	
	public void clickPreviousPage() {
		Logging.info("Click previous page button");
		previousPageBtn.click();
	}
	
	public boolean checkNextPageBtnIsDisplayed() {
		Logging.info("Check Next Page button is displayed or not");
		try {
			return nextPageBtn.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public boolean checkPreviousPageBtnIsDisplayed() {
		Logging.info("Check prevoius page button is displayed or not");
		try {
			return previousPageBtn.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public boolean checkBookmarksLayout() {
		
		Actions actions = new Actions(getDriver());
		
		Logging.info("Check the layout of Bookmarks list");
		
		if (bookmarkHeader.isDisplayed()==false) return false ;
		
		if (bookmarkHeaderTitle.isDisplayed()==false) return false ;
		
		if (!bookmarkHeaderTitle.getText().equals("BOOKMARKS")) return false ;
		
		if (itemBookmarkList.size()>0) {
			
			for(int i =0; i < itemBookmarkList.size(); i++) {
				Logging.info("Get bookmark title");
				
				String articleTitle = itemBookmarkList.get(i).findElement(By.className("BookmarkItem-title")).getText();
				if (articleTitle.equals(null)) return false ;
				Logging.info("----> Bookmark title is not null");
				waitABit(500);
				
				Logging.info("Get bookmark description ");
				String authorName = itemBookmarkList.get(i).findElement(By.className("BookmarkItem-blurb")).getText();
				if (authorName.equals(null)) return false ;
				Logging.info("----> Bookmark description is not null");
				waitABit(500);
				
				Logging.info("Check thumbnail bookmarks is displayed ");
				actions.moveToElement(itemBookmarkList.get(i).findElement(By.xpath(".//*[@class='BookmarkItem-overlay']"))).build().perform();
				waitABit(100);
				if (itemBookmarkList.get(i).findElement(By.className("BookmarkItem-overlay")).isDisplayed()==false) return false ;
				Logging.info("---> Thumbnail bookmarks is displayed ");
				
				waitABit(500);
				Logging.info("Check delete button on thumbnail bookmarks is displayed ");
				waitABit(500);
				actions.moveToElement(itemBookmarkList.get(i).findElement(By.xpath(".//*[@class='BookmarkItem-overlay']//i"))).build().perform();
				if (itemBookmarkList.get(i).findElement(By.xpath(".//*[@class='BookmarkItem-overlay']//i")).isDisplayed()==false) return false ;
				Logging.info("---> Delete button is displayed");
			}
		} else {
			if (addBookmark.isDisplayed()==false) return false ;
			
			if (!addBookmark.getText().equals("add bookmark")) return false ;
		}
		return true;
	}
	
	public List<String> getBookmarksDescription() {
		List<String> listDescription  = new ArrayList<String>();
		for(int i =0; i < itemBookmarkList.size(); i++) {
			Logging.info("Get bookmark description ");
			String issueDescpt = itemBookmarkList.get(i).findElement(By.className("BookmarkItem-blurb")).getText();
			waitABit(500);
			listDescription.add(issueDescpt);
		}
		return listDescription;
	}
	
	public void deleteBookmark(String bookmarkTitle) {
		Logging.info("Delete bookmarked page on the bookmark list");
		for(int i =0; i < itemBookmarkList.size(); i++) {
			if(bookmarkTitle.equals(itemBookmarkList.get(i).findElement(By.className("BookmarkItem-title")).getText())){
				Actions actions = new Actions(getDriver());
				actions.moveToElement(itemBookmarkList.get(i).findElement(By.xpath(".//*[@class='BookmarkItem-overlay']//i"))).click().build().perform();
				waitABit(5000);
			}
		}
	}
	
	public void deleteAllBookmark() {
		Logging.info("Delete all bookmarked page on the bookmark list");
		for(int i =0; i < itemBookmarkList.size(); i++) {
			Actions actions = new Actions(getDriver());
			actions.moveToElement(itemBookmarkList.get(i).findElement(By.xpath(".//*[@class='BookmarkItem-overlay']//i"))).click().build().perform();
			waitABit(5000);
		}
	}
	
	public boolean checkBookmarkIsRemoved(String bookmarkTitle) {
		Logging.info("Check bookmark on the bookmark list is removed");
		int count = 0;
		for(int i = 0; i < itemBookmarkList.size(); i++) {
			if(bookmarkTitle.equals(itemBookmarkList.get(i).findElement(By.className("BookmarkItem-title")).getText())){
				count +=1;
			}
		}
		if(count!=0) return false;
		Logging.info("----> Bookmarked page already is removed");
		return true;
	}
	
	public boolean checkAllBookmarkAreRemoved() {
		Logging.info("Check All bookmarked pages on the bookmark list are removed");
		if(itemBookmarkList.size()>0) return false;
		Logging.info("----> All Bookmarked pages already are removed");
		return true;
	}
	
	public void clickAddBookmarksList() {
		Logging.info("Click add bookmarks list");
		addBookmark.click();
	}
	
	public boolean checkBookmarkLinkPresent() {
		Logging.info("Check Add bookmark link is displayed or not");
		try {
			return addBookmark.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public boolean checkBookmarkDialogPresent() {
		Logging.info("Check Bookmark Dialog is displayed or not");
		try {
			return bookmarkDialog.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public boolean checkBookmarkTitlePresent() {
		Logging.info("Check Bookmark title is displayed or not");
		try {
			return bookmarkTitle.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public boolean checkBookmarkDescriptionPresent() {
		Logging.info("Check Bookmark description is displayed or not");
		try {
			return bookmarkDescription.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public boolean checkSubmitBookmarkBtnPresent() {
		Logging.info("Check Submit Bookmark button is displayed or not");
		try {
			return submitBookmark.isDisplayed();
		} catch (Exception noSuchElement) {
			return false;
		}
	}
	
	public void clickSubmitBookmarksBtn() {
		Logging.info("Click Submit Bookmarks button");
		submitBookmark.click();
	}
	
	public void inputBookmarkDescription(String desctipion) {
		Logging.info("Input data for bookmark description");
		bookmarkDescription.clear();
		bookmarkDescription.sendKeys(desctipion);
	}
	
	public String getBookmarkTitleInDialog() {
		Logging.info("Get bookmark title in dialog");
		return bookmarkTitle.getText();
	}
	
	public String compareBookmarkTitle(String bookmarked) {
		Logging.info("Compare bookmark title");
		return bookmarkTitle.getText();
		
	}
	
	
}



