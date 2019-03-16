package n11Casecalismasi.objectrepository;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import n11Casecalismasi.setup.BaseClass;

public class N11IsteklerimSayfasi extends BaseClass{
	
	@FindBy(xpath = "//h4[contains(text(), 'Favorilerim')]")
	public WebElement favorilerim;
	
	@FindBy(xpath = "//h3[@class=\"productName bold\"]")
	public WebElement favoriUrunAdi;
	
	@FindBy(className = "deleteProFromFavorites")
	public WebElement silButonu;
	
	@FindBy(xpath = "//div[5]/div/div")
	public WebElement tamamButonu;
	
	public void favorilerimeGit(WebElement element) {
		element.click();
	}
	public void favoriUrunDogrula(String urunAdi, String favoriUrunAdi) {
		Assert.assertTrue(urunAdi.equalsIgnoreCase(favoriUrunAdi),"Favorilere eklenen urun ile eklenmek istenen urun ayni degil");
	}
	
	public void favorilerdenKalir(WebElement element,WebElement element1) throws InterruptedException {
		element.click();
		Thread.sleep(1000);
		element1.click();
		Thread.sleep(1000);
	}
	
	public void urunKaldirildiMi(WebDriver driver,WebElement element) {
		driver.navigate().back();
		Assert.assertTrue(element.getText().contains("0"),"Ürün hala favorilerde");
	}
}
