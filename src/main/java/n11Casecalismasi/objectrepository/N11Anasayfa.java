package n11Casecalismasi.objectrepository;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import n11Casecalismasi.setup.BaseClass;


@SuppressWarnings("annotationdeneme")
public class N11Anasayfa extends BaseClass{
	
	@FindBy(className = "btnSignIn")
	public WebElement girisYap;
	
	@FindBy(id = "searchData")
	public WebElement araTextBox;
	
	public void anaSayfaDogrula(String baslik,String beklenenMesaj) {
		Assert.assertEquals((baslik),beklenenMesaj);
	}
	
	public void girisYapTikla() {
		girisYap.click();
	}
	
	public void aramaYap(String aramaKriteri) {
		araTextBox.sendKeys(aramaKriteri);
		araTextBox.sendKeys(Keys.ENTER);
	}
}
