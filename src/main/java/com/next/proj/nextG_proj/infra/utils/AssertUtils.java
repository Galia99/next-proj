package com.next.proj.nextG_proj.infra.utils;

import org.testng.Assert;

import il.co.topq.difido.ReportDispatcher;
import il.co.topq.difido.ReportManager;
import il.co.topq.difido.model.Enums.Status;

public class AssertUtils {

	private static ReportDispatcher report = ReportManager.getInstance();

	public static void assertEquals(Object actual, Object expected, String message) {
		assertEquals(actual, expected, message, false);
	}

	
	public static void assertEquals(Object actual, Object expected, String message, boolean softAssert) {

		try {
			Assert.assertEquals(actual, expected, message);
			report.log(message + "; (Assert equals) both objects are equal to: " + expected + " - OK");
		}
		catch (AssertionError e) { 
			
				report.log(e.getMessage(),null, Status.failure);
			 
				if(!softAssert) {
				throw e;
			}
		}
	}
	
	public static void assertTrue(boolean condition, String message) {
		assertTrue(condition, message, true);
	}
	public static void assertTrue(boolean condition, String message, boolean softAssert) {

		try {
			Assert.assertTrue(condition, message);
			report.log(message + " - OK :)");
		}
		catch (AssertionError e) { 
			
			    //report the Exception and continue the test!
				report.log(e.getMessage(), Status.failure);
			 
				if(!softAssert) {//if not a softAssert report the Exception (!softAssert)
				throw e;
			}
		}
	}
	public static void assertFalse(boolean condition, String message) {
		assertFalse(condition, message, true);
	}
	public static void assertFalse(boolean condition, String message, boolean softAssert) {

		try {
			Assert.assertFalse(condition, message);
			report.log(message + " - OK :)");
		}
		catch (AssertionError e) { 
			
			    //report the Exception and continue the test!
				report.log(e.getMessage(), Status.failure);
			 
				if(!softAssert) {//if not a softAssert report the Exception (!softAssert)
				throw e;
			}
		}
	}
	
}
