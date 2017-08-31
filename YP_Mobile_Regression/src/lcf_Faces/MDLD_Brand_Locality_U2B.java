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
//4
public class MDLD_Brand_Locality_U2B extends DriverScript implements Locators {

int f;
	
	@Test()
	
	public void lcfposting() throws InterruptedException, Exception, IOException  {

		
		 String url="http://www.sulekha.com/projector-repair-services/chennai";
		 
		 System.out.println("http://www.sulekha.com/projector-repair-services/chennai");
		 
	
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.navigate().to(url);
	    
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	    try{
	    	
	    	String t1= driver.findElement(By.xpath("//div[4]/section/div/div/div[1]/div[2]/div[1]/div/div[2]/div[2]/ul/li[1]/label")).getText();
	    	System.out.println(t1);
    		Reporter.log(t1);
    		driver.findElement(By.xpath("//div[4]/section/div/div/div[1]/div[2]/div[1]/div/div[2]/div[2]/ul/li[1]/label")).click();
    		
    		Thread.sleep(2000);
	    	String t2= driver.findElement(By.xpath("//div[4]/section/div/div/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[2]/ul/li[2]/label")).getText();
	    	System.out.println(t2);
    		Reporter.log(t2);
    		driver.findElement(By.xpath("//div[4]/section/div/div/div[1]/div[2]/div[2]/div[1]/div/div[2]/div[2]/ul/li[2]/label")).click(); 
    		
    		Thread.sleep(2000);
	    	String t3= driver.findElement(By.xpath("//div[4]/section/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[3]/ul/li[3]/label")).getText();
	    	System.out.println(t3);
    		Reporter.log(t3);
    		driver.findElement(By.xpath("//div[4]/section/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/div[3]/ul/li[3]/label")).click(); 
    		Thread.sleep(1000);
    		driver.findElement(By.xpath("//button[@class='btn-p nextBtn nxtbtn']")).click();
    		
    		Thread.sleep(1000);
	    	String t4= driver.findElement(By.xpath("//div[4]/section/div/div[1]/div[1]/div[2]/div[2]/div[3]/div/div[2]/div[2]/ul/li[2]/label")).getText();
	    	System.out.println(t4);
    		Reporter.log(t4);
    		driver.findElement(By.xpath("//div[4]/section/div/div[1]/div[1]/div[2]/div[2]/div[3]/div/div[2]/div[2]/ul/li[2]/label")).click(); 
    		
 // Select Brand
    		
    		Thread.sleep(1000);
	    	String t5= driver.findElement(By.xpath("//label[@for='smulti21']")).getText();
	    	System.out.println(t5);
    		Reporter.log(t5);
    		driver.findElement(By.xpath("//label[@for='smulti21']")).click(); 
    		Thread.sleep(1000);
    		try{
    		driver.findElement(By.xpath("//button[@class='btn-p nextBtn nxtbtn']")).click();
    		}catch(Exception ie89){
    		Thread.sleep(2000);
    		}

	    }catch (Exception e){System.out.println(e);}
	    Thread.sleep(4000);
//Select locality		  
	    	WebElement loc= driver.findElement(By.xpath("html/body/div[4]/section/div/div[1]/div[2]/div[2]/div/div/div/div/div[1]"));
	    	if(loc.isDisplayed()){
	    	loc.click();
	    	Thread.sleep(4000);
	    	driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	    	driver.findElement(By.xpath("//label[contains(text(), 'Acharapakkam')]")).click();
	    	Thread.sleep(2000);
	    	driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	    	driver.findElement(By.xpath("//label[contains(text(), 'Adyar')]")).click();
	    	Thread.sleep(4000);
	    	driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	    	driver.findElement(By.xpath("//div[2]/div[2]/div/div/div/div/div[2]/a")).click();
	    	Thread.sleep(4000);
	    	
	//Verify multi locality       
	    if (loc.getText().contains("Acharapakkam")&&loc.getText().contains("Adyar")){    		
    		Thread.sleep(2000);
    		Reporter.log("Multilocality  avaialble");
	    }else{
	    	Reporter.log("Multilocality not avaialble");
	    	Assert.fail();
	    }
	    	}
	
	    	
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
					   WebDriverWait w=new WebDriverWait(driver, 60);
					   w.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtvcode")));
					   Thread.sleep(500);
					   driver.findElement(By.name("lcftxtvcode")).clear();
						 driver.findElement(By.name("lcftxtvcode")).sendKeys(YPVerifyCode); 
						 
					   }catch(Exception ie124){
							
						 }	
				
					
					 for(int i =0;i<=20;i++){
					//	   System.out.println(i);
						 	try{		
						   if(driver.findElement(By.cssSelector(".step.success-message.thank-you-step>h4")).getText().contains("Thank")||driver.getCurrentUrl().contains("dashboard")){
							
							  Reporter.log(  "Lcf posted successfully");
							  break;
						   }			
					       }catch(Exception ie8){
					    	   
					       }					
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
