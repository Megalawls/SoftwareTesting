package extent.reporting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PHPTravelPOM {
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[2]/ul/li[2]/a")
	WebElement myAccountBTN;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[2]/ul/li[2]/ul/li[2]/a")
	WebElement logOutBTN;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[2]/ul/li[2]/ul/li[1]/a")
	WebElement logInBTN;
	
	@FindBy(name="username")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement passWord;
	
	@FindBy(xpath="//*[@id=\"loginfrm\"]/div[4]/button")
	WebElement submitBTN;
	
	public void logOut(){
		try {Thread.sleep(2000);} catch (InterruptedException eexx) {eexx.printStackTrace();}
		myAccountBTN.click();
		logOutBTN.click();
	}
	
	public void logIn(){
		try{
		Thread.sleep(2000);
		myAccountBTN.click();
		Thread.sleep(2000);
		logInBTN.click();
		Thread.sleep(2000);}
		catch(Exception eee){
		System.out.println(eee);
		}finally{
		try {Thread.sleep(2000);} catch (InterruptedException eexx1) {eexx1.printStackTrace();}
		userName.sendKeys("user@phptravels.com");
		try {Thread.sleep(2000);} catch (InterruptedException eexx1) {eexx1.printStackTrace();}
		passWord.sendKeys("demouser");
		submitBTN.click();
		try {Thread.sleep(2000);} catch (InterruptedException eeee) {eeee.printStackTrace();}
		}
	}

	public PHPTravelPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}