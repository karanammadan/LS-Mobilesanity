package lcf_Faces;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Library.Locators;
import Library.MyDriver;
//31
///this is to run
public class PushLCF extends MyDriver implements Locators {

	WebDriver driver;

@Test(enabled=true,priority=0)

	

	public void SDLD_Push_LCF() throws InterruptedException, Exception, IOException{		
	
	
	 
	String url="http://www.sulekha.com/housekeeping-services/chennai";
	Reporter.log(url);	
	 
	ProfilesIni profile = new ProfilesIni();
	FirefoxProfile myprofile = profile.getProfile("default");
	myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
   driver = new FirefoxDriver(myprofile);
    
   
	 driver.navigate().to(url);
	 WebDriverWait w = new WebDriverWait(driver, 20);
	  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[4]/section/div/div/div[1]/div[1]/div/div[1]"))); 

   
//city*********	 
   
	WebElement c= driver.findElement(By.xpath("//div[4]/section/div/div/div[1]/div[1]/div/div[1]"));
	c.click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//li[@data-id='1']")).click();
	Thread.sleep(2000);
	String c1=c.getText();
	System.out.println(c1);
	Thread.sleep(2000);
	Reporter.log("Selected city: "+c1);
	
 
   
//Requirement
   
	Thread.sleep(4000);
	//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti4']")));   
	String t1=driver.findElement(By.xpath("//div[2]/div/div/div[2]/div[2]/ul/li[4]")).getText(); 
	driver.findElement(By.xpath("//div[2]/div/div/div[2]/div[2]/ul/li[4]")).click();  
	Thread.sleep(1000);
	
	System.out.println(t1);
	Reporter.log("Selected Need: "+t1);
	
  
   
 //Select user Mobile
	Thread.sleep(2000);
	//w.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtmobile")));
	   driver.findElement(By.name("lcftxtmobile")).clear();
		 driver.findElement(By.name("lcftxtmobile")).sendKeys(YPMob); 
		 
		 Reporter.log("Entered mobile no. :" +YPMob);
	  
	
   
//select Name   
 
   try{
	   driver.findElement(By.name("lcftxtname")).clear();
		 driver.findElement(By.name("lcftxtname")).sendKeys(YPName); 
		 
		 Reporter.log("Entered Name  :"+YPName);
	   }catch(Exception ie3){
			
		 }	  
   
//select mail id  
   
   try{
	   driver.findElement(By.name("lcftxtemail")).click();
	   driver.findElement(By.name("lcftxtemail")).clear();
	   }catch(Exception ie4){
			
		 }	
   
 //Click Next
   
	try{ 
		 driver.findElement(By.xpath("//button[@class='btn-p getquotesbtn']")).click();
		}catch(Exception ie6){
			System.out.println(ie6);
		}
	Thread.sleep(3000);
	
	
//verify code
	   try{
		
		   w.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtvcode")));
		   Thread.sleep(500);
		   driver.findElement(By.name("lcftxtvcode")).clear();
			 driver.findElement(By.name("lcftxtvcode")).sendKeys(YPVerifyCode); 
			 
		   }catch(Exception ie124){
				
			 }	
	   

//Verify Thank you and Dashboard
		
		for(int k=0;k<=20;k++){
			try{
				if((driver.getCurrentUrl().contains("dashboard"))||driver.findElement(By.cssSelector(".step.step-thank.active")).getText().contains("Thank")){
					  Reporter.log(  "Lcf posted successfully");						
		              break;
				}
				
				System.out.println("Try : "+k);
				Thread.sleep(1000);
				
			}catch(Exception ie9){
				if(k==20){
					  Reporter.log(  "Lcf not posted successfully");
					Assert.fail();
				}
			}
		}
		
		}

/*@AfterMethod
public void closeUrl() throws Exception{
	driver.quit();
	}	*/

}
	

