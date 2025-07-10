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
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        alertsPage = new JavaScriptAlertsPage(driver);
    }
    @Test
    public void testJSAlerts(){
        alertsPage.triggerJSAlert();


    }

    @Test
    public  void testJSConfirmAlert(){
        alertsPage.triggerJSConfirm(true);


    }
    @Test
    public void testJSConfirmDismiss(){
        alertsPage.triggerJSConfirm(false);

    }
    @Test
    public void testJSPromptAccept(){
        String input = "Hello!";
        alertsPage.triggerJSPrompt(input,true);


    }

    @Test
    public void testJSPromptDismiss(){
        alertsPage.triggerJSPrompt("Ignored",false);

    }
    @AfterMethod
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
}
