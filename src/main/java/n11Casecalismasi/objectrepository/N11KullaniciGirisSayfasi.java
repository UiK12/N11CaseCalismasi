package n11Casecalismasi.objectrepository;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import n11Casecalismasi.setup.BaseClass;

@SuppressWarnings("annotationdeneme")
public class N11KullaniciGirisSayfasi extends BaseClass{
	
	@FindBy(name = "email")
	public WebElement emailTextBox;
	
	@FindBy(name = "password")
	public WebElement passwordTextBox;
	
	@FindBy(xpath = "//div[text()='Giriþ Yap']")
	public WebElement girisYapButon;
	
	public void emailGiris(String email) {
		emailTextBox.sendKeys(email);
	}
	
	public void sifreGiris(String sifre) {
		passwordTextBox.sendKeys(sifre);
	}
	
	public void girisYap() {
		girisYapButon.click();
	}
}
