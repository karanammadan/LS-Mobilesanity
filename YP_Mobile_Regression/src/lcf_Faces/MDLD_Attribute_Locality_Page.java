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
//3
public class MDLD_Attribute_Locality_Page extends DriverScript implements Locators {
	
	int f;
	
	@Test()
	
	public void MDLD_Attribute_Locality_Page() throws InterruptedException, Exception, IOException  {

		String url="http://www.sulekha.com/residential-cleaning-services/anna-salai-chennai";
		System.out.println(url);
		Reporter.log(url);
	
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.navigate().to(url);
	    WebDriverWait w = new WebDriverWait(driver, 30);
	    Thread.sleep(2000);
		  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-selected='true']"))); 
	  
    		
		  Thread.sleep(1000);
	    	String t2= driver.findElement(By.xpath("//li[@data-selected='true']")).getText();
	    	if(!t2.equals("Residential")){
	    		System.out.println("Attribute preselect failed");
	    		Reporter.log("Attribute preselect failed");
	    	}else{
	    		System.out.println("Attribute preselected: "+t2);
	    		Reporter.log("Attribute preselected: "+t2);
	    	}
	    	
	    
	    	driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();
	    	
//Data 
	    	  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti5']")));
	    	
	    	String t3= driver.findElement(By.xpath("//label[@for='smulti5']")).getText();
	    	System.out.println(t3);
	    	Reporter.log(t3);
	    	driver.findElement(By.xpath("//label[@for='smulti5']")).click();
	    	Thread.sleep(1000);
	    	driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();	
	    	  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti10']")));
	    	  driver.findElement(By.xpath("//label[@for='smulti10']")).click();
		    	Thread.sleep(1000);
		    	driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();
//Select locality
	    
	    try{
	    	  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div/div[2]/div[2]/div/div/div/div[1]")));
	    	WebElement loc= driver.findElement(By.xpath("//div/div/div[2]/div[2]/div/div/div/div[1]"));
	    	String l=loc.getText();
	    	
	    	if(!l.equals("Anna-salai"))
	    	{	    		
	    		System.out.println(l);
	    		Reporter.log("Locality pre select - FAIL ");
	    	}else {
	    		System.out.println(l);
	    		Reporter.log("Locality pre select - pass: "+l);
	    	}
	    }catch (Exception e){System.out.println(e);}
	    
	    Thread.sleep(4000);	
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
						 		System.out.println("Try : "+i);
								   if(driver.getCurrentUrl().contains("dashboard")){					
									  Reporter.log(  "Lcf posted successfully");
									  break;
								   }			
							       }catch(Exception ie694){
							    	   
							       }
						 	
						 	
						  Thread.sleep(2000); 
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
