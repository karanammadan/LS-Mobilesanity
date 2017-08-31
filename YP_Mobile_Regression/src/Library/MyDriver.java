package Library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.Reporter;


///this is to run
public class MyDriver {


	public void before(String url)throws Exception {

	ProfilesIni profile = new ProfilesIni();
	FirefoxProfile myprofile = profile.getProfile("default");
	myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	FirefoxDriver driver = new FirefoxDriver(myprofile);
	

	driver.navigate().to(url);
	 
	System.out.println("MyDriver Pass");
  
	}


	public void after()throws Exception {

		for(int k=0;k<=20;k++){
			try{
				WebDriver driver = null;
				
				if((driver.getCurrentUrl().contains("dashboard"))||driver.findElement(By.cssSelector(".step.step-thank.active")).getText().contains("Thank")){
					  Reporter.log(  "Lcf posted successfully");						
		              break;
				}
			}catch(Exception ie9){
				if(k==20){
					  Reporter.log(  "Lcf not posted successfully");
					Assert.fail();	
				}
			}
		 
		System.out.println("MyDriver end Pass");
	  
		}
	
	}
}
	
	
