package lcmobile_regression;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Mobile_R2_VDL_Profile {
	WebDriver driver;
	
@BeforeMethod
	
	public void before() throws InterruptedException{

	    ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    driver.manage().window().maximize();
	    
	
	}
	
	@Test(priority=1)
	public void Mobile_VDL_Profile_Regression2_CallIcon() throws InterruptedException{
		
		driver.get("http://www.sulekha.com/ac-care-the-cooling-people-virugambakkam-chennai-contact-address");
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/div[1]/section/section/div[4]/ul/li[1]/a")).click();
		Thread.sleep(3000);
		try{	
			Pattern image = new Pattern("D:\\Harish\\YP_Mobile_Regression\\Testdata\\callaction.png");
			Screen screen = new Screen();			
			screen.setAutoWaitTimeout(05);
			screen.click(image);
			Reporter.log("Call button is working fine");
			}catch(Exception ie94){
				Reporter.log("Call button is not working ");
				Assert.fail();
			}
	
	}
	
	@Test(priority=2)
	public void Mobile_VDL_Profile_Regression2_ScoreLink() throws InterruptedException{
		
		driver.get("http://www.sulekha.com/new-freezing-point-k-k-nagar-chennai-contact-address");
		Reporter.log("http://www.sulekha.com/new-freezing-point-k-k-nagar-chennai-contact-address");
		Thread.sleep(5000);
		//click on sulekhascore
		driver.findElement(By.xpath("//div[1]/div/div/span[2]/span/a")).click();
		System.out.println("score link clicked");
		Thread.sleep(3000);		
		  ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());

          driver.switchTo().window(tabs2.get(1));    
      	Thread.sleep(3000);
		
		String s=driver.findElement(By.xpath("html/body/div[2]/div/div[1]/h1")).getText();
		if(s.contains("Sulekha score")){
			
			Reporter.log("Sulekha score link navigation : Pass");
			System.out.println("Sulekha score link navigation sucessfull");
			driver.close();
		}else{
			Reporter.log("Sulekha score link navigation : Fail");
			System.out.println("Sulekha score link navigation failed");
			driver.close();
			Assert.fail();
		}
		//driver.close();
		 driver.switchTo().window(tabs2.get(0));  
		driver.close();
		
	}
	

	@Test(priority=3)
	public void Mobile_VDL_Profile_Regression2_ReviewTab() throws InterruptedException{
		
		driver.get("http://www.sulekha.com/new-freezing-point-k-k-nagar-chennai-contact-address");
		Reporter.log("http://www.sulekha.com/new-freezing-point-k-k-nagar-chennai-contact-address");
		Thread.sleep(5000);
		//click on sulekhascore
		driver.findElement(By.xpath("html/body/div[1]/section/section/div[2]/ul/li[2]/a")).click();
		System.out.println("Review tab clicked");
		Thread.sleep(3000);
		String s=driver.findElement(By.xpath("html/body/div[1]/section/section/div[2]/div/section[2]/div/h2")).getText();
		if(s.contains("Rating & Reviews")){
			
			Reporter.log("Review tab navigation : Pass");
			System.out.println("Review tab navigation sucessfull");
			driver.close();
		}else{
			Reporter.log("Review tab navigation : Pass");
			System.out.println("Review tab navigation failed");
			driver.close();
			Assert.fail();
		}
		driver.close();
		
	}
	
	@Test(priority=4)
	public void Mobile_VDL_Profile_Regression2_Listcard_TCApply() throws InterruptedException, FindFailed{
		driver.get("http://www.sulekha.com/new-freezing-point-k-k-nagar-chennai-contact-address");
		Thread.sleep(4000);
		Reporter.log("http://www.sulekha.com/new-freezing-point-k-k-nagar-chennai-contact-address");
		 driver.switchTo().defaultContent();
		  Thread.sleep(3000);
		  Pattern image = new Pattern("D:\\Harish\\YP_Mobile_Regression\\Testdata\\TandCappply.png");
			Screen screen = new Screen();			
			screen.setAutoWaitTimeout(10);
			screen.click(image);
		  Thread.sleep(4000);
		  ArrayList<String> tabs21 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs21.get(1));	 
			 if(driver.getTitle().contains("Terms & Conditions")){  
					System.out.println("Landing page URL is: "+driver.getTitle());
					Reporter.log("Landed in proper page from list card and page title is: "+driver.getTitle());
					 }else{
						 Reporter.log("Landed in wrong page from list card and page title is: "+driver.getTitle());
						Assert.fail();
					 } 
	} 
	
