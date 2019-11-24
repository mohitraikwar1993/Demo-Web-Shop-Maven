package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import generic.AUL;
import generic.BaseTest;
import generic.IAutoConst;
import page.AddProductPage;
import page.DemoWebShopPage;
import page.LoginPage;

public class LoginTest extends BaseTest
{

	@Test(priority=1)
	public void validLogin()
	{
		
		
		
		logger=extent.createTest("Valid Login");
		DemoWebShopPage dp=new DemoWebShopPage(driver);
		
		//Verify title of home page
		dp.verifyTitle(driver, homeTitle );
		
		//click on login link
		dp.clickLogin();	
		
	    LoginPage lp=new LoginPage(driver);
	    
	    //Verify title of login page
	    String eTitle=AUL.getPropertyValue(settingspath,"loginTitle");
	    lp.verifyTitle(driver,eTitle);
	    
	    //enter username
	    String usname=AUL.getPropertyValue(settingspath, "username");
	    lp.setUsrname();
	    
	    //enter password
	    String pswd=AUL.getPropertyValue(settingspath, "password");
	    lp.setPswrd();
	    
	    //click login button
	    lp.clickLogin();
	   
	    AddProductPage ap=new AddProductPage(driver);
	    ap.verifyTAddProd(driver, "Demo Web Shop");
	    
	    
	 	}

	
	@Test(priority=2)
	public void invalidLogin()
	{
		logger=extent.createTest("Invalid Login");
		DemoWebShopPage dp=new DemoWebShopPage(driver);
		
		//Verify title of home page
		dp.verifyTitle(driver, homeTitle );
		
		//click on login link
		dp.clickLogin();	
		
	    LoginPage lp=new LoginPage(driver);
	    
	    //Verify title of login page
	    String eTitle=AUL.getPropertyValue(settingspath,"loginTitle");
	    lp.verifyTitle(driver,eTitle);
	    
	    //enter username
	    String usname=AUL.getPropertyValue(settingspath, "username");
	    lp.setUsrname();
	    
	    //enter password
	    String pswd=AUL.getPropertyValue(settingspath, "password");
	    lp.setPswrd();
	    
	    //click login button
	    lp.clickLogin();
	    
	    //verify error message
	    lp.verifyErrorMsg(driver);
	    
	}
	
	
	
	
}
