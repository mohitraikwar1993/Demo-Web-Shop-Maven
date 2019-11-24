package scripts;
import org.testng.annotations.Test;

import generic.AUL;
import generic.BaseTest;
import page.AddProductPage;
import page.DemoWebShopPage;
import page.LoginPage;

public class AddProductTest extends BaseTest
{
	
	@Test(priority=1)
	public void addDesktop()
	{
		DemoWebShopPage dm=new DemoWebShopPage(driver);
		dm.verifyTitle(driver, homeTitle);
		dm.clickLogin();
		LoginPage lp=new LoginPage(driver);
		String eTitle=AUL.getPropertyValue(settingspath,"loginTitle");
		lp.verifyTitle(driver, eTitle);
		lp.setUsrname();
        lp.setPswrd();
        lp.clickLogin();
        AddProductPage ap= new AddProductPage(driver);
        ap.clickComp(driver);
        
        String cTitle=AUL.getPropertyValue(settingspath, "compTitle");
        ap.verifyTAddProd(driver,cTitle);
        ap.hoverToComputer(driver);
        ap.clickDesktop(driver);
        
	}

}