@Test(priority=5)
public void Mobile_VDL_Profile_Regression2_ServicesMore() throws InterruptedException{
	
	driver.get("http://www.sulekha.com/ptc-aviation-academy-chromepet-chennai-contact-address");
	Reporter.log("http://www.sulekha.com/ptc-aviation-academy-chromepet-chennai-contact-address");
	Thread.sleep(5000);
	//click on sulekhascore
	driver.findElement(By.xpath("//div[2]/div/section[1]/div[1]/ul/li[7]/a")).click();
	System.out.println("services more link clicked");
	
	String s=driver.findElement(By.xpath("//div[2]/div/section[1]/div[1]/ul")).getText();
	if(!s.contains("More »")){
		
		Reporter.log("Services offered more link navigation : Pass");
		System.out.println("Services offered more link navigation sucessfull");
		
	}else{
		Reporter.log("Services offered more link navigation : Fail");
		System.out.println("Services offered more link navigation failed");
		driver.close();
		Assert.fail();
	}
	
} 

@Test(priority=6)
public void Mobile_VDL_Profile_Regression2_ReviewHelpfulBtn() throws InterruptedException{
	
	driver.get("http://www.sulekha.com/category-king-locality9-ypcity-contact-address");
	Reporter.log("http://www.sulekha.com/category-king-locality9-ypcity-contact-address");
	Thread.sleep(5000);
	//click on Review tab
	driver.findElement(By.xpath("html/body/div[1]/section/section/div[2]/ul/li[2]/a")).click();
	System.out.println("Review tab clicked");
	Thread.sleep(5000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,500)", "");
	Thread.sleep(2000);
	driver.switchTo().defaultContent();
	// Click on helpful button
	driver.findElement(By.xpath("//div[2]/div/div/ul/li/div/a")).click();
	System.out.println("clicked on the helpful button");
	Thread.sleep(2000);
	
	String s=driver.findElement(By.cssSelector(".replylist.open>p")).getText();
	Thread.sleep(3000);
	System.out.println(s+"dfsdfsdfds");
	if(s.contains("Thanks for your review")||s.contains("Sorry. You already voted for this review.")){
		
		Reporter.log("Review tab navigation : Pass");
		System.out.println("Review tab navigation sucessfull");
		driver.close();
	}else{
		Reporter.log("Review tab navigation : failed");
		System.out.println("Review tab navigation failed");
		driver.close();
		Assert.fail();
	}
	driver.close();
	
}


@Test(priority=7)
public void Mobile_VDL_Profile_Regression2_ViewMoreReviews() throws InterruptedException{

driver.get("http://www.sulekha.com/ptc-aviation-academy-chromepet-chennai-contact-address");
Reporter.log("http://www.sulekha.com/ptc-aviation-academy-chromepet-chennai-contact-address");
Thread.sleep(5000);
//click on Review tab
driver.findElement(By.xpath("html/body/div[1]/section/section/div[2]/ul/li[2]/a")).click();
System.out.println("Review tab clicked");
Thread.sleep(3000);

JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("window.scrollBy(0,600)", "");
Thread.sleep(2000);

// Get 1st review
String str= driver.findElement(By.xpath("//div/div[2]/div[2]/div/div/ul/li[1]/h3")).getText();
System.out.println("first user name :"+str);
Thread.sleep(2000);

driver.findElement(By.xpath("//div/div[2]/div[2]/div/div/button")).click();
Thread.sleep(3000);
// get 2nd set 1st user
String str1=driver.findElement(By.xpath("//div/div[2]/div[2]/div/div/ul/li[6]/h3")).getText();
System.out.println("2nd set review first user name :"+str1);
Thread.sleep(3000);
if(str!=str1){
	
	Reporter.log("Review tab navigation : Pass");
	System.out.println("Review tab navigation sucessfull");
	
}else{
	Reporter.log("Review tab navigation : Pass");
	System.out.println("Review tab navigation failed");
	driver.close();
	Assert.fail();
}
driver.close();
}

