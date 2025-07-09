package com.demoga.tests;

import com.qa.demoga.pages.JavaScriptAlertsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptAlertsTests {
    WebDriver driver;
    JavaScriptAlertsPage alertsPage;


    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        alertsPage = new JavaScriptAlertsPage(driver);
    }

    @Test
    public void testJSAlerts() {
        alertsPage.triggerJSAlert();
        Assert.assertEquals(alertsPage.getResultText(), "You successfully clicked an alert");


    }

    @Test
    public void testJSConfirmAlert() {
        alertsPage.triggerJSConfirm(true);
        Assert.assertEquals(alertsPage.getResultText(), "You clicked: Ok");


    }

    @Test
    public void testJSConfirmDismiss() {
        alertsPage.triggerJSConfirm(false);
        Assert.assertEquals(alertsPage.getResultText(), "You clicked: Cancel");

    }

    @Test
    public void testJSPromptAccept() {
        String input = "Hello!";
        alertsPage.triggerJSPrompt(input, true);
        Assert.assertEquals(alertsPage.getResultText(), "You entered: " + input);


    }

    @Test
    public void testJSPromptDismiss() {
        alertsPage.triggerJSPrompt("Ignored", false);
        Assert.assertEquals(alertsPage.getResultText(), "You entered: null");

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
