package MesajKutusuKontrol;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Mesaj_Kutusu_Kontrol extends BaseDriver {
    @Test
    public void MesajKutusuTest()
    {
        driver.get("https://www.akakce.com/");
        WebElement hesapGiris=driver.findElement(By.xpath("(//a[@rel='nofollow'][text()='Giriş Yap'])[1]"));
        hesapGiris.click();

        WebElement email=driver.findElement(By.id("life"));
        email.sendKeys("falanfilan@gmail.com");

        WebElement sifreGir=driver.findElement(By.id("lifp"));
        sifreGir.sendKeys("Deneme.123");

        WebElement girisYap=driver.findElement(By.id("lfb"));
        girisYap.click();

        WebElement logoustugel=driver.findElement(By.id("H_a_v8"));
        new Actions(driver)
                .moveToElement(logoustugel)
                .build()
                .perform();

        WebElement hesabimTikla=driver.findElement(By.xpath("//a[@rel='nofollow'][text()='Falan']"));
        hesabimTikla.click();

        WebElement mesajlarimTikla=driver.findElement(By.linkText("Mesajlarım"));
        mesajlarimTikla.click();

        WebElement mesajKutusumesaj=driver.findElement(By.xpath("[class='wbb_v8']"));
        Assert.assertTrue("listelenecek mesaj bulunamadı",mesajKutusumesaj.getText().contains("Görüntülendi"));

    }
}
