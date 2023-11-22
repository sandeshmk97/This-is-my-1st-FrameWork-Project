package com.abc.demo.com.abc.ProjectOnFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.abc.Listeners.MyListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

@Listeners(MyListener.class)
public class FirstProject {
	ExtentReports extentreport;
	public static ChromeDriver driver;
	@BeforeTest
	public void reportCreation()
	{
		extentreport = new ExtentReports();
		ExtentSparkReporter extententreporter = new ExtentSparkReporter("./reports/fail.html");
		extentreport.attachReporter(extententreporter);
		extentreport = new ExtentReports();
		ExtentSparkReporter extententreporter2 = new ExtentSparkReporter("./reports/pass.html");
		extentreport.attachReporter(extententreporter2);
		extententreporter.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		extententreporter2.filter().statusFilter().as(new Status[] {Status.PASS}).apply();
	}
	@AfterTest
	public void actuallycreation()
	{
		extentreport.flush();
	}
	@Test (priority = 1)
	public void HomePage() throws IOException, InterruptedException
	{
		ExtentTest extenttest = extentreport.createTest("tutorialsninja login","This test using valid credentials");
		extenttest.assignAuthor("Sandesh");
		extenttest.assignCategory("Funtional Testing");
		extenttest.assignDevice("Lenovo Chrome 114");
		FileInputStream fis = new FileInputStream("C:\\Users\\sandesh MK\\selenium webdriver\\com.abc.ProjectOnFramework\\mydata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String emailbox= prop.getProperty("emailocator");
		String emailaddress= prop.getProperty("emailtxtfield");
		String passbox= prop.getProperty("password");
		String passaddress= prop.getProperty("passtxtfield");
		System.setProperty("webdriver.chrome.driver","C:\\\\\\\\Users\\\\\\\\sandesh MK\\\\\\\\Desktop\\\\\\\\selenium webdriver\\\\\\\\chromedriver.exe");
		extenttest.log(Status.INFO, "opeing google chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		extenttest.log(Status.PASS, "opened successfully");
		extenttest.log(Status.INFO, "open tutorialsninja website");
		driver.get("https://tutorialsninja.com/demo/");
		extenttest.log(Status.PASS, "opened successfully");
		extenttest.log(Status.INFO, "click on Myaccount dropdown");
		WebElement drop= driver.findElement(By.className("dropdown"));
		drop.click();
		Thread.sleep(5000);
		extenttest.log(Status.INFO, "click on login");
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[2]/a")).click();
		extenttest.log(Status.INFO, "enter enter valid email and password ");
		driver.findElement(By.name(emailbox)).sendKeys(emailaddress);
		driver.findElement(By.name(passbox)).sendKeys(passaddress);
		Thread.sleep(5000);
		extenttest.log(Status.INFO, "click on Submit");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/form/input")).click();
		extenttest.log(Status.PASS, "logged in successfully");
		extenttest.log(Status.INFO, "click on Phones and PD'S");
		driver.findElement(By.xpath("/html/body/div[1]/nav/div[2]/ul/li[6]/a")).click();
		extenttest.log(Status.PASS, "successfull");
		extenttest.log(Status.INFO, "click on HTC Touch HD mobile and add to cart");
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[2]/div[2]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();
		extenttest.log(Status.PASS, "successfully added to cart");
		extenttest.log(Status.INFO, "click on cart");
		driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();
		Thread.sleep(2000);
		extenttest.log(Status.PASS, "successfull");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[2]/div[1]/h4/a/i")).click();
		Thread.sleep(2000);
	    WebElement myDropDown3=driver.findElement(By.id("input-country"));
		 Thread.sleep(3000);
		  myDropDown3.click();
		  extenttest.log(Status.INFO, "click on dropdown");
		  Select s=new Select(myDropDown3);
		   s.selectByIndex(106);
		   extenttest.log(Status.PASS, "successfull");
		   extenttest.log(Status.INFO, "click on dropdown");
		   WebElement myDropDown4=driver.findElement(By.id("input-zone"));
		   Thread.sleep(3000);
		   myDropDown4.click();
		   extenttest.log(Status.PASS, "successfull");
		   Select s4=new Select(myDropDown4);
		   s4.selectByIndex(15);
		   Thread.sleep(3000);
		   driver.findElement(By.id("input-postcode")).sendKeys("560043");
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("//button[@id='button-quote']")).click();
		   Thread.sleep(3000);
		   extenttest.log(Status.PASS, "TEST passed Successfully");
		  driver.close();	
	}
	
	
	@Test(priority = 2)
	public void chechkingwithinvalidcredentials() throws IOException, InterruptedException
	{
		ExtentTest extenttest2 = extentreport.createTest("tutorialsninja login check","This test using Invalid credentials");
		extenttest2.assignAuthor("Sandesh");
		extenttest2.assignCategory("Functional TEsting");
		extenttest2.assignDevice("Windows 8 chrome 114");
		FileInputStream fis = new FileInputStream("C:\\Users\\sandesh MK\\selenium webdriver\\com.abc.ProjectOnFramework\\mydata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String emailbox= prop.getProperty("eamilloacatorinvlid");
		String emailaddress= prop.getProperty("emailtxtfieldinvalid");
		String passbox= prop.getProperty("password");
		String passaddress= prop.getProperty("passtxtfieldinvalid");
		System.setProperty("webdriver.chrome.driver","C:\\\\\\\\Users\\\\\\\\sandesh MK\\\\\\\\Desktop\\\\\\\\selenium webdriver\\\\\\\\chromedriver.exe");
		try {
		extenttest2.log(Status.INFO, "opeing google chrome");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		extenttest2.log(Status.PASS, "opened successfully");
		extenttest2.log(Status.INFO, "open tutorialsninja website");
		driver.get("https://tutorialsninja.com/demo/");
		extenttest2.log(Status.PASS, "opened successfully");
		extenttest2.log(Status.INFO, "click on Myaccount dropdown");
		WebElement drop= driver.findElement(By.className("dropdown"));
		drop.click();
		Thread.sleep(2000);
		extenttest2.log(Status.INFO, "click on login");
		driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[2]/a")).click();
		extenttest2.log(Status.INFO, "enter enter email and password ");
		driver.findElement(By.name(emailbox)).sendKeys(emailaddress);
		}
		catch(NoSuchElementException e) 
		{
			extenttest2.log(Status.FAIL, "Above Element Could not found");
			File myscreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destinationfile= new File("./screenshots/Fail.png");
			FileUtils.copyFile(myscreenshot, destinationfile);
			extenttest2.addScreenCaptureFromPath("C:\\Users\\sandesh MK\\selenium webdriver\\com.abc.ProjectOnFramework\\screenshots");
			driver.close();
		}
		
	}
}
