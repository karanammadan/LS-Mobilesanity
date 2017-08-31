package lcf_Faces;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Library.DriverScript;
import Library.Locators;
//25
public class SDLD_With_Locality extends DriverScript implements Locators {
	
	int f;
	
	@Test()
	
	public void lcfposting() throws InterruptedException, Exception, IOException  {
		
		 
		String url="http://www.sulekha.com/pest-control-services/thane-west-mumbai";
		Reporter.log(url);
	
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.get(url);
	    
	    WebDriverWait w = new WebDriverWait(driver, 20);
		  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[4]/section/div/div/div[1]/div[2]/div/div/div[1]"))); 

//Select need	
	    	Thread.sleep(1000);
	    	driver.findElement(By.xpath("//div[4]/section/div/div/div[1]/div[2]/div/div/div[1]")).isDisplayed();    	
    		String n=driver.findElement(By.xpath("//label[@for='smulti1']")).getText();
    	System.out.println(n);
    	Reporter.log("Selected Need: "+n);
    	driver.findElement(By.xpath("//label[@for='smulti1']")).click();
    	
    	 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/div[2]/div[2]/div/div/div/div[1]")));    
	  

	  
	    
//Select locality	
	    	  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/div[2]/div[2]/div/div/div/div[1]")));		    
	    		JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,-250)", "");				
	    	WebElement loc= driver.findElement(By.xpath("//div/div/div[2]/div[2]/div/div/div/div[1]"));	    
	    if(loc.getText().contains("Thane-west")){
	    	Reporter.log("Locality preselected");
	    }else{
	    	Reporter.log("Locality not preselected");
	    	Assert.fail();
	    }  
	    	
//Select user Mobile
			 
			
				   driver.findElement(By.name("lcftxtmobile")).clear();
					 driver.findElement(By.name("lcftxtmobile")).sendKeys(YPMob); 
					 
					 Reporter.log("Entered mobile no.: "+YPMob); 
			   
//select Name 			
				   driver.findElement(By.name("lcftxtname")).clear();
					 driver.findElement(By.name("lcftxtname")).sendKeys(YPName); 
					 
					 Reporter.log("Entered Name: "+YPName);
				
			   
//select mail id  
			   
			
				   driver.findElement(By.name("lcftxtemail")).click();
				   driver.findElement(By.name("lcftxtemail")).clear();
				   
			
//Click Next			   
			
					 driver.findElement(By.xpath("//section/div/div/div[2]/div[9]/button[2]")).click();
						
				
				
//Verify code
				
					 
					   w.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtvcode")));
					   Thread.sleep(500);
					   driver.findElement(By.name("lcftxtvcode")).clear();
						 driver.findElement(By.name("lcftxtvcode")).sendKeys(YPVerifyCode); 
					  
	

for(int i =0;i<=20;i++){
//	   System.out.println(i);
	 	try{
	 		Thread.sleep(1000);
	 		System.out.println(i+"outside");
	 		if(i==10||i==15||i==20)
	 		{
	 			driver.navigate().refresh();
	 		}
	   if(driver.getCurrentUrl().contains("dashboard")&&(driver.findElement(By.xpath("//*[@id='div_listcard_0']/div[1]/div[2]/div/ul/li[1]/a")).getText().contains("Matched"))){
		System.out.println(i+"inside");
		  Reporter.log(  "Lead distribution is taking below 20 sec");
		  break;
	   }			
      }catch(Exception ie8){
   	   
      }					
	   if(i==20||f==1){
		   Reporter.log(  "Lead distribution is taking more than 20 sec");
		   //Assert.fail();
	   }
	   Thread.sleep(1000);
	 }
				  	}
		
		@AfterTest
		public void after(){
	//driver.quit();
		}
	

}
