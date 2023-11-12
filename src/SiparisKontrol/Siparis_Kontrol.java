package SiparisKontrol;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Siparis_Kontrol extends BaseDriver {
    @Test
    public void SK_T01() {
        driver.get("https://www.akakce.com/");
        WebElement giris = driver.findElement(By.xpath("(//a[@rel='nofollow'][text()='Giriş Yap'])[1]"));
        giris.click();
        WebElement eposta = driver.findElement(By.id("life"));
        eposta.sendKeys("falanfilan@gmail.com");
        WebElement sifre = driver.findElement(By.id("lifp"));
        sifre.sendKeys("Deneme.123");
        WebElement girisYapButton = driver.findElement(By.id("lfb"));
        girisYapButton.click();

        WebElement element1 = driver.findElement(By.xpath("//a[@id='H_a_v8']"));
        Actions aksiyonlar = new Actions(driver);
        Action aksiyon = aksiyonlar.moveToElement(element1).build();
        aksiyon.perform();
        WebElement element2 = driver.findElement(By.xpath("//a[@rel='nofollow'][text()='Hesabım']"));
        element2.click();
        WebElement element3 = driver.findElement(By.xpath("//a[text()='Siparişlerim']"));
        element3.click();

        WebElement mesaj = driver.findElement(By.xpath("//div[text()='Kayıtlı siparişiniz bulunmuyor.']"));
        Assert.assertTrue("Sipariş listesi boş değil ya da mesaj görüntülenemedi", mesaj.isDisplayed());

    }
}
