package Library;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;

import com.thoughtworks.selenium.DefaultSelenium;

/****************************************************************************************************/




/****************************************************************************************************/

@SuppressWarnings("deprecation")
public class DriverScript extends ReadingExcelSheet implements Locators {
	public static final String ProjectPath = ".//";
	public  WebDriver driver;
	public static  DefaultSelenium selenium;
	public static String Sheetname ;
	public static String TableName ;
	public String DisplayedText = "";
	public String AlertMsg = "";
	public String Browsr = "";
	public String AssertMsg ="";
	public String BRoom1="",BRoom2="",ResidentType="",CommercialType="",Flag = "False";
    public int m =0;
    public WebElement Element;
	//public static String Data = "";
/*****************************************************************************************************/	
    
	// Data Provider
	@DataProvider(name = "DataFeeder")
 	public static Object[][] Data() throws Exception
 		{
		//System.out.println(ProjectPath);
			Object[][] retObjArr=getTableArray(ProjectPath+"TestData//"
        		+"Test_Data.xls",Sheetname,TableName);
			
			return(retObjArr);
 		}
	// Data Provider	

	
/***********************************************************************************************/
	

	
	public void OpenUrl(String URL)
	{
		try {
			
			  driver = new FirefoxDriver();
			  driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			  driver.get(URL);
			  driver.manage().window().maximize();
			  System.out.println("Required URL Opened Successfully");
		} catch (Exception e) {
			System.out.println(URL+" not found");
		}
		
	}
/**********************************************************************************************/	
	// Method for Selecting Desired Browser
	public void SelectBrowser(String BROWSER) throws Exception{

		 System.out.println("Browser: " + BROWSER);
		 if (BROWSER.equals("FF")) {
			    Browsr = "Firefox_";
			    System.out.println("Firefox is selected");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			  } else if (BROWSER.equals("IE")) {
				Browsr = "IExplore_";
			    System.out.println("IE is selected");
			    driver = new InternetExplorerDriver();
			    driver.manage().window().maximize();
			    Thread.sleep(2000); 
			  } else if (BROWSER.equals("Chrome")){
				Browsr = "Chrome_";
			    System.out.println("Google chrome is selected");
			    driver = new ChromeDriver();
			    driver.manage().window().maximize();
			    Thread.sleep(2000);
		 }
	}
	// End of Method for Selecting Desired Browser
	
/*****************************************************************************************************/	
	
	public WebElement ConvertToWebElement(String LocType,String Locator)
	{
	
		try {
			
			
			if(LocType.equalsIgnoreCase("id"))
			{
				Element = driver.findElement(By.id(Locator));
				
			}
			else if(LocType.equalsIgnoreCase("name"))
			{
				Element = driver.findElement(By.name(Locator));
				
			}
			else if(LocType.equalsIgnoreCase("CssSelector"))
			{
				Element = driver.findElement(By.cssSelector(Locator));
				
			}
			else if(LocType.equalsIgnoreCase("Xpath"))
			{
				Element = driver.findElement(By.xpath(Locator));
				
			}
			else if(LocType.equalsIgnoreCase("LinkText"))
			{
				Element = driver.findElement(By.linkText(Locator));
				
			}
			
		} catch (Exception e) 
		{
			Reporter.log("Please check Locator type");
		}
		return Element;
	}
/*****************************************************************************************************/	
	public void HighlightElement(WebElement ElementToHighlight)
	{ 
	
		for (int i = 0; i < 2; i++) 
		{
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", ElementToHighlight, "color: yellow; border: 2px solid yellow;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", ElementToHighlight, "");
		}
		
	}
	// Method to switch to new window
	
/*********************************************************************************************/	
	//Method to select a value from ajax result
	public void SelectByTab(WebElement Element6, String Data) throws Exception
	{
		try {
			Element6.click();
			Element6.clear();
			Element6.sendKeys(Data);
			Thread.sleep(1000);
			Element6.sendKeys(Keys.TAB);
		   } catch (NoSuchElementException e)
		   {
			   Reporter.log("Required DDL not found to select the given data :"+Data);
			   AssertMsg = AssertMsg+", "+"Required DDL not found to select the given data :"+Data;
				 
		   } catch (ElementNotVisibleException e1) {
			   Reporter.log("Required DDL not Visible to select the given data :"+Data);
			    AssertMsg = AssertMsg+", "+"Required DDL is not Visible to select the given data :"+Data;
		  }

	}
/*****************************************************************************************************/	
	
