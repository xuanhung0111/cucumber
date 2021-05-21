package com.zinio.web.utilities;
import com.zinio.web.data.CampaignData;
import com.zinio.web.data.DefaultValue;
import com.zinio.web.data.GeneralData;

public class RunUtilities {
	public static void main(String [] arg) {
		StringUtils untilTest = new StringUtils();
		System.out.println("---- : " + untilTest.randomNumber("Banner", 10));
		System.out.println("++++ : " + GeneralData.PAGE.PUBLICATIONS.pageName());
		System.out.println("**** : " + CampaignData.CAMPAIGN_PROJECT[1]);
		System.out.println("**** : " + DefaultValue.PLACEHOLDER.issueId.value());
		
		
		
		
	}
}
