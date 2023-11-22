package com.abc.DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderConcept {
		
		@Test(dataProvider= "pleaseProvideTheData", dataProviderClass= Dataprovider.class)
			public void CheckLoginPage(String myEmail,String myPassword) throws InterruptedException
		{
			System.setProperty("webdriver.chrome.driver","C:\\\\\\\\Users\\\\\\\\sandesh MK\\\\\\\\Desktop\\\\\\\\selenium webdriver\\\\\\\\chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();
			driver.get("https://tutorialsninja.com/demo");
			Thread.sleep(3000);
			WebElement myDropdown=driver.findElement(By.className("dropdown"));
			myDropdown.click();
			driver.findElement(By.xpath("//a[@href='https://tutorialsninja.com/demo/index.php?route=account/login']")).click();
			driver.findElement(By.id("input-email")).sendKeys(myEmail);
			driver.findElement(By.id("input-password")).sendKeys(myPassword);
			driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		}
		public class Dataprovider 
		{
			@DataProvider(parallel=true)
			public Object[][] pleaseProvideTheData()
			{
				Object[][] mydata= {{"sandeshmk082@gmail.com","Mydream@22"}};
				return mydata;
			}
		}
}



