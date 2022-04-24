package com.UpKeep.Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.UpKeep.Utilities.PropertyFileReader;
import com.UpKeep.Utilities.UpKeepAppBase;

public class TC_01_SignUp extends UpKeepAppBase{
	
	PropertyFileReader pf = new PropertyFileReader();
	
	@Test
	public void signUpFirstTime() throws IOException, InterruptedException {
		

		findElementByXpath(pf.property("signUpForFreeButton"));
		findElementByXpath(pf.property("workEmailField"), "stevon1@whoisox.com");
		findElementByXpath(pf.property("passwordField"), "Testing@1432");
		findElementByXpath(pf.property("firstNameField"), "Test");
		findElementByXpath(pf.property("lastNameField"), "Engineer");
		
		findElementById(pf.property("countryCodeChanger"));
		findElementByXpath(pf.property("countrySearch"), "India");
		findElementByXpath(pf.property("findingIndia"));
		
		findElementById(pf.property("mobileNumberField"), "9664297464");
		findElementByXpath(pf.property("companyNameField"), "NoNameOfCompany");
		findElementByXpath(pf.property("titleField"), "STE");
		findElementByXpath(pf.property("getStartedButton"));
		findElementByXpath(pf.property("chooseBusinessType"));
		findElementById(pf.property("CrossButton"));
	}

}