package com.zinio.web.utilities;

import java.io.File;
import java.text.SimpleDateFormat;

import org.testng.Assert;

public class AssertResult extends Assert {
	static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a ");
	static Utils util = new Utils();
	public static void fail(String message) {
//		util.takeScreenShot();
		Assert.fail(message);
	}
	public static void pass(String message, boolean arg) {
		Assert.assertTrue(arg, message);
	}
	public static void fail(String message, boolean arg) {
//		util.takeScreenShot();
		Assert.assertFalse(arg, message);
	}
}