	public void SwitchToNewWindow()
	{
		try 
		{
			String childwindow = null;
			for(String window: driver.getWindowHandles())
				{
					childwindow = window;
				    driver.switchTo().window(childwindow);
				}
		} catch (NoSuchWindowException e)
		{
			Reporter.log("No New WIndow/Popup found");
		}
	}
	
/***********************************************************************************************/
public void Set(WebElement Element2,String Data) throws Exception
{
	if(!(Data.trim()==""))
	      {
			     try {
			    	    Element2.clear();
			    	    Element2.sendKeys(Data.trim());	
			    	    Data = "";
			         }  catch (NoSuchElementException e)
				    {
					    Reporter.log("Required TextBox not found to enter the given data :"+Data);
					    AssertMsg = AssertMsg+", "+"Required TextBox not found to enter the given data :"+Data;	
				    }   catch (ElementNotVisibleException e1) 
				    {
				    	Reporter.log("Required TextBox not Visible to enter the given data :"+Data);
				    	AssertMsg = AssertMsg+", "+"Required TextBox not Visible to enter the given data :"+Data;	
					}
	    	}
}
/********************************************************************************************************/
//Method to select from ddl
public void SelectFromDDL_Options(WebElement Element,String Data)
{
try{
	
	    List<WebElement> options = Element.findElements(By.tagName("option"));
		    for (WebElement option : options) 
		    {
		        if(Data.equals(option.getText()))
		        {
		        	 option.click();
		        	 break;
		        }
		           
		    }
   }catch (NoSuchElementException e)
   {
	   Reporter.log("Required DDL not found to select the given data :"+Data);
	   AssertMsg = AssertMsg+", "+"Required DDL not found to select the given data :"+Data;
		 
   } catch (ElementNotVisibleException e1) {
	   Reporter.log("Required DDL not Visible to select the given data :"+Data);
	    AssertMsg = AssertMsg+", "+"Required DDL is not Visible to select the given data :"+Data;
}

}
/******************************************************************************************************/
/*//Method to select from ddl
public void SelectFromDDL2(By by1,By by2,String tagname,String Data) throws Exception
{
try{
	ClickOn(by1);
	WebElement select = driver.findElement(by2);
	    List<WebElement> options = select.findElements(By.tagName(tagname));
		    for (WebElement option : options) 
		    {
		        if(Data.equalsIgnoreCase(option.getText()))
		        {
		        	 option.click();
		        	 break;
		        }
		           
		    }
 }catch (NoSuchElementException e)
 {
	   Reporter.log(by1+" Element not found");
		  Assert.fail(by1+" Element not found");
 } catch (ElementNotVisibleException e1) {
	   Reporter.log(by1+" Element not Displayed");
	  Assert.fail(by1+" Element not Displayed");
}

}*/
/*********************************************************************************************************/
public void Select(By by ,String Data) throws Exception
{
	if(!(Data.trim()==""))
	{   
		try {
			   driver.findElement(by).sendKeys(Data.trim());
			   Data = "";
	     	}
		    catch (NoSuchElementException e)
		    {
			   Reporter.log("Required DDL not found to select the given data :"+Data);
			   AssertMsg = AssertMsg+", "+"Required DDL not found to select the given data :"+Data;
		 
		    } 
		    catch (ElementNotVisibleException e1) 
		    {
			   Reporter.log("Required DDL not Visible to select the given data :"+Data);
			   AssertMsg = AssertMsg+", "+"Required DDL is not Visible to select the given data :"+Data;
		    }

	}
}
/*********************************************************************************************************/

/*public void SelectByLabel(String Data,By by )
{
	 WebElement Amnity = driver.findElement(by);
		List<WebElement> Amenities = Amnity.findElements(By.tagName("label"));
		for (int i = 0; i < Amenities.size(); i++) 
		{
			String Displayedtxt = Amenities.get(i).getText();
		     String AllData[] = Data.split(",");
			     for (int j = 0; j < AllData.length; j++) 
			     {  
					   if(AllData[j].equalsIgnoreCase(Displayedtxt))
					   {
						   Amenities.get(i).click();
					   }
			    }
		}
}*/

/*********************************************************************************************************/
public void ClickOn(WebElement Element2) throws Exception
{
		try {
			
			        Element2.click();
			        String TitleDiplayed = driver.getTitle();
				    if(TitleDiplayed.contains("404"))
					{
						AssertMsg = AssertMsg+", "+"PAGE IS REDIRECTING TO 404 ERROR PAGE";	
						Reporter.log("PAGE IS REDIRECTING TO 404 ERROR PAGE");
			     	}

		   }
		   catch (NoSuchElementException e)
		    {
			   Reporter.log("Required Button/Link not found to Click");
			   AssertMsg = AssertMsg+", "+"Required Button/Link not found to Click";
				 
		    } 
		    catch (ElementNotVisibleException e1) 
		    {
			   Reporter.log("Required Button/Link not Visible to Click");
			   AssertMsg = AssertMsg+", "+"Required Button/Link not Visible to Click";
		    }

	}
/*********************************************************************************************************/

public void NavigateTo(String URL)
{
    try 
    {
		  driver.navigate().to(URL);
	} catch (Exception e)
    {
		
    }	
}


/*********************************************************************************************************/
public String GetText(By by) throws Exception
{
	DisplayedText = "";
		try {
			   DisplayedText = driver.findElement(by).getText();
			   Thread.sleep(1000);
		    }  catch (NoSuchElementException e) {
			   Reporter.log(by+" Element not found");
			   Assert.assertTrue(false,by+" Element not found");
		}
	return DisplayedText.trim();
}

/**************************************************************************************************************/
public boolean IsElementPresent(WebDriver driver, By by,String ElementName){
try{
		driver.findElement(by);
		//Reporter.log(ElementName+" Element is present");
		//System.out.println(ElementName+" Element is present");
		return true;
   }    catch(NoSuchElementException e){
	   Reporter.log(ElementName+" Element is NOT present");
	   System.out.println(ElementName+" Element is NOT present");
        return false;
   }
}
/********************************************************************************************************/

public void WaitForElement(By by) throws Exception
{
	for(int i=0;i<120;i++)
	{
		   if(driver.findElement(by)!= null)
		   {
			if(driver.findElement(by).isDisplayed())
			{
				break;
			}
		   }
		else
		{
			Thread.sleep(500);
		}
	}
	
}	

/***************************************************************************************************/


public void WaitForLoaderToClose(WebElement Element) throws Exception
{
	for(int i=0;i<60;i++)
	{
		if(Element!= null)
		{
			if(Element.isDisplayed())
			{
				
				Thread.sleep(500);
			}
			else
			{
				break;
			}
		}
		else
		{
			break;
		}
		
	}
	
}	

/***************************************************************************************************/
public String AcceptAlert()
{
	try 
	{
		AlertMsg = "";
		Alert alert = driver.switchTo().alert();
		AlertMsg = alert.getText();
		alert.accept();
		//Reporter.log("An alert is raised and the message displayed is : "+AlertMsg);
	} 
	catch (NoAlertPresentException e) 
	{
		System.out.println("No Alert message present");
	}
	return AlertMsg;
}
/******************************************************************************************************/

public void AssertDisplayText(WebElement Element5, String ExpectedTextToDisplay)
{
	try {
		   Assert.assertEquals(true, Element5.getText().contains(ExpectedTextToDisplay));
		   System.out.println("Actual Text displayed is : "+Element5.getText());
		   System.out.println(ExpectedTextToDisplay+" is displaying correctly");
		   Reporter.log(ExpectedTextToDisplay+" is displaying correctly");
		   
	    } catch (AssertionError e) 
	    {
	    	AssertMsg = AssertMsg+", "+ExpectedTextToDisplay.toUpperCase()+" IS NOT DISPLAYED";	    	
	    } catch (NoSuchElementException e1)
	    {
	    	Reporter.log("Element not found to check Display of Text :"+ExpectedTextToDisplay);
	    	AssertMsg = AssertMsg+","+"Element not found to check Display of Text :"+ExpectedTextToDisplay;	   
	    } catch (ElementNotVisibleException e2) {
	    	Reporter.log("Element not Visible to check Display of Text :"+ExpectedTextToDisplay);
	    	AssertMsg = AssertMsg+","+ "Element not Visible to check Display of Text :"+ExpectedTextToDisplay;	   
		}
	
}
/***********************************************************************************************/
/*public void SignIn(String UserName,String Password) throws Exception
{
	try{
		ClickOn(By.xpath("//*[@id='sul_logintxt']/strong"));
		
		Thread.sleep(5000);
		driver.switchTo().frame("frMyAccount");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Set(By.id("txtEmail"),UserName);
		Thread.sleep(1000);
		Set(By.id("txtPass"),Password);
		Thread.sleep(1000);
		ClickOn(By.xpath(SignInButton));
	    System.out.println("SignIn Successfull");
	    Reporter.log("SignIn Successfull");
		} catch (NoSuchElementException e){
			Reporter.log("Sign In Failed");
			System.out.println("Sign In Failed as element is not found");
			AssertMsg = AssertMsg+", "+"Signin Failed as element is not found";
		}catch (ElementNotVisibleException e1) {
			Reporter.log("Sign In Failed");
			System.out.println("Sign In Failed as element is not VISIBLE");
			AssertMsg = AssertMsg+", "+"Signin Failed as element is not VISIBLE";
		}
	   
       
	}*/
/*************************************************************************************************/
	 public void MouseOver(By ElementLoc) throws Exception
	  {
		  try {
			  WebElement Element1 = driver.findElement(ElementLoc);
		  	  Actions actions = new Actions(driver);
		      actions.moveToElement(Element1).build().perform(); 	
		      Thread.sleep(1000);
		      } catch (NoSuchElementException e)
		      {
			
		      }
	  }
	/*************************************************************************************************/
	 