@Test(priority=8)
public void Mobile_VDL_Profile__Tollfreeimage() throws InterruptedException, FindFailed  {	
	driver.get("http://www.sulekha.com/ptc-aviation-academy-chromepet-chennai-contact-address");
	Thread.sleep(4000);
	Reporter.log(driver.getCurrentUrl());		
		driver.switchTo().defaultContent();					
driver.findElement(By.cssSelector(".toll-call>img")).click();
Thread.sleep(3000);
try{	
Pattern image = new Pattern("D:\\Harish\\YP_Mobile_Regression\\Testdata\\callaction.png");
Screen screen = new Screen();			
screen.setAutoWaitTimeout(10);
screen.click(image);
Reporter.log("Tollfreeimage block working fine");
}catch(Exception ie94){
	Reporter.log("Tollfreeimage block  not working");
	Assert.fail();
}
	

}

	@Test(priority=9)
	public void Mobile_VDL_Profile_Regression2_BVNIcon() throws InterruptedException{
		
		driver.get("http://www.sulekha.com/new-freezing-point-k-k-nagar-chennai-contact-address");
		Reporter.log("http://www.sulekha.com/new-freezing-point-k-k-nagar-chennai-contact-address");
		Thread.sleep(4000);
		//click on sulekhascore
		driver.findElement(By.xpath("//div[2]/ul/li[1]/a[2]")).click();
		System.out.println("BVN Icon link clicked");
		Thread.sleep(3000);
		
		  ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());

          driver.switchTo().window(tabs2.get(1));    
      	Thread.sleep(3000);
		
		String s=driver.findElement(By.xpath("html/body/div[2]/div[1]/div[4]/div[1]/div/div/div/div[2]/div[1]/span")).getText();
		if(s.contains("Terms & conditions")){
			
			Reporter.log("BVN icon link navigation : Pass");
			System.out.println("BVN icon link navigation sucessfull");
			driver.close();
		}else{
			Reporter.log("BVN icon link navigation : Fail");
			System.out.println("BVN icon link navigation failed");
			driver.close();
			Assert.fail();
		}
		//driver.close();
		 driver.switchTo().window(tabs2.get(0));  
		driver.close();
		
	}
	
	
	


@Test(priority=10)
public void Mobile_VDL_Profile_Regression2_SulAppBanner() throws InterruptedException{
	
	driver.get("http://www.sulekha.com/ptc-aviation-academy-chromepet-chennai-contact-address");
	Reporter.log("http://www.sulekha.com/ptc-aviation-academy-chromepet-chennai-contact-address");
	Thread.sleep(4000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.scrollBy(0,600)", "");
    Thread.sleep(2000);
 
    WebElement banner= driver.findElement(By.xpath("html/body/div[1]/section/section/div[3]/a/img"));
    System.out.println("banner is there");
    if(banner.isDisplayed()){
		
    	banner.click();
    	Thread.sleep(3000);
		Reporter.log("Sulekha banner is displayed & clickable");
		System.out.println("Sulekha banner is displayed & clickable");
		 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());

         driver.switchTo().window(tabs2.get(1));    
     	Thread.sleep(3000);
		System.out.println("banner click landing page is:"+driver.getCurrentUrl());
		Reporter.log("banner click landing page is:"+driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(tabs2.get(0));
		
		
	//	driver.getTitle()
	}else{
		Reporter.log("Banner is not displayed & unable to click");
		System.out.println("Banner is not displayed & unable to click");
		driver.close();
		Assert.fail();
	}
	
	driver.close();

}

@Test(priority=11)
public void Mobile_VDL_Profile_Regression2_OwnThisListing() throws InterruptedException{
	
	driver.get("http://www.sulekha.com/b-kool-air-conditioning-refrigeration-services-old-pallavaram-chennai-contact-address");
	Reporter.log("http://www.sulekha.com/b-kool-air-conditioning-refrigeration-services-old-pallavaram-chennai-contact-address");
	Thread.sleep(4000);
	JavascriptExecutor jse = (JavascriptExecutor)driver;
    jse.executeScript("window.scrollBy(0,550)", "");
    Thread.sleep(2000);
 
   driver.findElement(By.xpath("//div[2]/div/section[1]/div[2]/div/a")).click();
   System.out.println("clicked on own this listing");
    
   ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());

   driver.switchTo().window(tabs2.get(1));    
	Thread.sleep(3000);
   
	String  s= driver.findElement(By.xpath("html/body/div[2]/div[1]/div[7]/div/div/div/h2")).getText();
	Thread.sleep(3000);
   if(s.contains("Benefits of listing ")){
	
	   	Reporter.log("OwnThisListing link navigation to Sp web : Pass");
		System.out.println("OwnThisListing link navigation to Sp web : Pass");
	}else{
		Reporter.log("OwnThisListing link navigation to Sp web : fail");
		System.out.println("OwnThisListing link navigation to Sp web : fail");
		driver.close();
		Assert.fail();
	}
   driver.switchTo().window(tabs2.get(0));
	
	driver.close();

}


@AfterMethod()
public void aft(){
	try{
		driver.quit();
	}catch(Exception ie933){
		
	}
}
}
