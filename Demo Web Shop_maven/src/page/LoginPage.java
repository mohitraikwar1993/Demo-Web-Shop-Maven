package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generic.AUL;
import generic.IAutoConst;

public class LoginPage implements IAutoConst
{
	@FindBy(id="Email")
	private WebElement username;
	
	@FindBy(id="Password")
	private WebElement pswrd;
	
	@FindBy(xpath="//input[@value=\"Log in\"]")
	private WebElement login;
	
	@FindBy(xpath="//span[.='Login was unsuccessful. Please correct the errors and try again.']")
	private WebElement error1;
	
	@FindBy(xpath="//li[.='The credentials provided are incorrect']")
	private WebElement error2;
	
	
	public LoginPage(WebDriver driver)
	{
	PageFactory.initElements(driver,this);	
	}
	
	
	public void setUsrname()
	{
		String un=AUL.getPropertyValue(settingspath, "username");
		username.sendKeys(un);
	}
	
	public void setPswrd()
	{
		String pw=AUL.getPropertyValue(settingspath, "password");
		pswrd.sendKeys(pw);
		
	}
	
	
	public void clickLogin()
	{
		login.click();
	}
	
	
	public void verifyTitle(WebDriver driver,String eTitle)
	{
		WebDriverWait wait= new WebDriverWait(driver, 10);
		
		try
         {
	     wait.until(ExpectedConditions.titleIs(eTitle));
	     Reporter.log("login successful",true);
	     }
				
	catch(Exception e)
		{
		Reporter.log("login not successful",true);
		}
	}
	
   public void verifyErrorMsg(WebDriver driver)
    {
	  WebDriverWait wait= new WebDriverWait(driver, 10);
	  
	  try
	  {
		  wait.until(ExpectedConditions.visibilityOf(error1));
		  wait.until(ExpectedConditions.visibilityOf(error2));
		  Reporter.log("Error message displayed",true);
	  }
	  
	  catch(Exception e)
	  {
		  Reporter.log("error message not displayed",true);
		  Assert.fail();
	  }	  
   }
}
