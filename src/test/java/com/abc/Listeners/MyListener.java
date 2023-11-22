package com.abc.Listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.abc.demo.com.abc.ProjectOnFramework.FirstProject;

public class MyListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result)
		{
		System.out.println("Currently this test case executed"+ result.getName());
		}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Currently this test case passed"+ result.getName());	
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Currently this test case failed"+ result.getName());
		File myscreenshot = ((TakesScreenshot)FirstProject.driver).getScreenshotAs(OutputType.FILE);
		File destinationscreenshot= new File("./ListenerScreenshots/Fail.png");
		try {
			FileUtils.copyFile(myscreenshot, destinationscreenshot);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Currently this test case skipped"+ result.getName());	
	}


	@Override
	public void onStart(ITestContext context)
	{
		System.out.println("Execution begins..");	
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("Execution got end....");	
	}
	

}
