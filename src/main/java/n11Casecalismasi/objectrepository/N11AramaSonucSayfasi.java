package n11Casecalismasi.objectrepository;
import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import n11Casecalismasi.setup.BaseClass;

public class N11AramaSonucSayfasi extends BaseClass{
	
	@FindBy(xpath = "//div[@class = 'resultText ']/h1")
	public WebElement sonucText;
	
	@FindBy(xpath = "//a[text() = 2]")
	public WebElement sayfa2Buton;
	
	@FindBy(xpath = "//*[@class=\"columnContent adBg\"]/div[1]/a/h3")
	public WebElement urun;
	
	@FindBy(xpath = "//li/div/div/span[@title = 'Favorilere ekle']")
	public List<WebElement> favorilereEkle;
	
	@FindBy(xpath = "//a[contains(text(), 'Hesabým')]")
	public WebElement hesabim;
	
	@FindBy(xpath = "//a[@title = 'Ýstek Listem / Favorilerim']")
	public WebElement istekListeleri;
	
	public void aramaOnayla(WebElement element,String aranan) {
		Assert.assertEquals(element.getText(), aranan);
	}
	public void sayfaKaydir(WebDriver driver,WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
	}
	public void sayfaDegistir() {
		sayfa2Buton.click();			
	}
	
	
	public void aramaSayfaDogrula(String baslik, WebElement element) {
		//Assert.assertEquals((baslik),baslik.contains(sayfaSayisi));
		String sayfaSayisi = element.getText();
		Assert.assertTrue(baslik.contains(sayfaSayisi),"Verilen sayfa numarasi ile eslesme saglanamadi");
	}
	
	public void favorilereEkle(int sayi) throws InterruptedException {
		favorilereEkle.get(sayi).click();
	}
	
	public void isteklerimSayfasinaGit(Actions action, WebElement element,WebElement element1) {
		action.moveToElement(element).perform();
		element1.click();
	}
	
}
