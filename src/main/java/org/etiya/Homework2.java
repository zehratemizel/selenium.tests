package org.etiya;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.junit.Assert.assertEquals;
public class Homework2 {

    WebDriver webDriver;
    @BeforeEach
    public void start()
    {
        webDriver = new ChromeDriver();
        webDriver.navigate().to("https://www.saucedemo.com/v1/");
        webDriver.manage().window().maximize();
    }
    @AfterEach
    public void end()
    {
        webDriver.quit();
    }

    @Test
    public void titleTest()
    {
        String expectedResult = "Swag Labs";
        String title = webDriver.getTitle();
        assertEquals(expectedResult, title);
    }

    @Test
    public void pageSourceTest()
    {
        String text = webDriver.getPageSource();
        System.out.println(text);
    }


    @Test
    public void emptyPasswordTest()
    {

        WebElement usernameInput = webDriver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");

        WebElement passwordInput = webDriver.findElement(By.id("password"));
        passwordInput.sendKeys("");

        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement errorMessage1 =webDriver.findElement(By.xpath("//*[@id='login_button_container']/div/form/h3"));
        System.out.println(errorMessage1);
        String expectedResult1 = "Epic sadface: Password is required";
        assertEquals(expectedResult1,errorMessage1.getText());


    }

    @Test
    public void itemCountTest() {

        WebElement usernameInput = webDriver.findElement(By.id("user-name"));
        usernameInput.sendKeys("standard_user");

        WebElement passwordInput = webDriver.findElement(By.id("password"));
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();
        int productCount = webDriver.findElements(By.className("inventory_item")).size();
        int expectedResult = 6;
        assertEquals(expectedResult,productCount);

    }

    @Test
    public void emptyLoginTest() {
        webDriver.findElement(By.id("login-button")).click();
        WebElement errorMessage2 =webDriver.findElement(By.xpath("//*[@id='login_button_container']/div/form/h3"));
        String expectedResult2 = "Epic sadface: Username is required";
        assertEquals(expectedResult2,errorMessage2.getText());
    }

    @Test
    public void invalidLoginTest()
    {

        WebElement usernameInput = webDriver.findElement(By.id("user-name"));
        usernameInput.sendKeys("stan");

        WebElement passwordInput = webDriver.findElement(By.id("password"));
        passwordInput.sendKeys("sauce");

        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement errorMessage3 =webDriver.findElement(By.xpath("//*[@id='login_button_container']/div/form/h3"));
        String expectedResult3 = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(expectedResult3,errorMessage3.getText());

    }


}
