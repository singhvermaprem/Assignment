package com.UpKeep.Utilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class UpKeepAppBase {

	DesiredCapabilities cap = new DesiredCapabilities();
	public static AndroidDriver<MobileElement> driver;
	public WebDriverWait wait;
	LocalDateTime currentTime = LocalDateTime.now();
	DateTimeFormatter dateAndTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
	String timeStamp = currentTime.format(dateAndTime);

	@BeforeTest
	public void StartApp() throws MalformedURLException, InterruptedException {

		File appDir = new File("src");
		File app = new File(appDir, "UpKeep.apk");
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "MyDevice");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability("appPackage", "com.onupkeep");
		cap.setCapability("appActivity", "com.onupkeep.presentation.startup.MainActivity");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

	}

	public boolean findElementByXpath(String path) throws IOException {
		
		WebElement ele = null;
		try {
			wait = new WebDriverWait(driver, 30);
			 ele = wait.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(3))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
			 if(ele.isDisplayed())
			 {
				 ele.click();
			 }
		} catch (NoSuchElementException e2) {
			screenShot("FailImageInCaseNoSuchElementException"+ timeStamp);
			driver.navigate().back();
		} catch (TimeoutException e3) {
			screenShot("FailImageInCaseTimeOut"+ timeStamp);
			driver.navigate().back();
		}catch (Exception e4)
		{
			screenShot("FailImageInCaseErrorUnknown"+ timeStamp);
			System.err.println(e4);
			driver.navigate().back();
		}
		return false;

	}
	
public boolean findElementByXpath(String path, String dataTosend) throws IOException {
		
		WebElement ele = null;
		try {
			wait = new WebDriverWait(driver, 30);
			 ele = wait.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(3))
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
			 if(ele.isDisplayed())
			 {
				 ele.sendKeys(dataTosend);
			 }
		} catch (NoSuchElementException e2) {
			screenShot("FailImageInCaseNoSuchElementException"+ timeStamp);
			driver.navigate().back();
		} catch (TimeoutException e3) {
			screenShot("FailImageInCaseTimeOut"+ timeStamp);
			driver.navigate().back();
		}catch (Exception e4)
		{
			screenShot("FailImageInCaseErrorUnknown"+ timeStamp);
			System.err.println(e4);
			driver.navigate().back();
		}
		return false;

	}

	public boolean findElementById(String path) throws IOException {
		WebElement ele = null;
		try {
			wait = new WebDriverWait(driver, 30);
			 ele = wait.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(3))
					.until(ExpectedConditions.visibilityOfElementLocated(By.id(path)));
			if(ele.isDisplayed())
			{
				ele.click();
			}
		}
		catch (NoSuchElementException e2) {
			screenShot("FailImageInCaseNoSuchElementException"+ timeStamp);
			driver.navigate().back();
		} catch (TimeoutException e3) {
			screenShot("FailImageInCaseTimeOut"+ timeStamp);
			driver.navigate().back();
		} catch (Exception e4)
		{
			screenShot("FailImageInCaseErrorUnknown"+ timeStamp);
			System.err.println(e4);
			driver.navigate().back();
		}
		return false;
	}
	
	public boolean findElementById(String path, String dataTosend) throws IOException {
		WebElement ele = null;
		try {
			wait = new WebDriverWait(driver, 30);
			 ele = wait.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(3))
					.until(ExpectedConditions.visibilityOfElementLocated(By.id(path)));
			if(ele.isDisplayed())
			{
				ele.sendKeys(dataTosend);
			}
		}
		catch (NoSuchElementException e2) {
			screenShot("FailImageInCaseNoSuchElementException"+ timeStamp);
			driver.navigate().back();
		} catch (TimeoutException e3) {
			screenShot("FailImageInCaseTimeOut"+ timeStamp);
			driver.navigate().back();
		}catch (Exception e4)
		{
			screenShot("FailImageInCaseErrorUnknown"+ timeStamp);
			System.err.println(e4);
			driver.navigate().back();
		}
		return false;
	}

	public boolean findElementsById(String path, int index) throws IOException {
		
		List<WebElement> ele = null;
		try {
			wait = new WebDriverWait(driver, 30);
			ele = wait.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(3))
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(path)));
			if(ele.size()>0 || ele.get(0).isDisplayed())
			{
				ele.get(index).click();
			}
		} catch (NoSuchElementException e2) {
			screenShot("FailImageInCaseNoSuchElementException"+ timeStamp);
			driver.navigate().back();
		} catch (TimeoutException e3) {
			screenShot("FailImageInCaseTimeOut"+ timeStamp);
			driver.navigate().back();
		}catch (Exception e4)
		{
			screenShot("FailImageInCaseErrorUnknown"+ timeStamp);
			System.err.println(e4);
			driver.navigate().back();
		}
		return false;

	}
	
