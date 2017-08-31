package lcf_Faces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Mobile_CheckAttributes_MDLDForm {
	WebDriver driver; 
		@Test(priority=1)
	public void Mobile_CheckAttributes_MDLDForm_Attribute1() throws InterruptedException{
		
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
		driver.get("http://www.sulekha.com/cleaning-services/chennai");			
		Reporter.log("http://www.sulekha.com/cleaning-services/chennai");
		WebDriverWait wait = new WebDriverWait(driver, 25);		
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti1']")));
		//form 1
		try{
		
			
		driver.findElement(By.xpath("//label[@for='smulti1']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[@for='smulti1']")).click();
		Reporter.log("Radiobuttons not displayed in first page");	
		Assert.fail();
		}catch(Exception ie829){
			Reporter.log("Radiobuttons displayed in first page");
			
		}
		
		//form2
		
		try{			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti4']")));	
			driver.findElement(By.xpath("//label[@for='smulti4']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//label[@for='smulti5']")).click();
			Reporter.log("Checkboxs displayed in second page");
			}catch(Exception ie189){
				Reporter.log("Checkboxs not displayed in second page");	
				Assert.fail();
			}
		
		driver.findElement(By.cssSelector(".btn-p.nextBtn")).click();
	
		//form3
				try{	
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti8']")));
					driver.findElement(By.xpath("//label[@for='smulti8']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//label[@for='smulti9']")).click();
					Reporter.log("Radion buttons not displayed in third page");	
					Assert.fail();
					}catch(Exception ie839){
						Reporter.log("Radion buttons displayed in third page");	
						
					}
				
				
			
				
				//form4
				try{	
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti13']")));
					driver.findElement(By.xpath("//label[@for='smulti13']")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//label[@for='smulti14']")).click();
					Thread.sleep(3000);
					driver.findElement(By.cssSelector(".btn-p.nextBtn")).click();
					Reporter.log("Checkboxs displayed in 4th page");
					}catch(Exception ie819){
						Reporter.log("Checkboxs not displayed in 4 th page");	
						Assert.fail();
					}
			
		}
	


	@Test(priority=2)
	public void CheckAttributes_MDLDForm_Attribute2() throws InterruptedException{

		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    
		driver.get("http://www.sulekha.com/cleaning-services/chennai");	
		Thread.sleep(6000);
		Reporter.log("http://www.sulekha.com/cleaning-services/chennai");
		WebDriverWait wait = new WebDriverWait(driver, 25);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti2']")));
		//form 1
		try{
		
			
		driver.findElement(By.xpath("//label[@for='smulti2']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[@for='smulti1']")).click();
		Reporter.log("Radiobuttons not displayed in first page");	
		Assert.fail();
		}catch(Exception ie829){
			Reporter.log("Radiobuttons displayed in first page");
			
		}
		
		//form2
		try{			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti4']")));
			driver.findElement(By.xpath("//label[@for='smulti4']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//label[@for='smulti5']")).click();
			Reporter.log("Radiobuttons not displayed in second page");	
			Assert.fail();
			}catch(Exception ie899){
				Reporter.log("Radiobuttons displayed in second page");	
			}	
	
		//form3
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti6']")));
					
					driver.findElement(By.xpath("//label[@for='smulti6']")).click();
					Thread.sleep(4000);
					driver.findElement(By.xpath("//label[@for='smulti7']")).click();
					Reporter.log("Radion buttons not displayed in third page");	
					Assert.fail();
					}catch(Exception ie8549){
						Reporter.log("Radion buttons displayed in third page");	
						
					}
				
				
				Thread.sleep(5000);
				
				//form4
				try{
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti10']")));
					
					driver.findElement(By.xpath("//label[@for='smulti10']")).click();
					Thread.sleep(4000);
					driver.findElement(By.xpath("//label[@for='smulti11']")).click();
					Reporter.log("Checkboxs displayed in 4th page");	
					}catch(Exception ie4389){
						Reporter.log("Checkboxs not displayed in 4th page");	
						Assert.fail();
					}
		
		}
	
	
	

	@Test(priority=3)
	public void CheckAttributes_MDLDForm_Attribute3() throws InterruptedException{
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
		driver.get("http://www.sulekha.com/cleaning-services/chennai");			
		Reporter.log("http://www.sulekha.com/cleaning-services/chennai");
		WebDriverWait wait = new WebDriverWait(driver, 25);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti3']")));
		//form 1
		try{
		
			
		driver.findElement(By.xpath("//label[@for='smulti3']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//label[@for='smulti1']")).click();
		Reporter.log("Radiobuttons not displayed in first page");	
		Assert.fail();
		}catch(Exception ie829){
			Reporter.log("Radiobuttons displayed in first page");
			
		}
		//form2
		try{			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[2]/div[2]/div[1]/div/div[2]/div[3]/ul/li[1]/label")));
			driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div/div[2]/div[3]/ul/li[1]/label")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("//div[2]/div[2]/div[1]/div/div[2]/div[3]/ul/li[2]/label")).click();
			Reporter.log("Checkboxs  displayed in second page");	
			
			}catch(Exception ie899){
				Reporter.log("Checkboxs not displayed in second page");	
				Assert.fail();
			}	
		driver.findElement(By.cssSelector(".btn-p.nextBtn")).click();
		//form3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[2]/div[2]/div[2]/div/div[2]/div[2]/ul/li[1]/label")));
				try{				
					
					driver.findElement(By.xpath("//div[1]/div[2]/div[2]/div[2]/div/div[2]/div[2]/ul/li[1]/label")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//div[1]/div[2]/div[2]/div[2]/div/div[2]/div[2]/ul/li[2]/label")).click();
					Reporter.log("Radion buttons not displayed in 4th page");	
					Assert.fail();
					}catch(Exception ie89){
						Reporter.log("Radion buttons displayed in third page");	
					}
				
				
				Thread.sleep(5000);
		//form4
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[1]/div[2]/div[2]/div[3]/div/div[2]/div[2]/ul/li[1]/label")));
				try{					
						
					driver.findElement(By.xpath("//div[1]/div[2]/div[2]/div[3]/div/div[2]/div[2]/ul/li[1]/label")).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath("//div[1]/div[2]/div[2]/div[3]/div/div[2]/div[2]/ul/li[1]/label")).click();
					Reporter.log("Radion buttons not displayed in 4th page");	
					Assert.fail();
					}catch(Exception ie89){
						Reporter.log("Radion buttons displayed in 4th page");
					}
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".placehold")));
				
				driver.findElement(By.cssSelector(".placehold")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='smulti43']")));
				driver.findElement(By.xpath("//label[@for='smulti43']")).click();
				Thread.sleep(2000);
				driver.findElement(By.name("lcftxtmobile")).clear();
				Thread.sleep(1000);
				driver.findElement(By.name("lcftxtmobile")).sendKeys("9380835000");
				Thread.sleep(2000);
				driver.findElement(By.name("lcftxtname")).clear();
				Thread.sleep(1000);
				driver.findElement(By.name("lcftxtname")).sendKeys("madan");
				driver.findElement(By.xpath("html/body/div[4]/section/div/div[1]/div[2]/div[9]/button[2]")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("lcftxtvcode")));
				driver.findElement(By.name("lcftxtvcode")).sendKeys("999999");
				for(int i =0;i<=20;i++){
					 	try{
					 		System.out.println(i+"outside");
					   if(driver.getCurrentUrl().contains("dashboard")&&(driver.findElement(By.xpath("//*[@id='div_listcard_0']/div[1]/div[2]/div/ul/li[1]/a")).getText().contains("Matched"))){
						System.out.println(i+"inside");
						  Reporter.log(  "Lead distribution is taking below 20 sec");
						  break;
					   }			
				      }catch(Exception ie8){
				   	   
				      }					
					   if(i==20){
						   Reporter.log(  "Lead distribution is taking more than 20 sec");
						   Assert.fail();
					   }
					   Thread.sleep(1000);
					 }
								  
						
	}

	@AfterMethod()
	public void close(){
driver.quit();
	}
	
}
	
	
	

