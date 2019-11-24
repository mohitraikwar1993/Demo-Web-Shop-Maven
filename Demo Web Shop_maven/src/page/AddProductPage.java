package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class AddProductPage {
     
	@FindBy(partialLinkText="Computers")
     private WebElement comp;
	
	@FindBy(xpath="(//a)[13]")
	private WebElement deskp;
	
	public AddProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
    public void verifyTAddProd(WebDriver driver ,String eTitle)
    {
    	WebDriverWait wait= new WebDriverWait(driver, 10);
    	
    	try 
    	{
    	wait.until(ExpectedConditions.titleIs(eTitle))	;
    	Reporter.log("Computer Title is displayed",true);
    	}
    	
    	catch(Exception e)
    	{
    		Reporter.log("computer title not displayed",true);
    		Assert.fail();
    	}
    }
	public void hoverToComputer(WebDriver driver)
	{
		Actions ac=new Actions(driver) ;
		ac.moveToElement(comp).perform();
	}
	public void clickComp(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(comp));
		comp.click();
	}
	public void clickDesktop(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(deskp));

		deskp.click();
	}
}
