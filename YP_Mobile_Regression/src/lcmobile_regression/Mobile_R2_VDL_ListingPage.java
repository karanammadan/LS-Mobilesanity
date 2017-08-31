package lcmobile_regression;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Mobile_R2_VDL_ListingPage {
WebDriver driver;String url;int tc4, tc1,tc8,tc11;
	
	@BeforeMethod
	public void openURL() throws InterruptedException{
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("default");
		myprofile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.2; ASUS_T00I Build/KVT49L) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.93 Mobile Safari/537.36");
	    driver = new FirefoxDriver(myprofile);
	    Thread.sleep(3000);	  
		driver.manage().window().maximize();
		try{
		driver.findElement(By.className("lcf-close")).click();
		}catch(Exception ie098){
			
		}
	}
	
	
	@Test(enabled=true,priority=2)
	public void Mobile_VDL_Listing_Morelink_Photolink_Nextpage_Listcard() throws InterruptedException{
	
		driver.get("http://www.sulekha.com/ac-dealers/chennai");
		Thread.sleep(7000);
		Reporter.log(driver.getCurrentUrl());
//about more
		driver.switchTo().defaultContent();
		 Thread.sleep(2000);
		 WebElement e=driver.findElement(By.xpath("//li[1]/div[2]/div[1]/p/a"));
		 Thread.sleep(2000);
		 String url=e.getAttribute("href");
		 System.out.println(url);
				 e.click();								
		    Thread.sleep(2000);
		    if(driver.getCurrentUrl().contentEquals(url)){
		    	System.out.println("More link is working");		    	
		    	Thread.sleep(2000);
		    	System.out.println("less link is working");
		    	Reporter.log("About block More and less : Pass");
		    }else{
		    	System.out.println("More link is not displayed");
		    	Reporter.log("About block morw and less : Fail");
		    	driver.close();
		    	tc1++;
		    }
		    
 //photoimage
		    driver.navigate().to("http://www.sulekha.com/ac-dealers/chennai");
		    Thread.sleep(4000);
		    driver.findElement(By.xpath("//div[1]/ol/li[1]/div[2]/div[2]/figure/img")).click();
		    try{
		    if(driver.findElement(By.xpath("//div/div/img")).isDisplayed()){
		    	Reporter.log("Photo image navigation is fine");
		    }else{
		    	Reporter.log("Photo image navigation is failed");
		    	tc1++;
		    }
		    }catch(Exception ie334){
		    	Reporter.log("Photo image navigation is failed");
		    	tc1++;
		    }
		    try{
		    	Thread.sleep(2000);
			  driver.findElement(By.cssSelector(".sgallery-x")).click();
			    }catch(Exception ie3134){
			    }
		    Thread.sleep(2000);
//photolink
		    
		    driver.findElement(By.xpath("//li[1]/div[2]/div[2]/a")).click();
		    try{
		    if(driver.findElement(By.xpath("//div/div/img")).isDisplayed()){
		    	Reporter.log("Photos link navigation is fine");
		    }else{
		    	Reporter.log("Photos link navigation is failed");
		    	tc1++;
		    }
		    }catch(Exception ie364){
		    	Reporter.log("Photos link navigation is failed");
		    	tc1++;
		    }
		    
//nextpage
		    driver.navigate().to("http://www.sulekha.com/ac-dealers/chennai");
		    Thread.sleep(6000);
		    try{
		    	Thread.sleep(2000);
			  driver.findElement(By.cssSelector(".sgallery-x")).click();
			    }catch(Exception ie3134){
			    }
		    Thread.sleep(2000);
		    
		    driver.findElement(By.id("nextPage")).click();
		    Thread.sleep(3000);
		    try{
		    	driver.findElement(By.id("prevPage")).click();
		    	 Thread.sleep(3000);
		    	Reporter.log("Next page button is pass");  
		    	try{
		    		 driver.findElement(By.id("nextPage")).click();
		    		 Reporter.log("Previous page button is pass");
		    	}catch(Exception ie1234){
			    	Reporter.log("Previous page button is failed");
			    	tc1++;
			    }
		    }catch(Exception ie234){
		    	Reporter.log("Next page button is failed");
		    	tc1++;
		    }
}


	@Test(enabled=true,priority=3)
	public void Mobile_VDL_Listing_Shortlist() throws InterruptedException{
		
		driver.get("http://www.sulekha.com/pest-control-services/ypcity");
		Thread.sleep(4000);
		Reporter.log(driver.getCurrentUrl());	
	 try{
		  driver.findElement(By.cssSelector(".lcf-close")).click();
		   }catch(NoSuchElementException ie7){
		 	   }
	 Thread.sleep(4000);
	  WebDriverWait wait=new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".navbar-icon")));
	 //login
	 driver.findElement(By.cssSelector(".navbar-icon")).click();
	 Thread.sleep(2000);
	 try{
	 driver.findElement(By.cssSelector(".btn-t.signin-btn")).click();
	 }catch(Exception ie8933){
		 try{
			 driver.findElement(By.cssSelector(" .icon-logout")).click();
			 Thread.sleep(2000);	
			 driver.findElement(By.cssSelector(".navbar-icon")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.cssSelector(".btn-t.signin-btn")).click();
			 Thread.sleep(2000);
		 }catch(Exception ie93933){
			 
		 }
	 }
	    Thread.sleep(8000);
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.switchTo().frame("frMyAccount");
	    Thread.sleep(4000);
	    driver.findElement(By.id("txtuname")).clear();
	    Thread.sleep(2000);
	    driver.findElement(By.id("txtuname")).sendKeys("saivaduraij@sulekha.net");
	    Thread.sleep(2000);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.findElement(By.id("txtpwd")).clear();
	    Thread.sleep(2000);
	    driver.findElement(By.id("txtpwd")).sendKeys("saivadurai");
	    Thread.sleep(2000);
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    driver.findElement(By.id("btnsignin")).click();
	    Thread.sleep(6000);	    
	    driver.switchTo().defaultContent(); 
	    Thread.sleep(2000);
