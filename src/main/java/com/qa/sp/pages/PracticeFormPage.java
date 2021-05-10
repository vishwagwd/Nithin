package com.qa.sp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.qa.sp.base.Testbase;

public class PracticeFormPage extends Testbase {
	
	@FindBy(name="firstname")
	WebElement firstname;
	

	@FindBy(name="lastname")
	WebElement lastname;
	
	
	@FindBy(id="sex-0")
	WebElement gender;
	
	
	@FindBy(id="exp-2")
	WebElement YOE;
	

	@FindBy(id="datepicker")
	WebElement enterdate;
		
	@FindBy(id="profession-1")
	WebElement profession;
	
	@FindBy(id="tool-2")
	WebElement tool;
	
	@FindBy(id="continents")
	WebElement continents;
	
	
	@FindBy(id="selenium_commands")
	WebElement selcommands;
	
	@FindBy(id="photo")
	WebElement fileupload;
	
	@FindBy(xpath="//*[@Class=\"control-group\"]//child::a")
	WebElement downloadfile;
	
	
	@FindBy(id="submit")
	WebElement submit;
	
	
	public PracticeFormPage()
	{
		PageFactory.initElements(driver, this);
	}
	

	
	public void completepracticeform()
	{
		
		
		firstname.sendKeys("Vishwanath");
		Reporter.log("first name entered successfully");
		
		lastname.sendKeys(".");
		Reporter.log("last name entered successfully");
		
		gender.click();
		Reporter.log("gender selected successfully");
		
		YOE.click();
		Reporter.log("YOE selected successfully");
		
		enterdate.sendKeys("17/03/2021");
		Reporter.log("Date entered successfully");
		
		profession.click();
		Reporter.log("Profession Selected successfully");
		
		tool.click();
		Reporter.log("Tool Selected successfully");
		
		Select cont = new Select(continents);
		cont.selectByVisibleText("Asia");
		Reporter.log("Continent selected successfully");
		
		Select commands = new Select(selcommands);
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(commands.getOptions().get(2)).keyUp(Keys.CONTROL);
		builder.keyDown(Keys.CONTROL).click(commands.getOptions().get(3)).keyUp(Keys.CONTROL);
		builder.build().perform();
		Reporter.log("Selected multiple commands");
		
		fileupload.sendKeys(prop.getProperty("filepath"));
		Reporter.log("file uploaded successfully");
		
		downloadfile.click();
		Reporter.log("Clicked on link");
		
		driver.navigate().back();
		Reporter.log("navigated to previous page successfully");
		
		
		WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
		submit.click();
		Reporter.log("Submitted successfully");
	}
}
