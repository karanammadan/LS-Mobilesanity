package lcf_Faces;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Library.DriverScript;
import Library.Locators;
//2
public class MDLD_Attribute_Page extends DriverScript implements Locators {
	
	int f;
	
	@Test()
	
	public void MDLD_Attribute_Page() throws InterruptedException, Exception, IOException  {

		/*File src = new File("D:\\Harish\\Yellowpage_2\\mobLCFsanity.xls");
		 Workbook wb = Workbook.getWorkbook(src);
		 
		 String url = wb.getSheet(0).getCell(1,2).getContents();
		 
		 System.out.println(url);*/
		 
		String url="http://www.sulekha.com/bike-transport-services/chennai";
		Reporter.log(url);
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
	    driver.navigate().to(url);
	    
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	  
	    	
	    	String t1= driver.findElement(By.cssSelector(".selected>label")).getText();
	    	
	    	try{
	    	if(!t1.equals("Two wheeler")){
	    		System.out.println("Attribute pre select failed");
	    		Reporter.log("Attribute Pre selected: "+t1);
	    	}else {
	    		
	    		System.out.println("Pre selected attribute: "+t1);
	    		Reporter.log("Pre selected attribute: "+t1);
	    	}
	    	}catch (Exception e){System.out.println(e);}
	    	
	    	Thread.sleep(2000);
	    	driver.findElement(By.xpath("//button[@class='btn-p nextBtn nxtbtn']")).click();
	    	
//City	    	
	    	Thread.sleep(2000);
	    	String t2= driver.findElement(By.xpath("//label[@for='smulti13']")).getText();
	    	System.out.println(t2);
	    	Reporter.log("Selected city: "+t2);
	    	driver.findElement(By.xpath("//label[@for='smulti13']")).click();
	    	
driver.findElement(By.cssSelector(".btn-p.nextBtn.nxtbtn")).click();
	  Thread.sleep(5000);  	
	    	
	    	
//Select user Mobile
			 
			   try{
				   driver.findElement(By.name("lcftxtmobile")).clear();
					 driver.findElement(By.name("lcftxtmobile")).sendKeys(YPMob); 
					 
					 Reporter.log("Entered mobile no. :" +YPMob);
				   }catch(Exception ie2){
						
					 }	  
				
			   
//select Name   
			   
			 
			   try{
				   driver.findElement(By.name("lcftxtname")).clear();
					 driver.findElement(By.name("lcftxtname")).sendKeys(YPName); 
					 
					 Reporter.log("Entered Name  :"+YPName);
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
			//		 driver.findElement(By.xpath("//div[4]/section/div/div/div[2]/div[5]/div/div/div[1]")).click();	
			//		 Thread.sleep(3000);
					 driver.findElement(By.xpath("//label[@for='smulti6']")).click();
			//		 Thread.sleep(2000);
					}catch(Exception ie5){
						
					}
			
//Click Next
			   
				try{ 
					 driver.findElement(By.xpath("//button[@onclick='lcf_v1.getquotes(2)']")).click();
					}catch(Exception ie6){
						System.out.println(ie6);
					}
				Thread.sleep(3000);
				
				
	//verify code
				   try{
					   driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
					   driver.findElement(By.name("lcftxtvcode")).clear();
						 driver.findElement(By.name("lcftxtvcode")).sendKeys(YPVerifyCode); 
						 
					   }catch(Exception ie124){
							
						 }	
				   
				   
	//verify button
					try{
			//			Thread.sleep(2000);
						 driver.findElement(By.xpath("//button[@onclick='lcf_v1.btnverify(this)']")).click();	
						}catch(Exception ie221){
							
						}


					driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
					
					 for(int i =0;i<=10;i++){
						   System.out.println(i);
						 	try{		
						   if(driver.findElement(By.cssSelector(".step.success-message.thank-you-step>h4")).getText().contains("Thank")){
							
							  Reporter.log(  "Lcf posted successfully");
							  break;
						   }			
					       }catch(Exception ie654){
					    	   
					       }
						 
						 	try{
						 		System.out.println("second try");
								   if(driver.getCurrentUrl().contains("dashboard")){					
									  Reporter.log(  "Lcf posted successfully");
									  break;
								   }			
							       }catch(Exception ie694){
							    	   
							       }
						 	
						 	
						  Thread.sleep(2000); 
						   if(i==10||f==1){
							   Reporter.log(  "Lcf not posted successfully");
							  // Assert.fail();
						   }
						 }
					  
	 
				  	}
		
		@AfterTest
		public void after(){
		driver.quit();
		}

}
