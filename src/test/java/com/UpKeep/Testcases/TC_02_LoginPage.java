package com.UpKeep.Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.UpKeep.Utilities.PropertyFileReader;
import com.UpKeep.Utilities.UpKeepAppBase;

public class TC_02_LoginPage extends UpKeepAppBase {
	
	PropertyFileReader pf = new PropertyFileReader();
	
	@Test
	public void LoginPage() throws IOException
	{
		findElementByXpath(pf.property("logInlink"));
		findElementByXpath(pf.property("emailIdField"),"stevon1@whoisox.com");
		findElementByXpath(pf.property("passWordFieldLogin"),"Testing@1432");
		findElementByXpath(pf.property("LoginButton"));
		findElementById(pf.property("CrossButton"));


	}

}
