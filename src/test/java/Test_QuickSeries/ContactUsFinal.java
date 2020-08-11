package Test_QuickSeries;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages_Quickseries.HomePage;



public class ContactUsFinal {

	
    	    
	WebDriver driver ; 
	
	HomePage objPage;
	 
       
  //Launch the browser & Navigate to QuickSeries URL
   
	@BeforeTest
    public void LaunchQuickseries(){
   	   
		
		String relativePath = new File(System.getProperty("user.dir"))
				.getAbsolutePath();
		
				
		File file = new File(relativePath+"\\src\\test\\resources\\Globalpropeties.properties");
		  
		
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		
		//load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
			String baseUrl = prop.getProperty("ApplicationURL");
			
			String driverPath = prop.getProperty("Driverpath");
		
		
    System.setProperty("webdriver.chrome.driver", driverPath);
    driver = new ChromeDriver();
    driver.get(baseUrl);
    driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    driver.manage().window().maximize();
   
    // Verify if QuickSeriesis displayed
    
    String expectedTitle = "QuickSeries | Reliable Content. Innovative Delivery.";
    String actualTitle = driver.getTitle();
    Assert.assertEquals(actualTitle, expectedTitle);
    System.out.println("QuickSeries home page is displyed successfully");
	
    }
    
	
    //Click on ContactUs from menu and verify if ContactUs page is displayed successfully
        
    @Test ()
    public void UserStory1() throws InterruptedException {
    	
    
    			
		objPage=new HomePage(driver);
		objPage.menuIcon();	   
	    objPage.contactUs();	   
	    String Verifycontactus = objPage.validatecontactus();
	    Assert.assertEquals(Verifycontactus,"Contact us");
	    String Verifyfirstname = objPage.validatefirstnamelabel();
	    Assert.assertEquals(Verifyfirstname,"First Name *");
	    
	    {
	      List<WebElement> elements = objPage.validatesubmitbutton();
	      assert(elements.size() > 0);
	    }
	
		/*
		 * objPage.ClicksubmitButton(); Thread.sleep(5000);
		 * 
		 * String VerifyError = objPage.validateError();
		 * Assert.assertEquals(VerifyError,
		 * "One or more fields have an error. Please check and try again.");
		 */
		
    }
    
    @Test ()
        public void Userstory2() throws InterruptedException {
    	
    	objPage.ClicksubmitButton();
	    Thread.sleep(5000);
	  
	    String VerifyError = objPage.validateError();
	    Assert.assertEquals(VerifyError, "One or more fields have an error. Please check and try again.");
	  
    	
    }
   
    @AfterTest
    public void closeapplication(){
    driver.close();
    	
    }
    
    }
 
