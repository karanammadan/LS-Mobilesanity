package lcf_Faces;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Library.DriverScript;
import Library.Locators;

public class SDLD_SEM_Mandatory  extends DriverScript implements Locators {

int f=0;
	
	@Test()
	
	public void SDLD_SEM_Mandatory() throws Exception, IOException {
		/*
		File src = new File("D:\\Harish\\Yellowpage_2\\mobLCFsanity.xls");
		Workbook wb=Workbook.getWorkbook(src);
		String url=wb.getSheet(0).getCell(1, 20).getContents();
		System.out.println(url);*/
		
		String url="http://www.sulekha.com/housekeeping-services/chennai?pagetype=sem&md=ai";
		Reporter.log(url);
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.navigate().to(url);
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	//Select city	
	    
	    try{	
	    	
			driver.findElement(By.xpath("//div[1]/section/div/div/div[1]/div[1]/div/div[1]")).isDisplayed();
		String s1=driver.findElement(By.xpath("//div[1]/section/div/div/div[1]/div[1]/div/div[1]")).getText();
		if(s1.equals("Chennai")){
			System.out.println("City presaelect PASS - "+s1);
			Reporter.log("City preselect PASS - "+s1);
		} else {System.out.println("City not preselected");}
		Thread.sleep(1000);
	
	//Select Need	
		String s2=driver.findElement(By.xpath("//label[@for='smulti3']")).getText();
		System.out.println("Selected Need : "+s2);
		Reporter.log("Selected Need : "+s2);
		driver.findElement(By.xpath("//label[@for='smulti3']")).click();
		Thread.sleep(1000);
		
	// Enter comment
		
		driver.findElement(By.xpath("//textarea[@name='txtaddinfo']")).click();
		driver.findElement(By.xpath("//textarea[@name='txtaddinfo']")).sendKeys("need best service, Thanks.");
			
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
		
	/*   try{
			 driver.findElement(By.xpath("//div[1]/section/div/div/div[2]/div[5]/div/div/div[1]")).click();	
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("//div[1]/section/div/div/div[2]/div[5]/div/div/div[2]/div[2]/ul/li[1]/label")).click();
			 Thread.sleep(2000);
			}catch(Exception ie5){
				
			}
	  */
	   
	
//Click Next
	   
		try{ 
			 driver.findElement(By.cssSelector(".btn-p.getquotesbtn")).click();
			}catch(Exception ie6){
				System.out.println(ie6);
			}				
		
		
//Verify code
		   try{
			   
			   WebDriverWait w=new WebDriverWait(driver, 30);
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
	
			
			
//Check Thank you info
			
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
				 	
				 	
				  Thread.sleep(3000); 
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
