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
//15
public class SDLD_Attribute_Page extends DriverScript implements Locators {
	
	int f;
	
	@Test()
	
	public void lcfposting() throws InterruptedException, Exception, IOException  {

		/*File src = new File("D:\\Harish\\Yellowpage_2\\mobLCFsanity.xls");
		
		 Workbook wb = Workbook.getWorkbook(src);
		 
		 String url = wb.getSheet(0).getCell(1,13).getContents();
		 
		 System.out.println(url);*/
		 
		String url="http://www.sulekha.com/mosquito-net-dealers/chennai";
		Reporter.log(url);
	
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.navigate().to(url);
	    
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//Select need
	    
	    try{
	    
    		WebElement w=driver.findElement(By.xpath("//div[4]/section/div/div/div[1]/div[2]/div/div/div/div[2]/div[3]/ul/li[1]/label"));
    		String n=w.getText();
    	if(!n.equals("Mosquito Nets & Screens Dealers")){
    	System.out.println(n);	
    	Reporter.log("Attribute preselect FAIL");
    	Assert.fail();
    	}else {
    		System.out.println("Attribute preselect Pass: "+n);	
        	Reporter.log("Attribute preselect Pass: "+n);
        	w.click();
    	}
    	Thread.sleep(1000);
    	
	    }catch (Exception e2){System.out.println(e2);}
	    
	    
//Select locality
	    
	    try{
	    	Thread.sleep(1000);
	    	if (driver.findElement(By.xpath("//div[4]/section/div/div/div[2]/div[2]/div/div/div/div[1]")).isDisplayed()){
	    	
	    	WebElement loc= driver.findElement(By.xpath("//div[4]/section/div/div/div[2]/div[2]/div/div/div/div[1]"));
	    	loc.click();
	    	driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	    	driver.findElement(By.xpath("//div[4]/section/div/div/div[2]/div[2]/div/div/div/div[2]/div[3]/ul/li[1]/label")).click();
	    	Thread.sleep(1000);
	    	String l=loc.getText();
	    	System.out.println(l);
	    	}
	    	
	    }catch (Exception e2){System.out.println(e2);}
	    
	    	
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
			   
//Time pref.
				
			   try{
				   
				   if (driver.findElement(By.xpath("//div[4]/section/div/div/div[1]/div[7]/div/div/div[1]")).isDisplayed()){
					 driver.findElement(By.xpath("//div[4]/section/div/div/div[1]/div[7]/div/div/div[1]")).click();	
					 Thread.sleep(1000);
					 driver.findElement(By.xpath("//div[4]/section/div/div/div[1]/div[7]/div/div/div[2]/div[2]/ul/li[1]/label")).click();
					 Thread.sleep(2000);
				   }
					}catch(Exception ie5){
						
					}
			   
			   
			
//Click Next
			   
				try{ 
					 driver.findElement(By.xpath("//div[4]/section/div/div/div[2]/div[9]/button[2]")).click();
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
				   
				   
				   
//Verify button
					try{
						Thread.sleep(1000);
						 driver.findElement(By.xpath("//button[@onclick='lcf_v1.btnverify(this)']")).click();	
						}catch(Exception ie221){
							
						}
					
//Skip			
					try{ 
						
						WebDriverWait w=new WebDriverWait(driver, 60);
						   w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[4]/section/div/div/div[4]/div/div/a")));
						   Thread.sleep(500);
					
						 driver.findElement(By.xpath("html/body/div[4]/section/div/div/div[4]/div/div/a")).click();
						}catch(Exception ie7){
							System.out.println(ie7);
						}


					Thread.sleep(2000);
					
					 for(int i =0;i<=10;i++){
						   System.out.println(i);
						 	try{		
						   if(driver.findElement(By.cssSelector(".step.success-message.thank-you-step>h4")).getText().contains("Thank")){
							
							  Reporter.log(  "Lcf posted successfully");
							  break;
						   }			
					       }catch(Exception ie8){
					    	   
					       }						 
						 	try{
						 		Thread.sleep(2000);
						 		System.out.println("second try");
								   if(driver.getCurrentUrl().contains("dashboard")){					
									  Reporter.log(  "Lcf posted successfully");
									  break;
								   }			
							       }catch(Exception ie694){
							    	   
							       }
						 	
						 	
						  Thread.sleep(1000); 
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