//click shortlist
	    driver.findElement(By.id("nextPage")).click();
	    Thread.sleep(3000);
	    WebElement shortlisted=driver.findElement(By.cssSelector("#m_divV8Businesslist"));
	    List<WebElement> shortlisted1 = shortlisted.findElements(By.cssSelector(".sl-bookmark.icon-bookmark.GAQ_C_SHORTLIST.active"));
	    for(WebElement e : shortlisted1) {
	     e.click();
	     Thread.sleep(500);
	    }
	    WebElement shortlist1=driver.findElement(By.cssSelector("#m_divV8Businesslist"));
	    List<WebElement> shortlisted2 = shortlist1.findElements(By.cssSelector(".sl-bookmark.icon-bookmark.GAQ_C_SHORTLIST"));
	    for(WebElement e1 : shortlisted2) {
	     e1.click(); 
	     break;
	    }	 
	    Thread.sleep(4000);	    
	    WebElement shortlist3=driver.findElement(By.cssSelector("#m_divV8Businesslist"));
	    List<WebElement> shortlisted13 = shortlist3.findElements(By.cssSelector(".sl-bookmark.icon-bookmark.GAQ_C_SHORTLIST.active"));
	    for(WebElement e : shortlisted13) {
	    	try{
	      	e.click();
	      	Reporter.log("Shortlist sucessfull");
	    	}catch(Exception ie9383){
	    		Reporter.log("Shortlist failed");
	    		Assert.fail();
	    	}
	     Thread.sleep(500);
	    }
	 
	}
	
	@Test(priority=4)
	public void Mobile_VDL_Listing_Listcard_TCApply_() throws InterruptedException, FindFailed{
		driver.get("http://www.sulekha.com/ac-dealers/chennai");
		Thread.sleep(4000);
		Reporter.log("http://www.sulekha.com/ac-dealers/chennai");
		driver.findElement(By.cssSelector(".tnc-apply")).click();
		Thread.sleep(2000);
		  ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(1));	 
		    Thread.sleep(3000);
		 if(driver.getTitle().contains("Terms & Conditions")){  
		System.out.println("Landing page URL is: "+driver.getTitle());
		Reporter.log("Landed in proper page and page title is: "+driver.getTitle());
		 }else{
			 Reporter.log("Landed in wrong page and page title is: "+driver.getTitle());
			 tc4++;
		 }
