package _02_HesapDogrulama;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Hesap_Dogrulama_Kontrolu extends BaseDriver {
    @Test
    public void hesapDogrulamaKontrolu() {
        driver.get("https://www.akakce.com/");

        WebElement giris = driver.findElement(By.xpath("(//a[@rel='nofollow'][text()='Giriş Yap'])[1]"));
        giris.click();
        WebElement eposta = driver.findElement(By.id("life"));
        eposta.sendKeys("falanfilan@gmail.com");
        WebElement sifre = driver.findElement(By.id("lifp"));
        sifre.sendKeys("Deneme.123");
        WebElement girisYapButton = driver.findElement(By.id("lfb"));
        girisYapButton.click();

        WebElement logo = driver.findElement(By.id("H_a_v8"));

        new Actions(driver).moveToElement(logo).build().perform();

        WebElement hesabim = driver.findElement(By.xpath("//a[@rel='nofollow'][text()='Falan']")); // text 'Falan' olan kısma kullanıcı adı yazılmalı
        hesabim.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='rscl'][text()='tıklayın']")));

        WebElement dogrulamaClick = driver.findElement(By.xpath("//a[@id='rscl'][text()='tıklayın']"));
        dogrulamaClick.click();
        MyFunc.Wait(1);

        Assert.assertTrue("Doğrulama e-postası gönderilmedi!",driver.switchTo().alert().getText().contains("onay linki"));

        driver.switchTo().alert().accept();

    }
}
