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
//27
public class Additional_info_field_mandatory_LCF  extends DriverScript implements Locators {
	
	int f=0;
	
	@Test()
	//this is madan test
	
	public void SEM_MDLD_Page() throws Exception, IOException {
		/*
		File src = new File("D:\\Harish\\Yellowpage_2\\mobLCFsanity.xls");
		Workbook wb=Workbook.getWorkbook(src);
		String url=wb.getSheet(0).getCell(1, 19).getContents();
		System.out.println(url);*/
		
		String url="http://www.sulekha.com/packers-and-movers/chennai";
		Reporter.log(url);
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.navigate().to(url);
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
		
	try{	
		
	//Select service	
		String s1=driver.findElement(By.xpath("//label[@for='smulti1']")).getText();
		System.out.println("Selected service : "+s1);
		Reporter.log("Selected service : "+s1);
		driver.findElement(By.xpath("//label[@for='smulti1']")).click();
		Thread.sleep(1000);
	
	//Select Need	
		String s2=driver.findElement(By.xpath("//label[@for='smulti7']")).getText();
		System.out.println("Selected Need : "+s2);
		Reporter.log("Selected Need : "+s2);
		driver.findElement(By.xpath("//label[@for='smulti7']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();
		Thread.sleep(1000);
		
		
	} catch (Exception e1){}
		
	
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
	  
	   
	
//Click Next
	   
		try{ 
			 driver.findElement(By.xpath("//button[@onclick='lcf_v1.getquotes(2)']")).click();
			}catch(Exception ie6){
				System.out.println(ie6);
			}	
		
//Additional info check
		try{
		if(driver.findElement(By.xpath("//div[1]/div[2]/div[7]/div/div/span[2]")).isDisplayed())
		{
			driver.findElement(By.cssSelector(".form-group>textarea")).sendKeys("Give the best price");
			System.out.println("Additional info is mandatory condition is pass");
			Reporter.log("Additional info is mandatory condition is pass");
		}
		}catch(Exception ie11){
			System.out.println("*********Additional info is not mandatory condition is pass*******");
			Reporter.log("*********Additional info is not mandatory condition is pass*******");
			Assert.fail();
		}
		
		
		//Click Next
			   
				try{ 
					 driver.findElement(By.xpath("//button[@onclick='lcf_v1.getquotes(2)']")).click();
					}catch(Exception ie12){
						System.out.println(ie12);
					}
		
//Verify code
		   try{
			   
			   WebDriverWait w=new WebDriverWait(driver, 60);
			   w.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtvcode")));
			   Thread.sleep(500);
			   driver.findElement(By.name("lcftxtvcode")).clear();
				 driver.findElement(By.name("lcftxtvcode")).sendKeys(YPVerifyCode);  
				 
			   }catch(Exception ie7){
					
				 }	
		   
		   
//Verify button
			try{
	
				 driver.findElement(By.xpath("//button[@onclick='lcf_v1.btnverify(this)']")).click();	
				}catch(Exception ie8){
					
				}
			
	// Skip
			try{
				driver.findElement(By.xpath("//div[1]/section/div/div/div[4]/div/div/a")).click();
			}catch(Exception ie98){
				
			}	
			
			 for(int i =0;i<=10;i++){
				//   System.out.println(i);
				 	try{		
				   if(driver.findElement(By.cssSelector(".step.success-message.thank-you-step>h4")).getText().contains("Thank")){
					
					  Reporter.log(  "Lcf posted successfully");
					  break;
				   }			
			       }catch(Exception ie9){
			    	   
			       }
				 
				 	try{
				 		System.out.println("Try : " +i);
						   if(driver.getCurrentUrl().contains("dashboard")){					
							  Reporter.log(  "Lcf posted successfully");
							  break;
						   }			
					       }catch(Exception ie10){
					    	   
					       }
				 	
				 	
				  Thread.sleep(1000); 
				   if(i==10||f==1){
					   Reporter.log(  "Lcf not posted successfully");

				   }
				 }
			  

		  	}
	@AfterTest()
	public void aftertest(){
		driver.quit();
	}


}
