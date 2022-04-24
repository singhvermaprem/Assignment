package com.UpKeep.Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.UpKeep.Utilities.PropertyFileReader;
import com.UpKeep.Utilities.UpKeepAppBase;

import io.appium.java_client.MobileBy;

public class TC_03_CreateWorkOrder extends UpKeepAppBase{
	
	PropertyFileReader prop = new PropertyFileReader();
	TC_04_Logout logout = new TC_04_Logout();
	
	@Test
	public void createWorkOrder() throws InterruptedException, IOException
	{

		findElementById(prop.property("addWorkOrder"));
		findElementByXpath(prop.property("createWorkOrder"));
		findElementByXpath(prop.property("titleFieldAddWorkOrder"),"Test Title");
		findElementById(prop.property("descriptionField"),"Test Description");
		findElementById(prop.property("priorityRadio"));
		findElementByXpath(prop.property("addWorker"));
		findElementsById(prop.property("SelectFirstperson"), 0);
		findElementByXpath(prop.property("additionalWorker"));
		findElementsById(prop.property("SelectAdditionalPerson"),0);
		findElementByXpath(prop.property("asset"));
		findElementsById(prop.property("SelectAsset"),0 );
		findElementByXpath(prop.property("image"));
		findElementByXpath(prop.property("TakeFromGallary"));
		driver.switchTo().alert().accept();
		findElementByXpath(prop.property("GrabPicFromCam"));
		Thread.sleep(2000);
		findElementsByClass(prop.property("SelectingPic"),0);
		findElementById(prop.property("UsingPic"));
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Checklists\"))"));
		findElementByXpath(prop.property("dueDate"));
		findElementByXpath(prop.property("OkButtonOfCal"));
		findElementByXpath(prop.property("repeatingSchedule"));
		findElementByXpath(prop.property("Every2Month"));
		findElementByXpath(prop.property("DoneButton"));
		findElementByXpath(prop.property("Category"));
		findElementByXpath(prop.property("Electrical"));
		findElementByXpath(prop.property("SAVEbutton"));
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"SAVE\"))"));
		findElementByXpath(prop.property("saveButton"));
		logout.Logout();
		
		


		

	}

}
