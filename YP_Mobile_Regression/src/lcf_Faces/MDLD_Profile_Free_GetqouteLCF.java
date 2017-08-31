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
//11
public class MDLD_Profile_Free_GetqouteLCF extends DriverScript implements Locators {

int f;
	
	@Test()
	
	public void MDLD_Profile_Free_GetqouteLCF() throws InterruptedException, Exception, IOException  {

		String url="http://www.sulekha.com/gopalakrishna-driving-school-kelambakkam-chennai-contact-address";
		System.out.println(url);
		Reporter.log(url);
	
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.navigate().to(url);
	    
	    WebDriverWait w = new WebDriverWait(driver, 20);
		  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[4]/ul/li[3]/button"))); 
	    
	  
	    driver.findElement(By.xpath("//div[4]/ul/li[3]/button")).click();
	    System.out.println("sucessfully clicked on get quotes");
		
	    try{
	    	  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[2]/div[1]/div/div[2]/div[2]/ul/li[1]/label"))); 
	  	    
	    	String t1= driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div[2]/div[2]/ul/li[1]/label")).getText();
	    	System.out.println(t1);
    		Reporter.log(t1);
    		driver.findElement(By.xpath("//div[1]/div[2]/div[1]/div/div[2]/div[2]/ul/li[1]/label")).click();
    		  	    	

	    	
//Data 
	    	
    		 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/section/div/div/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[3]/ul/li[4]/label")));
	    	String t2= driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[3]/ul/li[4]/label")).getText();
	    	System.out.println(t2);
	    	Reporter.log(t2);
	    	driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[3]/ul/li[4]/label")).click();
	    	Thread.sleep(1000);
	    	driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();
	    	 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[2]/div[2]/div[2]/div/div[2]/div[2]/ul/li[1]/label")));
	    	String t3= driver.findElement(By.xpath("//div[1]/div[2]/div[2]/div[2]/div/div[2]/div[2]/ul/li[1]/label")).getText();
	    	System.out.println(t3);	    	
	    	Reporter.log(t3);
	    	driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();
	   	 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[2]/div[2]/div[2]/div/div[2]/div[2]/ul/li[1]/label")));
	    	driver.findElement(By.xpath("//div[1]/div[2]/div[2]/div[2]/div/div[2]/div[2]/ul/li[1]/label")).click();
	    	
	    	Thread.sleep(2000);
	    	String t6= driver.findElement(By.xpath("//div[2]/div[2]/div[3]/div/div[2]/div[2]/ul/li[1]/label")).getText();
	    	System.out.println(t6);
	    	Reporter.log(t6);Thread.sleep(2000);
	    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    	driver.findElement(By.xpath("//div[2]/div[2]/div[3]/div/div[2]/div[2]/ul/li[1]/label")).click();
	    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    	Thread.sleep(1000);
	    	
	    }catch (Exception e1) {System.out.println(e1);}
	    	
	  
	    Thread.sleep(3000);
//Select locality
	    
	    try{
	    	 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/section/div/div/div[2]/div[1]/div/div/div[1]")));
	    	WebElement loc=driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[2]/div[1]/div/div/div[1]"));
	    	loc.click();
	    	Thread.sleep(3000);
	    	
	    	
	    	WebElement e1=driver.findElement(By.xpath("//div/div/div[2]/div[1]/div/div/div[2]/div[3]/ul/li[4]/label"));
	    	String s=e1.getText();
	    	e1.click();
	    	Thread.sleep(3000);
	    	loc.click();
	    	    	    
	    }catch (Exception e){System.out.println(e);}
	    
	    Thread.sleep(1000);
//Select user Mobile
			 
			   try{
				   w.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtmobile")));
				   driver.findElement(By.name("lcftxtmobile")).clear();
				   Thread.sleep(1000);
					 driver.findElement(By.name("lcftxtmobile")).sendKeys(YPMob); 
					 
					 Reporter.log("selected mobile  :"+YPMob);
				   }catch(Exception ie2){
						
					 }	  
				
			   
//select Name   
			 
			   try{
				   driver.findElement(By.name("lcftxtname")).clear();
				   Thread.sleep(1000);
					 driver.findElement(By.name("lcftxtname")).sendKeys(YPName); 
					 
					 Reporter.log("selected Name  :"+YPName);
				   }catch(Exception ie3){
						
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
					 
					   w.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtvcode")));					
					   driver.findElement(By.name("lcftxtvcode")).clear();
					   Thread.sleep(1000);
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
