package com.qa.testBase;

import java.time.Duration;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.qa.pageLayer.HomePage;
import com.qa.pageLayer.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Logger logger;
	public HomePage home;
	public LoginPage login;
	
	@BeforeClass
	public void start()
	{
		logger = Logger.getLogger("May07DatalStreet");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Framework execution started");
	}
	
	@AfterClass
	public void stop()
	{
		logger.info("Framework execution Stopped");
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String br)
	{	
		if(br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome lauches");
		}
		else if (br.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (br.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please provide correct browser name");
		}
		
		driver.get("https://sakshingp.github.io/assignment/login.html");
		logger.info("url launches");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		logger.info("deleted all the cookies, pageload timeout provided");
		
		home = new HomePage();
		login = new LoginPage();
		
	}
	
	@AfterMethod
	public void tearDown()
	{
//	driver.quit();
	}
}
