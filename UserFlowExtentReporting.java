package extent.reporting;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.util.Random;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserFlowExtentReporting {
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	Random rand = new Random();
	int randomNumber = rand.nextInt((999999 - 1) + 1);
	
	@BeforeClass()
	public void initialise(){
	//Create Report File Here
	report = new ExtentReports( 
			"C:\\Users\\Administrator\\Desktop\\Automated Testing\\ExtentReporting\\testingReport.html", true
			);

	//Initialise and begin the test
	test = report.startTest("PHPTravel Testing"); 
	
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--start-maximized");
	driver = new ChromeDriver(options);
	
	//Add a note to the test and load page
	test.log(LogStatus.INFO, "Browser started");
	driver.get("http://www.phptravels.net/");
	}
	
	@AfterClass()
	public void terminateTesting(){
	//Close the Test
	report.endTest(test);
	report.flush();
		
		
	//Close the driver
	driver.quit();
	}
	
	@Test()
		public void testAccountInfo(){
		PHPTravelPOM pom = new PHPTravelPOM(driver);
		test.log(LogStatus.INFO, "Test 1: Changing Account Information -  Beginning...");

		//Logging in if account exists:
		pom.logIn();
 
		//Check that user is logged in and is on account info page - confirms that the Login is successful
		String title = driver.getCurrentUrl();
		if(title.equals(
				   	"http://www.phptravels.net/account/")){
			   test.log(LogStatus.PASS, "Login Successful, URL = " + title);} 
		else{
			   test.log(LogStatus.FAIL, "Login unsuccessful, URL = " + title);}
		 
		//Adding address to account
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/ul/li[2]/a/span")).click();
		try {Thread.sleep(2000);} catch (InterruptedException e2) {e2.printStackTrace();}
		driver.findElement(By.name("address1")).sendKeys("QA Academy, 5th Floor");
		driver.findElement(By.name("address2")).sendKeys("Anchorage 1");
		driver.findElement(By.name("city")).sendKeys("Manchester");
		driver.findElement(By.name("state")).sendKeys("Salford");
		driver.findElement(By.name("zip")).sendKeys("M50 3YJ");
		driver.findElement(By.xpath("//*[@id=\"profilefrm\"]/div/div[3]/div[2]/div[6]/div[2]/select")).click();
		driver.findElement(By.xpath("//*[@id=\"profilefrm\"]/div/div[3]/div[2]/div[6]/div[2]/select/option[212]")).click();
		driver.findElement(By.xpath("//*//*[@id=\"profilefrm\"]/div/div[3]/div[3]/button")).click();
		test.log(LogStatus.PASS, "Address Added");
		
		//Logging out
		pom.logOut();
	}
	
	@Test()
		public void createAccount(){
		PHPTravelPOM pom = new PHPTravelPOM(driver);
		test.log(LogStatus.INFO, "Test 2: Creating a User Account -  Beginning...");
		
		   //Creating user account 
		   driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/ul/li[2]/a")).click();
		   driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/ul/li[2]/ul/li[2]/a")).click();
		   driver.findElement(By.name("firstname")).sendKeys("First");
		   driver.findElement(By.name("lastname")).sendKeys("Last");
		   driver.findElement(By.name("phone")).sendKeys("0800 00 1066");
		   driver.findElement(By.name("email")).sendKeys(randomNumber + "anchorage@gmail.com");
		   driver.findElement(By.name("password")).sendKeys("password");
		   driver.findElement(By.name("confirmpassword")).sendKeys("password");
		   driver.findElement(By.xpath("//*[@id=\"headersignupform\"]/div[9]/button")).click();
		   test.log(LogStatus.PASS, "Account Created");

		   //Logging out
		   pom.logOut();

	}
	
	@Test()
		public void complainAboutThisWebsiteBeingAbsoluteGarbage(){
		PHPTravelPOM pom = new PHPTravelPOM(driver);
		test.log(LogStatus.INFO, "Test 3: Logging a Complaint -  Beginning...");
		
		   //Logging in if account exists:
		   pom.logIn();
		  
		   
			//Check that user is logged in and is on account info page - confirms that the Login is successful
			String title2 = driver.getCurrentUrl();
			if(title2.equals(
					   	"http://www.phptravels.net/account/")){
				   test.log(LogStatus.PASS, "Login Successful, URL = " + title2);} 
			else{
				   test.log(LogStatus.FAIL, "Login unsuccessful, URL = " + title2);}

		   //Contacting the company
		   try {Thread.sleep(2000);} catch (InterruptedException e0) {e0.printStackTrace();}
		   driver.findElement(By.xpath("/html/body/nav[1]/div/div/div/ul/li[8]/a")).click();
		   driver.findElement(By.name("contact_name")).sendKeys("Demo User");
		   driver.findElement(By.name("contact_email")).sendKeys("user@phptravels.com");
		   driver.findElement(By.name("contact_subject")).sendKeys("This website is horrible");
		   driver.findElement(By.name("contact_message")).sendKeys("pls fix this horrible experience");
		   driver.findElement(By.name("submit_contact")).click();

		   //Logging out
		   pom.logOut();
	}
	
	@Test()
		public void bookATour(){
		PHPTravelPOM pom = new PHPTravelPOM(driver);
		test.log(LogStatus.INFO, "Test 4: Booking a Tour - Beginning...");
		
		   //Logging in if account exists:
		   pom.logIn();
		   
			//Check that user is logged in and is on account info page - confirms that the Login is successful
			String title3 = driver.getCurrentUrl();
			if(title3.equals(
					   	"http://www.phptravels.net/account/")){
				   test.log(LogStatus.PASS, "Login Successful, URL = " + title3);} 
			else{
				   test.log(LogStatus.FAIL, "Login unsuccessful, URL = " + title3);}
		   
		   //Returning to the home page
		   try {Thread.sleep(2000);} catch (InterruptedException e0) {e0.printStackTrace();}
		   driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/a/img")).click();
		   
		   //Booking a tour - because the website is absolute garbage, I've made it throw an exception and just navigate if it can't click the button for the sake of getting this test working
		   try{
		   driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div[5]/a/div/div[1]/div/div/img[2]")).click();
		   test.log(LogStatus.PASS, "Button Loaded in time");}
		   catch(Exception e1){
		   test.log(LogStatus.FAIL, "Button Did Not Load In Time, Continuing rest of testing");
		   driver.navigate().to("http://www.phptravels.net/tours/egypt/alexandria/Spectaculars-Of-The-Nile-3-Nights");
		   test.log(LogStatus.PASS, "Previous Test Failed - Navigating to page to continue tests");

		   System.out.println(e1);
		   } 
		   try {Thread.sleep(5000);} catch (InterruptedException e1) {e1.printStackTrace();}

		   //Selects a Package
		   driver.findElement(By.xpath("//*[@id=\"OVERVIEW\"]/div/div[2]/div[2]/div[2]/div/form/div[4]/button")).click();
		   try {Thread.sleep(2000);} catch (InterruptedException e2) {e2.printStackTrace();}
		   
		   //Literally just types in gibberish into the additional notes box to confirm that it is on the correct page and that it has loaded correctly
		   try{
		   driver.findElement(By.name("additionalnotes")).sendKeys("I am allergic to anchovies, please phone when you are outside with my pizza. thxboss");
		   test.log(LogStatus.PASS, "Page Loaded, Additional Notes Entered");}
		   catch(NoSuchElementException nse){
			   test.log(LogStatus.FAIL, "Loading Failed");
		   }
		   
		   //Confirming the booking and waiting for the order to be processed
		   driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/div/div[2]/div[5]/button")).click();
		   try {Thread.sleep(10000);} catch (InterruptedException e3) {e3.printStackTrace();};

		   //Alert handling for confirmation box - 
		   driver.findElement(By.cssSelector(".arrivalpay")).click(); //Select to pay on arrival - will trigger an alert.
		   try {
		    Alert alert = driver.switchTo().alert();
		    System.out.println("Alert exists");
		    String alertext = alert.getText();
		    System.out.println(alertext);
		    alert.accept();
		    test.log(LogStatus.PASS, "Alert Confirmed - Order Completed");}
		   catch (NoAlertPresentException e) {System.out.println("No Alert On Page");}
		   
		   //Wait for order to be finalised
		   try {Thread.sleep(4000);} catch (InterruptedException e4) {e4.printStackTrace();}; 
		   
		   //Logging out
		   pom.logOut();
	}
}