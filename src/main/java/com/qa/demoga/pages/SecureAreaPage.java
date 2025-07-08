package com.qa.demoga.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecureAreaPage extends BasePage {

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "flash")
    private WebElement messageBanner;

    public String getMessage() {
        return messageBanner.getText();
    }
}