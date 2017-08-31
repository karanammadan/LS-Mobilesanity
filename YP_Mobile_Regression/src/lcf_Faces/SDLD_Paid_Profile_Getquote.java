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
//19
public class SDLD_Paid_Profile_Getquote extends DriverScript implements Locators {
	
	int f;
	
	@Test()
	
	public void SDLD_Paid_Profile_Getquote() throws InterruptedException, Exception, IOException  {

		/*File src = new File("D:\\Harish\\Yellowpage_2\\mobLCFsanity.xls");
		
		 Workbook wb = Workbook.getWorkbook(src);
		 
		 String url = wb.getSheet(0).getCell(1,15).getContents();
		 
		 System.out.println(url);*/
		 
		String url="http://www.sulekha.com/l2h-holidays-vadapalani-chennai-contact-address";
		Reporter.log(url);
		 
		 
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.navigate().to(url);
	    
	    WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-p proceed-btn GAQ_LCF_PROCEED']")));
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//button[@class='btn-p proceed-btn GAQ_LCF_PROCEED']")).click();
	    Thread.sleep(1000);
	
//City select
	    try{
	    	
	    	driver.findElement(By.xpath("//div/section/div/div[2]/div[1]/div[1]/div/div[1]")).isDisplayed();
	    	Thread.sleep(500);
	    	WebElement c= driver.findElement(By.xpath("//div/section/div/div[2]/div[1]/div[1]/div/div[1]"));	    	
	    	Thread.sleep(500);
	    	c.click();
	    	driver.manage().timeouts().implicitlyWait(19, TimeUnit.SECONDS);
	    	driver.findElement(By.xpath("//div[1]/section/div/div[2]/div[1]/div[1]/div/div[2]/div[3]/ul/li[1]/label")).click();

	    	WebDriverWait w = new WebDriverWait(driver, 60);
	    	w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/section/div/div[2]/div[1]/div[1]/div/div[1]")));
	    	Thread.sleep(2000);
	    	String t1= c.getText();
	    	System.out.println(t1);
	    	Reporter.log("Selected City: "+t1);
	    	
	    }catch (Exception e1){System.out.println("could not select city");}
	    	
//Need select    	
	    
	    
	    try{
	    	
	    	Thread.sleep(1000);
	    	Thread.sleep(500);
	    	driver.findElement(By.xpath("//div[1]/section/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[3]/ul/li[1]/label")).click();
	    	Thread.sleep(2000);	    	
	    	String t2= driver.findElement(By.xpath("//div[1]/section/div/div[2]/div[1]/div[2]/div/div/div/div[2]/div[3]/ul/li[1]/label")).getText();
	    	System.out.println(t2);
	    	Reporter.log("Selected Need: "+t2);
	    	
	    }catch (Exception e2){System.out.println("need not select");}



//Select locality
	    
	   /* try{
	    	Thread.sleep(2000);
	    	
	    	WebElement loc= driver.findElement(By.xpath("//div[4]/section/div/div/div[2]/div[1]/div/div/div[1]"));
	    	
	    	if(loc.isDisplayed()){
	    	loc.click();
	    	driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
	    	driver.findElement(By.xpath("//div[4]/section/div/div/div[2]/div[1]/div/div/div[2]/div[3]/ul/li[2]/label")).click();
	    	Thread.sleep(1000);
	    	String l=loc.getText();
	    	Reporter.log("Selected locality :"+l);
	    	
	    	}
	    }catch (Exception e4){System.out.println(e4);}
	    */
	    	
//Select user Mobile
			 
			   try{
			//	   Thread.sleep(1000);
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
				
			/*   try{
					 driver.findElement(By.xpath("//div[4]/section/div/div/div[1]/div[7]/div/div/div[1]")).click();	
					 Thread.sleep(1000);
					 driver.findElement(By.xpath("//div[4]/section/div/div/div[1]/div[7]/div/div/div[2]/div[2]/ul/li[1]/label")).click();
					 Thread.sleep(2000);
					}catch(Exception ie5){
						
					}
			   */
			   
			
//Click Next
			   
				try{ 
					 driver.findElement(By.xpath("//div[1]/section/div/div[2]/div[2]/div[8]/button[2]")).click();
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
					//	Thread.sleep(1000);
						 driver.findElement(By.xpath("//button[@onclick='lcf_v1.btnverify(this)']")).click();	
						}catch(Exception ie221){
							
						}


					driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
					
					 for(int i =0;i<=10;i++){
						  // System.out.println(i);
						 	try{		
						   if(driver.findElement(By.cssSelector(".step.success-message.thank-you-step>h4")).getText().contains("Thank")){
							
							  Reporter.log(  "Lcf posted successfully");
							  break;
						   }			
					       }catch(Exception ie8){
					    	   
					       }
						 
						 	try{
						 		System.out.println("Try "+i);
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
	public void closeUrl() throws Exception{
		driver.quit();
	}

}
