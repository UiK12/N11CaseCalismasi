package n11Casecalismasi.Testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import n11Casecalismasi.objectrepository.N11Anasayfa;
import n11Casecalismasi.objectrepository.N11AramaSonucSayfasi;
import n11Casecalismasi.objectrepository.N11IsteklerimSayfasi;
import n11Casecalismasi.objectrepository.N11KullaniciGirisSayfasi;
import n11Casecalismasi.setup.BaseClass;

public class TC001 extends BaseClass{
	
	//N11 sayfasýna giriþ yapýlýr ve anasayfaya giriþ yapýldýðý onaylanýr.
	@Test(priority=1)
	public void step1() {
		
		driver.get("https://www.n11.com");
		WebDriverWait wait = new WebDriverWait(driver,100);
		
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
        N11Anasayfa anasayfa = PageFactory.initElements(driver, N11Anasayfa.class);
        String baslik = driver.getTitle();
		wait.until(ExpectedConditions.visibilityOf(anasayfa.girisYap));
		
		anasayfa.anaSayfaDogrula(baslik,"n11.com - Alýþveriþin Uðurlu Adresi");
	}
	
	//Kullanýcý adý ve þifre ile giriþ yapýlýr.(kullaýcý adý ve þifre alaný hesap güvenliði açýsýndan girilmemiþtir, bu alanlara deðiþtirildiði takdirde giriþ yapýlacaktýr.)
	@Test(priority=2)
	public void step2() throws InterruptedException {
		N11Anasayfa anasayfa = PageFactory.initElements(driver, N11Anasayfa.class);
		N11KullaniciGirisSayfasi girisyap = PageFactory.initElements(driver, N11KullaniciGirisSayfasi.class);
		anasayfa.girisYapTikla();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		girisyap.emailGiris("kullaniciAdi");
		Thread.sleep(1000);
		girisyap.sifreGiris("sifre");
		Thread.sleep(1000);
		girisyap.girisYap();
	}
	
	//Anasayfada arama alanýnda samsung ile arama yapýlýr ve sayfada aranan kelime için sonuç bulunduðu onaylanýr.
	@Test(priority=3)
	public void step3() throws InterruptedException {
		N11Anasayfa anasayfa = PageFactory.initElements(driver, N11Anasayfa.class);
		N11AramaSonucSayfasi sonucSayfasi = PageFactory.initElements(driver, N11AramaSonucSayfasi.class);
		anasayfa.aramaYap("samsung");
		Thread.sleep(1000);
		
		sonucSayfasi.aramaOnayla(sonucSayfasi.sonucText, "Samsung");
	}
	
	//Arama sonuçlarýndan 2. sayfaya týklanýr ve açýlan sayfanýn 2. sayfa olduðu onaylanýr. Üstten 3. ürün favorilere eklenir ve favorilerim sayfasýna gidilir.
	@Test(priority=4)
	public void step4() throws InterruptedException{
		N11AramaSonucSayfasi sonucSayfasi = PageFactory.initElements(driver, N11AramaSonucSayfasi.class);
		Actions action = new Actions(driver);
		
		sonucSayfasi.sayfaKaydir(driver,sonucSayfasi.sayfa2Buton);
		sonucSayfasi.sayfaDegistir();
		
		String baslik = driver.getTitle();
		sonucSayfasi.aramaSayfaDogrula(baslik, sonucSayfasi.sayfa2Buton);
		
		sonucSayfasi.favorilereEkle(2);
		Thread.sleep(1000);
		
		sonucSayfasi.sayfaKaydir(driver,sonucSayfasi.hesabim);
		sonucSayfasi.isteklerimSayfasinaGit(action, sonucSayfasi.hesabim,sonucSayfasi.istekListeleri);
		
	}
	//favorilerim sayfasýna gidilir ve eklenen ürününün bir önceki sayfada eklenen ürün olduðu onaylanýr.Sonrasýnda ürün favorilerden kaldýrýlýr ve ürünün favorilerde olmadýðý onaylanýr.
	@Test(priority=5)
	public void step5() throws InterruptedException {
		N11AramaSonucSayfasi sonucSayfa = PageFactory.initElements(driver, N11AramaSonucSayfasi.class);
		N11IsteklerimSayfasi isteklerimSayfasi = PageFactory.initElements(driver, N11IsteklerimSayfasi.class);
		
		isteklerimSayfasi.favorilerimeGit(isteklerimSayfasi.favorilerim);
		isteklerimSayfasi.favoriUrunDogrula(sonucSayfa.urun.getText(), isteklerimSayfasi.favoriUrunAdi.getText());
		isteklerimSayfasi.favorilerdenKalir(isteklerimSayfasi.silButonu,isteklerimSayfasi.tamamButonu);

		isteklerimSayfasi.urunKaldirildiMi(driver,isteklerimSayfasi.favorilerim);
	}

}
