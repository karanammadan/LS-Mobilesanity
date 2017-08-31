package lcf_Faces;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
//12
public class MDLD_Profile_Paid_Getquote extends DriverScript implements Locators {
	
	int f;
	
	@Test()
	
	public void MDLD_Profile_Paid_Getquote() throws InterruptedException, Exception, IOException  {
	
		String url="http://www.sulekha.com/vls-logistic-supply-chain-service-isanpur-ahmedabad-contact-address#popup";
		Reporter.log(url);
	
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.navigate().to(url);
	    
	    WebDriverWait w = new WebDriverWait(driver, 20);
			  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-p proceed-btn GAQ_LCF_PROCEED']")));     
		    	
	
	    	
	    	driver.findElement(By.xpath("//button[@class='btn-p proceed-btn GAQ_LCF_PROCEED']")).click();
	    	
	    	 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti1']")));
	    	
	    	driver.findElement(By.xpath("//label[@for='smulti1']")).isDisplayed();
	    	String t1= driver.findElement(By.xpath("//label[@for='smulti1']")).getText();
	    	System.out.println(t1);
    		Reporter.log(t1);
    		driver.findElement(By.xpath("//label[@for='smulti1']")).click();
    		
    		 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[2]/div[2]/div[1]/div/div[2]/div[2]/ul/li[1]/label")));
	    	String t2= driver.findElement(By.xpath("//div[1]/div[2]/div[2]/div[1]/div/div[2]/div[2]/ul/li[1]/label")).getText();
	    	System.out.println(t2);
    		Reporter.log(t2);
    		driver.findElement(By.xpath("//div[1]/div[2]/div[2]/div[1]/div/div[2]/div[2]/ul/li[1]/label")).click(); 
    			
    		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[2]/div/div[2]/div[2]/ul/li[1]/label")));
	    	String t3= driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div[2]/ul/li[1]/label")).getText();
	    	System.out.println(t3);
    		Reporter.log(t3);
    		driver.findElement(By.xpath("//div[2]/div[2]/div/div[2]/div[2]/ul/li[1]/label")).click(); 
    		driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();
    		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtmobile")));
	    
//Select user Mobile
			 
			   try{
				   driver.findElement(By.name("lcftxtmobile")).clear();
					 driver.findElement(By.name("lcftxtmobile")).sendKeys(YPMob); 
					 
					 Reporter.log("Entered mobile no.: "+YPMob);
				   }catch(Exception ie2){
						
					 }	  
				
			   
//select Name   
			 
			   try{
				   driver.findElement(By.name("lcftxtname")).clear();
					 driver.findElement(By.name("lcftxtname")).sendKeys(YPName); 
					 
					 Reporter.log("Entered Name: "+YPName);
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
					 driver.findElement(By.xpath("//button[@onclick='lcf_v1.getquotes(2)']")).click();
					}catch(Exception ie6){
						System.out.println(ie6);
					}				
				
				
//Verify code
				   try{
					
					   w.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtvcode")));
					   Thread.sleep(500);
					   driver.findElement(By.name("lcftxtvcode")).clear();
						 driver.findElement(By.name("lcftxtvcode")).sendKeys(YPVerifyCode); 
						 
					   }catch(Exception ie124){
							
						 }	
				   
				   
//Verify button
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
									  Reporter.log("Lcf posted successfully");
									  break;
								   }			
							       }catch(Exception ie694){
							    	   
							       }
						 	
						 	
						  Thread.sleep(1000); 
						   if(i==10||f==1){
							   Reporter.log("Lcf not posted successfully");
							   Assert.fail();
						   }
						 }
					  
	 
				  	}
		
		@AfterTest
		public void after(){
		driver.quit();
		}

}