public boolean findElementsById(String path,String dataTosend, int index) throws IOException {
		
		List<WebElement> ele = null;
		try {
			wait = new WebDriverWait(driver, 30);
			ele = wait.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(3))
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(path)));
			if(ele.size()>0 || ele.get(0).isDisplayed())
			{
				ele.get(index).sendKeys(dataTosend);
			}
		} catch (NoSuchElementException e2) {
			screenShot("FailImageInCaseNoSuchElementException"+ timeStamp);
			driver.navigate().back();
		} catch (TimeoutException e3) {
			screenShot("FailImageInCaseTimeOut"+ timeStamp);
			driver.navigate().back();
		}catch (Exception e4)
		{
			screenShot("FailImageInCaseErrorUnknown"+ timeStamp);
			System.err.println(e4);
			driver.navigate().back();
		}
		return false;

	}

	public boolean findElementsByClass(String path,int index) throws IOException {
		List<WebElement> ele = null;
		try {
			wait = new WebDriverWait(driver, 30);
			ele = wait.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(3))
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(path)));
			if(ele.size()>0 || ele.get(0).isDisplayed())
			{
				ele.get(index).click();
			}

		} catch (NoSuchElementException e2) {
			screenShot("FailImageInCaseNoSuchElementException"+ timeStamp);
			driver.navigate().back();
		} catch (TimeoutException e3) {
			screenShot("FailImageInCaseTimeOut"+ timeStamp);
			driver.navigate().back();
		}catch (Exception e4)
		{
			screenShot("FailImageInCaseErrorUnknown"+ timeStamp);
			System.err.println(e4);
			driver.navigate().back();
		}
		return false;

	}
	
	public boolean findElementsByClass(String path,String dataToSend, int index) throws IOException {
		List<WebElement> ele = null;
		try {
			wait = new WebDriverWait(driver, 30);
			ele = wait.ignoring(NoSuchElementException.class).pollingEvery(Duration.ofSeconds(3))
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className(path)));
			if(ele.size()>0 || ele.get(0).isDisplayed())
			{
				ele.get(index).sendKeys(dataToSend);
			}

		} catch (NoSuchElementException e2) {
			screenShot("FailImageInCaseNoSuchElementException"+ timeStamp);
			driver.navigate().back();
		} catch (TimeoutException e3) {
			screenShot("FailImageInCaseTimeOut"+ timeStamp);
			driver.navigate().back();
		}catch (Exception e4)
		{
			screenShot("FailImageInCaseErrorUnknown"+ timeStamp);
			System.err.println(e4);
			driver.navigate().back();
		}
		return false;

	}

	public static String screenShot(String fileName) throws IOException {

		TakesScreenshot sc = (TakesScreenshot) driver;
		File srcFile = sc.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")+"/Screenshots/"+fileName+".png");
		FileUtils.copyFile(srcFile, destFile);
		String errflpath = destFile.getAbsolutePath();
		return errflpath;
		
	}

}