	 public void ExplicitWait(WebElement Element4)  
	 {  
	      WebDriverWait wait = new WebDriverWait(driver, 30);  
	      wait.until(ExpectedConditions.visibilityOf(Element4));  
	 }  
	 
	 
	 /*************************************************************************/
	 
	 /* public void SelectFromDDL_Mouseover_Links(By ElementLoc,By ValueLoc,String Val) throws Exception
	  {  
	  try {
		     if(Val!="")
		     {
		    	 MouseOver(ElementLoc);
		    	 ClickOn(ValueLoc);
		     } 
		
	      } catch (NoSuchElementException e)
	      {
	    	 
	      }
	     
		 
	  }*/
	 
	 
	 /***************************************************************************************************************/
	 public void YPContactDetails() throws Exception
	 {
		     WebElement NameElemnt = driver.findElement(By.id(Name));
		     WebElement MobNo = driver.findElement(By.id(Mobilenumber));
		     WebElement Mail = driver.findElement(By.id(Email));
		     Set(NameElemnt, YPName);
		     Set(MobNo, YPMobile);
		     Set(Mail, "madansulekha@gmail.com");
	 }
	 
	
	  /***********************************************************************************************************************/	
	 
	

/*******************************************************************************************************/

public void Postad_No_Cancel(String dt,String cat,String city,String locality1,String catname) throws Exception{	
	Reporter.log("Category name ;"+catname);	
	Calendar cal = Calendar.getInstance();
	
	 String dateString = dt;
final String OLD_FORMAT = "dd/MM/yy";
final String NEW_FORMAT = "dd-MM-yyyy";
String newDateString;
SimpleDateFormat sdfnew = new SimpleDateFormat(OLD_FORMAT);
Date d = sdfnew.parse(dateString);
sdfnew.applyPattern(NEW_FORMAT);
newDateString = sdfnew.format(d);
	  System.out.println("newDateString: "+newDateString); 
	
   SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
   String strDate = sdf.format(cal.getTime());
   System.out.println("Current date in String Format: "+strDate); 
  
    if(strDate.equals(newDateString)){
    	 System.out.println("yes");	
    	 driver.findElement(By.linkText("Log in")).click();
    		Thread.sleep(4000);
    		driver.switchTo().frame("frMyAccount");
    		Thread.sleep(10000);
    		driver.findElement(By.id("txtuname")).sendKeys("9176201513");
    		//Thread.sleep(10000);
    		driver.findElement(By.id("txtpwd")).sendKeys("sandeep");
    		//Thread.sleep(2000);
    		driver.findElement(By.id("btnsignin")).click();
    		Thread.sleep(6000);
    		driver.switchTo().defaultContent();
    		driver.findElement(By.xpath("//*[@id='location-dropdown']/a")).click();
    		driver.findElement(By.linkText("Bangalore")).click();
    		//driver.findElement(By.id("lcf-location")).sendKeys("Bangalore");
    		driver.findElement(By.id("SearchInput")).sendKeys(cat);
    		Thread.sleep(2000);
    		driver.findElement(By.partialLinkText(cat)).click();
    		Thread.sleep(5000);
    		//click on Wedding
    	
    			try{
    			driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/section/ul/li[1]/div[2]/div[1]/ul/li[1]/label/input")).click();
    			                           
    		}catch (NoSuchElementException ie){
    			
    			System.out.println("First Block is changed");
    		}	
    	
    			try{
    				driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/section/ul/li[1]/div[2]/div[2]/ul/li[1]/label/input")).click();
    		
    		}catch (NoSuchElementException ie){
    			
    			System.out.println("First Block is changed");
    		}	
    			try{	
    	
    			driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/section/ul/li[1]/div[2]/div[3]/ul/li[1]/label/input")).click();
    		}catch (NoSuchElementException ie){
    			System.out.println("Second Block is changed");
    		}	
    			try{
    			driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/section/ul/li[1]/div[2]/div[4]/ul/li[1]/label/input")).click();
    		
    		}catch (NoSuchElementException ie){
    			System.out.println("Third Block is changed");
    		}	
    			
    		
    			
    			try{
    			
        		driver.findElement(By.xpath("//*[@id='localityDd']/div[1]/span")).click();
        		driver.findElement(By.xpath("//*[@id='localityDd']/div[2]/ul/li[1]/label/input")).click();
        		        		
        		}catch (NoSuchElementException ie){
        			System.out.println("Locality not available");
        		}

    		driver.findElement(By.linkText("Submit")).click();
    		
    	
    		driver.findElement(By.xpath("html/body/div[1]/div/div/div[1]/div/a")).click();
    		driver.navigate().refresh();
    		
    		//verifying  In progress to no
    		 long startTime1=System.currentTimeMillis();
    		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		 for(int i=1;i<=10;i++){
    			 System.out.println("LLLLLLLLLLLLLLLLLLLLLL is"+i);		
    			 System.out.println("i gggggggggg is"+i);

    			try{
    				 driver.findElement(By.xpath("//*[@id='divrightpart_pos_1']/ul/li[2]/button")).isDisplayed();			
    				 long finishTime1=System.currentTimeMillis();
    				 long totalTime=(finishTime1-startTime1)/1000;
    				 System.out.println("Total time taken to display No ::"+totalTime +" Secs");
    				 Reporter.log("Total time taken to display No ::"+totalTime +" Secs");	
    				
    							
    				 break;
    					
    			}catch(NoSuchElementException ie){
    				 //i++;
    			 System.out.println("i is"+i);
    			 System.out.println("No is not displayed"+i);
    			 driver.navigate().refresh();
    		}
    		
    		 }
    		 
    			//verifying  no to job done
    		 for(int k=1;k<=10;k++){
    		
    		 try{
    			 driver.findElement(By.xpath("//*[@id='divrightpart_pos_1']/ul/li[2]/button")).click();	
    			 try{
    			 driver.findElement(By.xpath("//*[@id='infonosec_pos_1']/section/ul/li[3]/label")).click();
    			 }catch(NoSuchElementException ie){
    				 driver.findElement(By.xpath("//*[@id='needidbmatched_pos_1']/section[1]/div[2]/label")).click();	 
    			 }
    			
    			 driver.findElement(By.xpath("//*[@id='divreview_4289873']/div[2]/button[1]")).click();                              
    			 driver.findElement(By.linkText("Submit")).click();
    			 long startTime2=System.currentTimeMillis();
    			 driver.navigate().refresh();    			
    			 driver.findElement(By.xpath("//*[@id='divrightpart_pos_1']/span")).isDisplayed();
    			                    
    			 long finishTime2=System.currentTimeMillis();
    			 long totalTime2=(finishTime2-startTime2)/1000;
    			 System.out.println("Total time taken to display Cancelled ::"+totalTime2 +" Secs");
    			 Reporter.log("Category name ;"+catname);	
    			 Reporter.log("Total time taken to display Cancelled ::"+totalTime2 +" Secs");	
    			 System.out.println("k kkkkkkkk is"+k);
    			 break;
    		 }catch(NoSuchElementException ie){
    			 System.out.println("job done not displayed"+k);
    			 driver.navigate().refresh(); 
    			 
    		 }
    		 }
    	
    }else{
    	//driver.close();
    }

}
/*******************************************************************************************************/

public void Postad_Yes_jobdon1(String dt,String cat,String city,String locality1,String catname) throws Exception{	
	Reporter.log("Category name ;"+catname);	
	/*Calendar cal = Calendar.getInstance();	
	 String dateString = dt;
final String OLD_FORMAT = "dd/MM/yy";
final String NEW_FORMAT = "dd-MM-yyyy";
String newDateString;
SimpleDateFormat sdfnew = new SimpleDateFormat(OLD_FORMAT);
Date d = sdfnew.parse(dateString);
sdfnew.applyPattern(NEW_FORMAT);
newDateString = sdfnew.format(d);
	  System.out.println("newDateString: "+newDateString); 
	
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String strDate = sdf.format(cal.getTime());
    System.out.println("Current date in String Format: "+strDate);
  */ 
  
   
   
    	 System.out.println("yes sdfadsfcsfgdx");	
    	    driver.findElement(By.linkText("Log in")).click();
    		Thread.sleep(4000);
    		driver.switchTo().frame("frMyAccount");
    		Thread.sleep(10000);
    		driver.findElement(By.id("txtuname")).sendKeys("sandeepganesuni12@gmail.com");
    		//Thread.sleep(10000);
    		driver.findElement(By.id("txtpwd")).sendKeys("sandeep");
    		//Thread.sleep(2000);
    		driver.findElement(By.id("btnsignin")).click();
    		Thread.sleep(6000);
    		System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSS");
    		driver.switchTo().defaultContent();
    		Thread.sleep(5000);
    		/*driver.findElement(By.id("location-dropdown")).click();
    		driver.findElement(By.id("location-dropdown")).click();
    		Thread.sleep(2000);
    		driver.findElement(By.id("lcf-location")).sendKeys(city);
    		Thread.sleep(2000);
    		driver.findElement(By.linkText(city)).click();*/
    		
    		driver.findElement(By.id("SearchInput")).sendKeys(cat);
    		Thread.sleep(2000);
    		driver.findElement(By.partialLinkText(catname)).click();
    		Thread.sleep(5000);
    		//click on Wedding
    		try{
    			driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/section/ul/li[1]/div[2]/div[1]/ul/li[1]/label/input")).click();
    			                            
    			                             
    		}catch(NoSuchElementException e){
    			
    			System.out.println("First Block is changed");
    		}	
    		try{
    			driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/section/ul/li[1]/div[2]/div[2]/ul/li[1]/label/input")).click();
    			                            
    			                            
    		}catch(NoSuchElementException e){
    			
    			System.out.println("First Block is changed");
    		}	
    		try{
    			driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/section/ul/li[1]/div[2]/div[3]/ul/li[1]/label/input")).click();
    		}catch(NoSuchElementException e){
    			
    			System.out.println("Second Block is changed");
    		}	
    		try{
    			driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/section/ul/li[1]/div[2]/div[4]/ul/li[1]/label/input")).click();
    		
    		}catch(NoSuchElementException e){
    			System.out.println("Third Block is changed");
    		}	
    		    		
    		try{
    			if(driver.findElement(By.xpath("//*[@id='localityDd']/div[1]/span")).isDisplayed()){
    			driver.findElement(By.xpath("//*[@id='localityDd']/div[1]/span")).click();
        		driver.findElement(By.xpath("//*[@id='localityDd']/div[2]/ul/li[1]/label/input")).click();
    			}else{
    				System.out.println("locality not available");
    			}
    		}catch(NoSuchElementException ie){
    			
    		}
    		try{
    		driver.findElement(By.linkText("Submit")).click();
    		}catch(NoSuchElementException ie){
    			
    		}
    		

    		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    		 try{
    	        driver.findElement(By.xpath("//*[@id='btnvdboard_thanku']")).click();
    		 }catch(NoSuchElementException ie){
     			
     		}
    		    		
    		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
   
    		//verifying  In progress to yes
    		 long startTime1=System.currentTimeMillis();
    		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		 
    		 for(int i=1;i<=2000;i++){                      
    	if(driver.findElement(By.xpath("//*[@id='divrightpart_pos_1']/ul/li[1]/button")).isDisplayed()){
    		
    		long finishTime1=System.currentTimeMillis();
			 long totalTime=(finishTime1-startTime1);
			 float Time=totalTime/1000;
			 Reporter.log("Job done displyed in"+ Time);
			 Reporter.log("Total time taken for lead distribution ::"+totalTime +" Secs");
			 break;		 
    			
    			 }else{
    				 if(i==1999){
    		    		long finishTime1=System.currentTimeMillis();
    		    		 long totalTime=(finishTime1-startTime1);
        				 Reporter.log("Taking more than 5 min to change inprogress status ::"+totalTime +" Secs");
    				 }else{
    					 System.out.println("Still inprogress  not chaged"+i);
    				 }
    			 }
    					  
    			 }  
   }
 
	@AfterSuite
	public void closeall()
	{
		try{
		driver.quit();
		}catch(Exception e){
			
		}
	}
	
}
