package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class DemoWebShopPage
{
	@FindBy(linkText="Log in")
	private WebElement loginLink;
	
	@FindBy(linkText="Register")
	private WebElement registerLink;
	
	
	public DemoWebShopPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickLogin()
	{
		loginLink.click();
	}
	
	public void clickRegister()
	{
		registerLink.click();
	}
	
	public void verifyTitle(WebDriver driver, String eTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10 );
		try
		{
		wait.until(ExpectedConditions.titleIs(eTitle));
		Reporter.log("Home Page displayed", true);
		
		}
		catch(Exception e)
		{
			Reporter.log("Home Page not displayed", true);
			Assert.fail();
		}
		
	}
}
