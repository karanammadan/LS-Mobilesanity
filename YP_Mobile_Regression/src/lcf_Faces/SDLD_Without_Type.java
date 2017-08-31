package lcf_Faces;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
//26
public class SDLD_Without_Type extends DriverScript implements Locators {

int f;
	
	@Test()
	
	public void SDLD_Without_Type() throws InterruptedException, Exception, IOException  {

		String url="http://www.sulekha.com/physiotherapists/chennai";
		System.out.println(url);
		Reporter.log(url);
	
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.navigate().to(url);
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	// click next
	    driver.findElement(By.xpath("html/body/div[4]/section/div/div[1]/div[1]/div[3]/button[2]")).click();
	    Thread.sleep(3000);
	    
	    String S=driver.findElement(By.xpath("html/body/div[4]/section/div/div[1]/div[2]/div[1]/span[1]")).getText();
	    if (S.contains("You're almost done!")){ 
	    	System.out.println("Physiotherapist type is pre selected");
	    	Reporter.log("Physiotherapist type is pre selected");
	    }else {
	    	System.out.println("Physiotherapist type is not pre selected");
	    	Reporter.log("Physiotherapist type is not pre selected");
	    	Assert.fail();
	    }
	    
//Select locality
	    
	    try{
	    	Thread.sleep(2000);
	    	WebElement loc=driver.findElement(By.xpath("//div/div/div[2]/div[2]/div/div/div/div[1]"));
	    	loc.click();
	    	Thread.sleep(3000);
	    	
	    	
	    	WebElement e1=driver.findElement(By.xpath("html/body/div[4]/section/div/div/div[2]/div[2]/div/div/div/div[2]/div[3]/ul/li[2]/label"));
	    	String s=e1.getText();
	    	e1.click();
	    	Thread.sleep(3000);
	    	
	    	driver.findElement(By.linkText("Done")).click();
	    	
	    	    	    
	    }catch (Exception e){}
	    
	    	
//Select user Mobile
			 
			   try{
				   driver.findElement(By.name("lcftxtmobile")).clear();
					 driver.findElement(By.name("lcftxtmobile")).sendKeys(YPMob); 
					 
					 Reporter.log("selected mobile  :"+YPMob);
				   }catch(Exception ie2){
						
					 }	  
				
			   
//select Name   
			 
			   try{
				   driver.findElement(By.name("lcftxtname")).clear();
					 driver.findElement(By.name("lcftxtname")).sendKeys(YPName); 
					 
					 Reporter.log("selected Name  :"+YPName);
				   }catch(Exception ie3){
						
					 }	  
			   
//select mail id  
			   
			   try{
				   driver.findElement(By.name("lcftxtemail")).click();
				   driver.findElement(By.name("lcftxtemail")).clear();
				   }catch(Exception ie4){
						
					 }	
			   
//Time pref.
				
			   try{
					/* driver.findElement(By.xpath("//div[4]/section/div/div/div[2]/div[5]/div/div/div[1]")).click();	
					 Thread.sleep(3000);*/
					 driver.findElement(By.xpath("//label[@for='smulti27']")).click();
			//		 Thread.sleep(2000);
					}catch(Exception ie5){
						
					}
			   
			   
			
//Click Next
			   
				try{ 
					 driver.findElement(By.xpath("//button[@onclick='lcf_v1.getquotes(2)']")).click();
					}catch(Exception ie6){
						System.out.println(ie6);
					}
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				
	//verify code
				   try{
					   WebDriverWait w=new WebDriverWait(driver, 30);
					   w.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtvcode")));
					   Thread.sleep(500);
					   driver.findElement(By.name("lcftxtvcode")).clear();
						 driver.findElement(By.name("lcftxtvcode")).sendKeys(YPVerifyCode); 
						 
					   }catch(Exception ie124){
							
						 }	
				   
				   
	//verify button
					try{
				//		Thread.sleep(500);
						 driver.findElement(By.xpath("//button[@onclick='lcf_v1.btnverify(this)']")).click();	
						}catch(Exception ie221){
							
						}


					driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
					
					 for(int i =0;i<=10;i++){
						 
						 	try{		
						   if(driver.findElement(By.cssSelector(".step.success-message.thank-you-step>h4")).getText().contains("Thank")){
							
							  Reporter.log(  "Lcf posted successfully");
							  break;
						   }			
					       }catch(Exception ie8){
					    	   
					       }
						 
						 	try{
						 		System.out.println("Try : "+i);
								   if(driver.getCurrentUrl().contains("dashboard")){					
									  Reporter.log(  "Lcf posted successfully");
									  break;
								   }			
							       }catch(Exception ie694){
							    	   
							       }
						 	
						 	
						  Thread.sleep(2000); 
						   if(i==10||f==1){
							   Reporter.log(  "Lcf not posted successfully");
							   Assert.fail();
						   }
						 }
					  
	 
				  	}
		
		@AfterTest
		public void after(){
		driver.quit();
		}
	

	
}
