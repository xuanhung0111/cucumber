package com.zinio.web.utilities;

import java.util.logging.*;

import org.testng.Reporter;
 
public class Logging {
   // Invoke the factory method to get a new Logger or return the existing Logger
   //  of the fully-qualified class name.
   // Set to static as there is one logger per class.
   private static final Logger logger = Logger.getLogger(Logging.class.getName());
 
   public static void info(String message){
		Reporter.log("<br>" + message + "</br>");
		logger.info(message);
	}
}