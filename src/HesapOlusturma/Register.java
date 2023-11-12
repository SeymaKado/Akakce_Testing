package HesapOlusturma;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Register extends BaseDriver {
    @Test
    public void HOK_T01(){
        driver.get("https://www.akakce.com/akakcem/giris/?m=1&s=1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='rnufn']")));
        WebElement name = driver.findElement(By.xpath("//input[@id='rnufn']"));
        name.sendKeys("Falanca");
        MyFunc.Wait(1);
        WebElement email1 = driver.findElement(By.xpath("//input[@id='rnufe1']"));
        email1.sendKeys("falancafilan123@gmail.com");
        MyFunc.Wait(1);
        WebElement email2 = driver.findElement(By.xpath("//input[@id='rnufe2']"));
        email2.sendKeys("falancafilan123@gmail.com");
        MyFunc.Wait(1);
        String email1Value = email1.getAttribute("value");
        String email2Value = email2.getAttribute("value");
        assert email1Value.equals(email2Value) : "E-posta Adresleri  Esit Degil.";
        System.out.println("E-posta Adresleri Esit.");
        MyFunc.Wait(1);
        WebElement password1 = driver.findElement(By.xpath("//input[@id='rnufp1']"));
        password1.sendKeys("Deneme.123");
        MyFunc.Wait(1);
        WebElement password2 = driver.findElement(By.xpath("//input[@id='rnufp2']"));
        password2.sendKeys("Deneme.123");
        MyFunc.Wait(1);
        String password1Value = password1.getAttribute("value");
        String password2Value = password2.getAttribute("value");
        assert password1Value.equals(password2Value) : "Sifreler Esit Degil";
        assert password1Value.length() >= 8 : "Sifre En Az 8 Karakterden Olusmali";
        assert password2Value.length() >= 8 : "Sifre En Az 8 Karakterden Olusmali";
        assert password1Value.matches(".*[A-Z].*") : "Sifre Buyuk Harf Icermelidir";
        assert password1Value.matches(".*[a-z].*") : "Sifre Kucuk Harf Icermelidir";
        assert password1Value.matches(".*\\d.*") : "Sifre Rakam Icermelidir";
        System.out.println("Sifreler Uygun Ve Birbirine Esit");
        MyFunc.Wait(1);
        WebElement radio=driver.findElement(By.xpath("//input[@id='rngf']"));
        radio.click();
        MyFunc.Wait(1);
        WebElement city=driver.findElement(By.xpath("//select[@id='locpr']"));
        Select chooseCity=new Select(city);
        chooseCity.selectByVisibleText("Ankara");
        MyFunc.Wait(1);
        WebElement district=driver.findElement(By.xpath("//select[@id='locds']"));
        Select chooseDistrict=new Select(district);
        chooseDistrict.selectByVisibleText("Akyurt");
        MyFunc.Wait(1);
        WebElement day= driver.findElement(By.xpath("//select[@id='bd']"));
        Select chooseDay=new Select(day);
        chooseDay.selectByValue("4");
        MyFunc.Wait(1);
        WebElement month=driver.findElement(By.xpath("//select[@id='bm']"));
        Select chooseMonth=new Select(month);
        chooseMonth.selectByValue("4");
        MyFunc.Wait(1);
        WebElement year= driver.findElement(By.xpath("//select[@id='by']"));
        Select chooseYear=new Select(year);
        chooseYear.selectByValue("1994");
        MyFunc.Wait(1);
        WebElement protokolAccept= driver.findElement(By.xpath("//input[@id='rnufpca']"));
        protokolAccept.click();
        MyFunc.Wait(1);
        WebElement campaignAccept= driver.findElement(By.xpath("//input[@id='rnufnee']"));
        campaignAccept.click();
        MyFunc.Wait(2);
        WebElement register= driver.findElement(By.xpath("//input[@id='rfb']"));
        register.click();
        MyFunc.Wait(1);

        BekleVeKapat();
    }
}
