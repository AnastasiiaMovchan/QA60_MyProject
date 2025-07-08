package com.demoga.tests;

import com.qa.demoga.pages.LoginPage;
import com.qa.demoga.pages.SecureAreaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {

    WebDriver driver;
    LoginPage loginPage;
    SecureAreaPage secureAreaPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        loginPage = new LoginPage(driver);
        secureAreaPage = new SecureAreaPage(driver);
    }

    @Test
    public void loginWithValidCredentials() {
        loginPage.login("tomsmith", "SuperSecretPassword!");
        Assert.assertTrue(
                secureAreaPage.getMessage().contains("You logged into a secure area!"),
                "Login failed or message not found."
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}