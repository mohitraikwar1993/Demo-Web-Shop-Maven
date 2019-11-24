package generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest implements IAutoConst 
{
	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	static
	{
		System.setProperty(chromekey, chromevale);
		System.setProperty(geckokey, geckovale);
	}
	
	@BeforeTest
	public void startTest()
	{
		htmlReporter=new ExtentHtmlReporter(new File("./WS_Automation"+AUL.getCurrentTime()+".html"));
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Demo Web Shop");
		extent.setSystemInfo("Environment", "Testing");
		extent.setSystemInfo("Username", "Mohit Raikwar");
		
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle("Web Shop Regression Automation Report");
		htmlReporter.config().setReportName("Regression Suit");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);		
	
			
	}
	
	@AfterTest
	public void endTest()
	{
		extent.flush();
		
	}
	
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(String browser)
	{
		if(browser.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
		
		String url=AUL.getPropertyValue(settingspath, "url");
		driver.manage().window().maximize();
		System.out.println(url);
		driver.get(url);
		String ito=AUL.getPropertyValue(settingspath, "ITO");
		long ITO=Long.parseLong(ito);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
		
		
		
	}
	
	 
	@AfterMethod(alwaysRun=true)
	public void closeApp(ITestResult res) throws IOException
	{
		String testName= res.getName();
		if(res.getStatus()==ITestResult.FAILURE)
		{
			AUL.getScreenShot(driver);
			logger.fail("Test Fail", MediaEntityBuilder.createScreenCaptureFromPath(AUL.getScreenShot(driver)).build());
		}
		else if(res.getStatus()==ITestResult.SUCCESS)
		{
			AUL.getScreenShot(driver);
			logger.pass("Test Fail", MediaEntityBuilder.createScreenCaptureFromPath(AUL.getScreenShot(driver)).build());	
		}
		driver.close();
		
	}
	
}	
	