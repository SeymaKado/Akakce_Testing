package HesapSilme;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Hesap_Silme extends BaseDriver {
    @Test
    public void hesapsilmeTest()
    {
        driver.get("https://www.akakce.com/");

        WebElement giris = driver.findElement(By.xpath("(//a[@rel='nofollow'][text()='Giriş Yap'])[1]"));
        giris.click();
        WebElement eposta = driver.findElement(By.id("life"));
        eposta.sendKeys("falanfilan1@gmail.com");
        WebElement sifre = driver.findElement(By.id("lifp"));
        sifre.sendKeys("Deneme.123");
        WebElement girisYapButton = driver.findElement(By.id("lfb"));
        girisYapButton.click();

        WebElement logo = driver.findElement(By.id("H_a_v8"));

        new Actions(driver).moveToElement(logo).build().perform();

        WebElement hesabim = driver.findElement(By.xpath("//a[@rel='nofollow'][text()='Falan']")); // text 'Falan' olan kısma kullanıcı adı yazılmalı
        hesabim.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Hesabımı Sil']")));

        WebElement hesapSilClick = driver.findElement(By.xpath("//a[text()='Hesabımı Sil']"));
        hesapSilClick.click();
        MyFunc.Wait(1);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='p']")));

        WebElement sifreBox=driver.findElement(By.cssSelector("input[id='p']"));
        sifreBox.sendKeys("Deneme.123");

        WebElement hesapSilButon=driver.findElement(By.cssSelector("input[id='u']"));
        hesapSilButon.click();
        WebElement mesaj=driver.findElement(By.xpath("//*[text()='Hesabın Silindi']"));
        Assert.assertTrue("Hesap Silme İşlemi Başarısız !",mesaj.getText().contains("Silindi"));


    }
}
