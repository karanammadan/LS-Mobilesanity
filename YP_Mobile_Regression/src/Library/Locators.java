package Library;


public interface Locators {

	/*********************************Login Locators**************************************************/
	
	String loginButton                = 	"sul_logintxt"; //id
	String textUsername               = 	"txtEmail"; //id
	String textPassword               = 	"txtPass";  //id
	String SignInButton               = 	"//*[@id='frmLogin']/div/div[3]/a"; //Xpath
	String myaccount                  = 	"//*[@id='sul_myaccount']"; // Xpath
	String logout                     = 	"//*[@id='sul_logouttxt']"; //Xpath
	
/************************************ In Home Page LCF ***************************************************************/
	String Name 					  = 	"lcftxtname"; 
	String Mobilenumber 			  =		"lcftxtmobile"; 
	String Email 					  = 	"lcftxtemail"; 
	String YPName 					  = 	"Rahul";
	String YPEmail   				  = 	"karanammadan@rocketmail.com";
	/*String YPMobile 			      = 	"9380835000";
	String YPVerifyCode 		      =		"999999";
	*/
	String submit	   	   			  =  "(//button[@type='button'])[3]";
	
/************************************ LCF ***************************************************************/	
	String YPMobile     = 	"7299642002";
	String YPMob    	= 	"9380835000";
	String YPVerifyCode	=   "999999";
	
	/********** LCF **************/
	
	String submit1		=	 ".btn.next-step"; // css selecter
	String submit2		=	 "//div[4]/div[2]/div/div/div/div[3]/div[5]/button[2]"; // xpath
	String skip 		=	 ".btn-link.seclcfskip"; // css selecter
	
	String city 		=	 "//div[7]/div[2]/div/div/div/div[2]/div[1]/div/div[1]";
	String need			=	"//div[4]/div[2]/div/div/div/div[2]/div[2]/div/div[1]";
	String loc			=	"//div[4]/div[2]/div/div/div/div[3]/div[1]/div[1]/div/div[1]";
	
	String mail			=	"lcftxtemail"; // name
	String mob			=	"lcftxtmobile"; //name
	String username		=	"lcftxtname"; //name
	
}


