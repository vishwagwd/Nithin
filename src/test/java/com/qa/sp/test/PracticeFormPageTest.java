package com.qa.sp.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.sp.base.Testbase;
import com.qa.sp.pages.PracticeFormPage;
import com.qa.sp.util.CustomListener;


@Listeners(CustomListener.class)
public class PracticeFormPageTest extends Testbase{
	
	
	
	PracticeFormPage practiceformpage;
	
	public PracticeFormPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		
		practiceformpage = new PracticeFormPage();
	}
	
	
	@Test
	
	public void completepracticeformtest()
	{
		practiceformpage.completepracticeform();
	}
	
	
	@AfterMethod
	public void teardown()
	{
		
	}

}
