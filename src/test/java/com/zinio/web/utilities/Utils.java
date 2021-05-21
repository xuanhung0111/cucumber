package com.zinio.web.utilities;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;

import org.testng.Reporter;


public class Utils {
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a ");
	String captureFolder = System.getProperty("user.dir")+"/capturefolder";

	public void getLog() throws Exception {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_F12);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShot() {
		String path = "";
//		String captureFolder = (String) testConf.loadConfig().getProperty("imagefolder");
		try{
			Thread.sleep(3000);
			Calendar now = Calendar.getInstance();
			Robot robot = new Robot();
			String nameImages = formatter.format(now.getTime());
			BufferedImage screenShot = robot.createScreenCapture(new Rectangle(
					Toolkit.getDefaultToolkit().getScreenSize()));
			path = captureFolder + nameImages + ".jpg";
			System.out.println(path);
			String image_name = nameImages + ".jpg";

			Reporter.log("<a href=" + "'"+ image_name + "'" + "><img border='0' src=" + "'" + image_name + "'" + " width='100' height ='100'/>" + "</a>");
			ImageIO.write(screenShot, "JPG", new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
