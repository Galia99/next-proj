package com.next.proj.nextG_proj.tests;

import java.io.File;

import org.testng.annotations.Test;

import com.next.proj.nextG_proj.infra.utils.AssertUtils;

public class FakeTest extends AbstractTest{

	@Test
	public void fakeTest1(){
		
		AssertUtils.assertEquals(3, 3, "ints should be equal");
		
		report.log("This is after the assert...");
	}
	
	@Test
	public void fakeTest2(){
		
		File f = new File("C:\\Users\\Artium\\Desktop\\ppp.txt");
		
		AssertUtils.assertTrue(f.exists(), "File found exists true!!!");
		
		report.log("This is after the assert ...");
	}
}