//listcard
		  driver.switchTo().window(tabs2.get(0));
		  Thread.sleep(4000);
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
						 tc4++;
					 } 
			 
			 if(tc4>0){
				 Assert.fail();
	}
	}
	
	@Test(priority=5)
	public void Mobile_VDL_Listing_WhyFillthisForm_Navigations() throws InterruptedException{
		driver.get("http://www.sulekha.com/ac-services/chennai");
		Thread.sleep(4000);
		Reporter.log(driver.getCurrentUrl());
		   String txt1=driver.findElement(By.xpath("//div/div[2]/div[1]/div/ul/li[1]/p")).getText();
		   System.out.println(txt1);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div/div[2]/div[2]/a[2]")).click();
			Thread.sleep(1000);
			 String txt2=driver.findElement(By.xpath("//div/div[2]/div[1]/div/ul/li[2]/p")).getText();	
			  System.out.println(txt2);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div/div[2]/div[2]/a[3]")).click();
			Thread.sleep(1000);
			 String txt3=driver.findElement(By.xpath("//div/div[2]/div[1]/div/ul/li[3]/p")).getText();
			  System.out.println(txt3);
			if(txt1.contentEquals(txt2)||txt2.contentEquals(txt3)){
				Reporter.log("Navigation not working");
				Assert.fail();
			}else{
				Reporter.log("Navigation  working fine");
			}
			
			
		}
		
	@Test(priority=6)
	public void Mobile_VDL_Listing_ProfileLink() throws InterruptedException{
		driver.get("http://www.sulekha.com/ac-services/chennai");
		Thread.sleep(4000);
	Reporter.log(driver.getCurrentUrl());
	Thread.sleep(2000);
	String s=driver.findElement(By.xpath("//div[2]/div[1]/ol/li[1]/div[1]/h3/a")).getText();
	s.replaceAll("[^0-9.]", "");
	System.out.println("sp name is: "+s);
	
	driver.findElement(By.xpath("//div[2]/div[1]/ol/li[1]/div[1]/h3/a")).click();

	Thread.sleep(5000);
	String s1=driver.getTitle();
	s1.replaceAll("[^0-9.]", "");
	System.out.println(s1);
	System.out.println();
	if(s1.contains(s.substring(0, 10))){			
		System.out.println("landed on the SP profile page sucessfully");
		Reporter.log("Profile page navigaiton is sucess");
		driver.close();
	}else{
		System.out.println("landed on irrelavant page");
		Reporter.log("Profile page naviagtion failed");
		driver.close();
		Assert.fail();
	}
	}
	
	@Test(priority=7)
	public void Mobile_VDL_Listing_PaidBadge() throws InterruptedException{	
		driver.get("http://www.sulekha.com/ac-services/chennai");
		Thread.sleep(4000);
		Reporter.log(driver.getCurrentUrl());		
		for(int i=1;i<=10;i++){		
			driver.switchTo().defaultContent();
			try{			
			driver.findElement(By.cssSelector(".most-preferred-40")).isDisplayed();
			Reporter.log("Paid badge is  displayed");
			break;
			}catch(Exception ie838){
				if(i==10){
					Reporter.log("Paid badge is not displayed");
					Assert.fail();
				}
			}
			Thread.sleep(1000);
		}
	
	}
		
	@Test(priority=8)
	public void Mobile_VDL_Listing_BrandFilter_ResetFilter() throws InterruptedException{
		driver.get("http://www.sulekha.com/ac-services/chennai");
		Thread.sleep(4000);	
		Reporter.log(driver.getCurrentUrl());
       String txt1=driver.findElement(By.xpath("//div[1]/ol/li[1]/div[1]/h3/a")).getText();
      Reporter.log("Before filter 1st busines : "+txt1);
       driver.findElement(By.cssSelector(" #filter")).click();
       Thread.sleep(5000);
       driver.findElement(By.xpath("//div[3]/div/ul/li[5]/a")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//div/div/div[5]/ul/li[1]/label")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//div/div/div[5]/ul/li[2]/label")).click();
       Thread.sleep(2000);       
       driver.findElement(By.cssSelector(" .apply")).click();
       Thread.sleep(4000);
       String txt2=driver.findElement(By.xpath("//div[1]/ol/li[1]/div[1]/h3/a")).getText();
       Reporter.log("After filter 1st busines : "+txt2);
       if(txt1.contentEquals(txt2)){
    	   Reporter.log("Brand filter  not working fine");
    	   tc8++;
       }else{
    	   Reporter.log("Brand filter  working fine "); 
    	   
       }
       
   //Reset filter
       driver.navigate().to("http://www.sulekha.com/used-ac-buying-selling/chennai");
		Thread.sleep(4000);	
		String title1=driver.getTitle();
       driver.findElement(By.cssSelector(" #filter")).click();
       Thread.sleep(5000);
       driver.findElement(By.cssSelector("#resetFilter>a")).click();
       Thread.sleep(3000);
       String title2=driver.getTitle();
       if(title1.contentEquals(title2)){
    	   Reporter.log("Reset filter not working ");
    	   tc8++;
       }else{
    	   Reporter.log("Reset filter  working");
    	 
       }
       
      if(tc8>0){
    	  Assert.fail();
      }
	}

	@Test(priority=9)
	public void Mobile_VDL_Listing_Tollfreeimage() throws InterruptedException, FindFailed  {	
		driver.get("http://www.sulekha.com/ac-services/chennai");
		Thread.sleep(4000);
		Reporter.log(driver.getCurrentUrl());		
			driver.switchTo().defaultContent();					
  driver.findElement(By.cssSelector(".order-list>li>a>img")).click();
	try{	
	Pattern image = new Pattern("D:\\Harish\\YP_Mobile_Regression\\Testdata\\callaction.png");
	Screen screen = new Screen();			
	screen.setAutoWaitTimeout(05);
	screen.click(image);
	Reporter.log("Tollfreeimage block working fine");
	}catch(Exception ie94){
		Reporter.log("Tollfreeimage block  not working");
		Assert.fail();
	}
		
	
	}
	
	@Test(priority=10)
	public void Mobile_VDL_Listing_ChatwithUsimage() throws InterruptedException, FindFailed  {	
		driver.get("http://www.sulekha.com/ac-services/chennai");
		Thread.sleep(8000);
		Reporter.log(driver.getCurrentUrl());
		 JavascriptExecutor jse = (JavascriptExecutor) driver;
		    jse.executeScript("window.scrollBy(0,300)", "");
		    Thread.sleep(4000);
			driver.switchTo().defaultContent();	
			Thread.sleep(2000);
	try{	
	Pattern image = new Pattern("D:\\Harish\\YP_Mobile_Regression\\Testdata\\chat.png");
	Screen screen = new Screen();			
	screen.setAutoWaitTimeout(10);
	screen.click(image);
	Reporter.log("Chat with Us image is displayed");
	}catch(Exception ie94){
		Reporter.log("Chat with Us image not displayed");
		Assert.fail();
	}
	
	}
	
		
	@Test(priority=11)
	public void Mobile_VDL_Listing_Citylink_Allcitypage() throws InterruptedException{	
		driver.navigate().to("http://www.sulekha.com/ac-services/all-cities");
		Thread.sleep(5000);	
		Reporter.log(driver.getCurrentUrl());
		String txt=driver.findElement(By.xpath("html/body/div[1]/section[1]/div[2]/div/ul/li[3]/ul/li[4]/a")).getText();
		driver.findElement(By.xpath("html/body/div[1]/section[1]/div[2]/div/ul/li[3]/ul/li[4]/a")).click();		
		Thread.sleep(4000);
		if(driver.getTitle().contains("AC Service")&&(driver.findElement(By.cssSelector(".ch-city>a")).getText().contentEquals("Patna"))){
			Reporter.log("City  link is navigating proper page");
			Reporter.log("Clicked blog : "+txt);
			Reporter.log("Navigated page title : "+driver.getTitle());
		
		}else{
			Reporter.log("Read more link not working fine");
			Reporter.log("Clicked blog : "+txt);
			Reporter.log("Navigated page title : "+driver.getTitle());			
			Assert.fail();
		}
	
	}
	
@Test(priority=11)
public void Mobile_VDL_Listing_Category_Grandparentpage() throws InterruptedException{	
	driver.navigate().to("http://www.sulekha.com/business-services");
	Thread.sleep(5000);	
	Reporter.log(driver.getCurrentUrl());
	
	//category link
	String txt=driver.findElement(By.xpath("html/body/div[1]/section[1]/div[2]/ul/li[3]/div[1]/a")).getText();
	driver.findElement(By.xpath("html/body/div[1]/section[1]/div[2]/ul/li[3]/div[1]/a")).click();		
	Thread.sleep(4000);
	if(driver.getTitle().contains(txt)){
		Reporter.log("Category  link is navigating proper page");
		Reporter.log("Clicked Category : "+txt);
		Reporter.log("Navigated page title : "+driver.getTitle());
	
	}else{
		Reporter.log("Category link not working fine");
		Reporter.log("Clicked Category : "+txt);
		Reporter.log("Navigated page title : "+driver.getTitle());			
		Assert.fail();
	}

}

@AfterMethod()
public void aft(){
	try{
		driver.quit();
	}catch(Exception ie933){
		
	}
}
}
