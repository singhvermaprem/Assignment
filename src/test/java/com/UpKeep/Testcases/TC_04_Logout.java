package com.UpKeep.Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.UpKeep.Utilities.PropertyFileReader;
import com.UpKeep.Utilities.UpKeepAppBase;

public class TC_04_Logout extends UpKeepAppBase{
	
	PropertyFileReader prop = new PropertyFileReader();
	
	@Test
	public void Logout() throws IOException, InterruptedException {
		
		findElementById(prop.property("settingIcon"));
		findElementById(prop.property("Logout"));
		findElementByXpath(prop.property("OkButtonOfCal"));

		
	}

}
