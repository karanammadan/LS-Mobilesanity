package lcf_Faces;

import java.io.IOException;
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
//28
public class MDLD_SEM_Mandatory extends DriverScript implements Locators {
	
	int f=0;
	
	@Test()
	
	public void lcfposting() throws Exception, IOException {	
		
		String url="http://www.sulekha.com/packers-and-movers/chennai?pagetype=sem&md=ai";
		Reporter.log(url);
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.navigate().to(url);
	    WebDriverWait w = new WebDriverWait(driver, 20);
	   
	    
		
	try{	
		  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti1']"))); 	
	//Select service	
		String s1=driver.findElement(By.xpath("//label[@for='smulti1']")).getText();
		System.out.println("Selected service : "+s1);
		Reporter.log("Selected service : "+s1);
		driver.findElement(By.xpath("//label[@for='smulti1']")).click();
		
		
	  
	//Select Need	
		  w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti6']"))); 
		    
		String s2=driver.findElement(By.xpath("//label[@for='smulti6']")).getText();
		System.out.println("Selected Need : "+s2);
		Reporter.log("Selected Need : "+s2);
		driver.findElement(By.xpath("//label[@for='smulti6']")).click();
	} catch (Exception e1){}
	
	driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();	
	 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/section/div/div/div[2]/div[8]/button[2]")));	
	driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[2]/div[8]/button[2]")).click();
	 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/section/div/div/div[2]/div[6]/div/span")));
	String ermsg=driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[2]/div[6]/div/span")).getText();
	if(ermsg.contains("Enter additional information")){
		
		System.out.println("Add info mandatory  validation :Pass");
		Reporter.log("Add info mandatory  validation :Pass");
	}else{
		
		System.out.println("Add info validation :Fail");
		Reporter.log("Add info validation :Fail");
		Assert.fail();
		
	}
	
	//Enter user Mobile number
	 
	   try{
		   driver.findElement(By.name("lcftxtmobile")).clear();
			 driver.findElement(By.name("lcftxtmobile")).sendKeys(YPMob); 
			 
			 Reporter.log("Entered mobile no.: "+YPMob);
		   }catch(Exception ie2){
				
			 }	  
		
	   
//Enter Name   
	 
	   try{
		   driver.findElement(By.name("lcftxtname")).clear();
			 driver.findElement(By.name("lcftxtname")).sendKeys(YPName); 
			 
			 Reporter.log("Entered Name: "+YPName);
		   }catch(Exception ie3){
				
			 }	  
	   
//Mail id  
	   
	   try{
		   driver.findElement(By.name("lcftxtemail")).click();
		   driver.findElement(By.name("lcftxtemail")).clear();
		   }catch(Exception ie4){
				
			 }	
	   
//Time pref.
		
	   try{
			 driver.findElement(By.xpath("//div[1]/section/div/div/div[2]/div[5]/div/div/div[1]")).click();	
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//div[1]/section/div/div/div[2]/div[5]/div/div/div[2]/div[2]/ul/li[1]/label")).click();
			 Thread.sleep(500);
			}catch(Exception ie5){
				
			}
	   	
	   	driver.findElement(By.xpath("html/body/div[1]/section/div/div/div[2]/div[6]/div/textarea")).sendKeys("Need Packers");
	   	Thread.sleep(2000);
	   
	
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
				 
			   }catch(Exception ie7){
					
				 }	

			 for(int i =0;i<=20;i++){
				//   System.out.println(i);
				 	try{		
				   if(driver.findElement(By.cssSelector(".step.success-message.thank-you-step>h4")).getText().contains("Thank")||driver.getCurrentUrl().contains("dashboard")){
					
					  Reporter.log(  "Lcf posted successfully");
					  break;
				   }			
			       }catch(Exception ie9){
			    	   
			       }				 
				 	
				  Thread.sleep(1000); 
				   if(i==20||f==1){
					   Reporter.log(  "Lcf not posted successfully");
					   Assert.fail();
				   }
				 }
			  

		  	}
	@AfterTest()
	public void aftertest(){
		driver.quit();
	}


}
