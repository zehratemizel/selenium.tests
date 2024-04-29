package org.etiya;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class homework1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver webDriver = new ChromeDriver();

        // navigate().to() : belirtilen URL'ye gitmek için kullanılır.
        webDriver.navigate().to("https://www.saucedemo.com/v1/");

        //get_title():Geçerli sayfanın başlığını alır.
        String title = webDriver.getTitle();
        System.out.println(title);

        // get_page_source(): Sayfanın kaynak kodunu alır.
        String text = webDriver.getPageSource();
        System.out.println(text);

        /*WebDriver.find_element(by, value):: Belirli bir CSS selektörüne, XPath'e veya
        diğer seçici türlerine göre bir HTML öğesini bulur.Ör: id,name,XPath,classname. */
        WebElement usernameInput = webDriver.findElement(By.id("user-name"));

        /*send_keys(*keys_to_send):Bir HTML öğesine tuş kombinasyonları veya metin gönderir.
         Örneğin, bir giriş kutusuna metin girmek için kullanılır. */
        usernameInput.sendKeys("standard_user");

        WebElement passwordInput = webDriver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginBtn = webDriver.findElement(By.id("login-button"));

        /*Click: Bir HTML öğesini tıklar.
        Örneğin, bir düğmeyi tıklamak veya bir bağlantıyı açmak için kullanılır.*/
        loginBtn.click();

        /*find_elements(by, value):Belirli bir CSS selektörüne, XPath'e veya diğer seçici
        türlerine göre tüm eşleşen HTML öğelerini bulur.Ör: id,name,linkTest,classname.*/
        webDriver.findElements(By.className("inventory_item"));

        /*visibilityOfElementLocated fonksiyonu, Java'da Selenium'un ExpectedConditions sınıfında
        bulunur ve bir HTML öğesinin görünür hale gelmesini beklemek için kullanılır.
        Bu fonksiyon, bir WebDriverWait nesnesiyle birlikte kullanılarak belirli bir süre
         boyunca belirli bir koşulun gerçekleşmesi beklenir.*/

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10)); // 10 saniye süreyle bekleyecek
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@id='inventory_container']/div/div[1]/div[3]/button")));
        element.click();

        //navigate().back():Tarayıcıda geri butonuna tıklar, önceki sayfaya gitmeyi sağlar.
        webDriver.navigate().back();

        //Quit:Tüm tarayıcı pencerelerini kapatır ve WebDriver oturumunu sonlandırır.
        webDriver.quit();
    }
}
