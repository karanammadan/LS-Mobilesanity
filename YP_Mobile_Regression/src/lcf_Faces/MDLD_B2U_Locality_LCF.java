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
//7
public class MDLD_B2U_Locality_LCF extends DriverScript implements Locators {

int f;
	
	@Test()
	
	public void MDLD_B2U_Locality_LCF() throws InterruptedException, Exception, IOException  {

		String url="http://www.sulekha.com/valet-parking-drivers/chennai";
		System.out.println(url);
		Reporter.log(url);
	
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.navigate().to(url);
	    WebDriverWait w = new WebDriverWait(driver, 20);
		  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-name='Temporary driver']"))); 
	  
		
	  
	    	
	    	String t1= driver.findElement(By.xpath("//li[@data-name='Temporary driver']")).getText();
	    	System.out.println(t1);
    		Reporter.log(t1);
    		driver.findElement(By.xpath("//section/div/div/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/ul/li[1]/label")).click();
    	
	    	
    		
//Data 
	     w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti4']")));
	    	String t3= driver.findElement(By.xpath("//label[@for='smulti4']")).getText();
	    	System.out.println(t3);
	    	Reporter.log(t3);
	    	driver.findElement(By.xpath("//label[@for='smulti4']")).click();
	    	Thread.sleep(1000);
	    
	   	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti10']")));
	    	Thread.sleep(1000);
	    	String t4= driver.findElement(By.xpath("//label[@for='smulti10']")).getText();
	    	System.out.println(t4);
	    	Reporter.log(t4);
	    	driver.findElement(By.xpath("//label[@for='smulti10']")).click();
	    	Thread.sleep(1000);
	    	driver.findElement(By.xpath("//button[@class='btn-p nextBtn nxtbtn']")).click();    	
	    	
	    	   
		   	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti15']")));
		    	Thread.sleep(1000);
		    	String t41= driver.findElement(By.xpath("//label[@for='smulti15']")).getText();
		    	System.out.println(t41);
		    	Reporter.log(t41);
		    	driver.findElement(By.xpath("//label[@for='smulti15']")).click();
		    	driver.findElement(By.xpath("//button[@class='btn-p nextBtn nxtbtn']")).click(); 
		    	Thread.sleep(3000);
		    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    	String t6= driver.findElement(By.xpath("//div[2]/div/div[5]/div/div[2]/div[2]/ul/li[1]/label")).getText();
		    	System.out.println(t6);
		    	Reporter.log(t6);
		    	Thread.sleep(3000);
		    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    	driver.findElement(By.xpath("//div[2]/div/div[5]/div/div[2]/div[2]/ul/li[1]/label")).click();
		    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    	Thread.sleep(1000);

	    
	    
//Select locality
	    
	    try{
	     	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/div[2]/div[2]/div/div/div/div[1]")));
	    	WebElement loc=driver.findElement(By.xpath("//div/div/div[2]/div[2]/div/div/div/div[1]"));
	    	loc.click();
	    	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti33']")));
	    	
	    	
	    	WebElement e1=driver.findElement(By.xpath("//label[@for='smulti33']"));
	    	String s=e1.getText();
	    	e1.click();
	    	Thread.sleep(2000);
	    	loc.click();
	    	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti36']")));
	    	WebElement e2=driver.findElement(By.xpath("//label[@for='smulti36']"));
	    	String s1=e2.getText();
	    	e2.click();
	    	
	    	if(loc.getText().contains(s)){
	    		System.out.println("single locality selection failed:");
	    		Reporter.log("Displayed locality is: "+loc.getText());
	    		Assert.fail();
	    	}else{
	    		System.out.println("Single locality selection pass");
	    		Reporter.log("Displayed locality is :" +loc.getText());
	    		
	    	}
	    	    	    
	    }catch (Exception e){System.out.println(e);}
	    
	    	
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
					  
					   w.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtvcode")));
					   Thread.sleep(500);
					   driver.findElement(By.name("lcftxtvcode")).clear();
						 driver.findElement(By.name("lcftxtvcode")).sendKeys(YPVerifyCode); 
						 
					   }catch(Exception ie124){
							
						 }	
			
				
					 for(int i =0;i<=20;i++){
						 
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
						 	
						 	
						  Thread.sleep(1000); 
						   if(i==20||f==1){
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
