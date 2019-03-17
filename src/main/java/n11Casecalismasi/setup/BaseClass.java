package n11Casecalismasi.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
			
	public WebDriver driver;
	
	@BeforeTest
	public void baslat() {
		//ChromeDriver path'i kendi cihazýma göre ayarladým. Çalýþtýrýlacak cihazlarda driverýn olduðu path'e göre deðiþtirilmeli.
		System.setProperty("webdriver.chrome.driver","C:\\Users\\uik12\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void kapat(){ 
	    //Close driver
		driver.quit();
	}
}
