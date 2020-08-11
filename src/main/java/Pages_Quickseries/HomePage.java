package Pages_Quickseries;


import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    
    By menuIcon = By.cssSelector(".fa-bars");
    By slideMenu = By.id("slideMenu");
    By contactUs = By.linkText("Contact Us");
    By validatecontactus=By.cssSelector("h3:nth-child(1)");
    By validatefirstnamelabel=By.cssSelector(".form-group:nth-child(1) > label");
    By submitButton = By.cssSelector(".wpcf7-submit");
    By validateError = By.cssSelector(".wpcf7-response-output");
   

	private WebDriver driver;

    public HomePage(WebDriver driver){

        this.driver = driver;

    }

    

    public void menuIcon() throws InterruptedException{

    	//Click on Menu Icon from the left 
        driver.findElement(menuIcon).click();
        Thread.sleep(5000);
	    {
	    	
	    	//Scroll down using slide menu
	        WebElement element = driver.findElement(slideMenu);
	        Actions builder = new Actions(driver);
	        builder.moveToElement(element).clickAndHold().perform();
	      }
	    Thread.sleep(3000);
	      {
	        WebElement element = driver.findElement(slideMenu);
	        Actions builder = new Actions(driver);
	        builder.moveToElement(element).perform();
	      }
	      Thread.sleep(3000);
	      {
	        WebElement element = driver.findElement(slideMenu);
	        Actions builder = new Actions(driver);
	        builder.moveToElement(element).release().perform();
	      }

    }
    public void contactUs() {
    	
    	//Click on ContactUs from the Menu list
    driver.findElement(contactUs).click();
    //Verify the elements in a page(Elements should be >0)
    {
    	
    	List<WebElement> elements = driver.findElements(By.cssSelector(".no-margin-top"));
        assert(elements.size() > 0);
      }
    }
    
    // Retrieve  ContactUs text 
    public String validatecontactus(){

     return    driver.findElement(validatecontactus).getText();

    }
    
    //Retrieve  firstname label from the form
    public String validatefirstnamelabel(){

        return    driver.findElement(validatefirstnamelabel).getText();

       }
    
    //Retrive Submit button text
    public List<WebElement> validatesubmitbutton(){

        return    driver.findElements(submitButton);

       }
    
    //Click on Submit button
    public void ClicksubmitButton() {
        driver.findElement(submitButton).click();
    }
    
    //Retrieve  error message
    public String validateError(){

        return    driver.findElement(validateError).getText();

       }
   

   
          
    }






