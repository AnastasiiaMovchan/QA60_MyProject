package com.demoga.tests;

import appmanager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class FileUploadTest {
    private ApplicationManager app;
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        app=new ApplicationManager();
        app.init();
        driver=app.getDriver();
    }
    @Test
    public void testFileUpload() {
        driver.get("https://the-internet.herokuapp.com/upload");

        File file = new File("src/test/resources/testfile.txt");
        System.out.println("Путь: " + file.getAbsolutePath());
        System.out.println("Существует? " + file.exists());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement uploadElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("file-upload")));
        uploadElement.sendKeys(file.getAbsolutePath());

        driver.findElement(By.id("file-submit")).click();

        String result = driver.findElement(By.tagName("h3")).getText();
        assert result.contains("File Uploaded!");
    }
    @AfterMethod
    public void tearDown(){
        app.stop();
    }
}
