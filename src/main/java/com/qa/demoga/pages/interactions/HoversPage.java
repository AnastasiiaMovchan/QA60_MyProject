package com.qa.demoga.pages.interactions;

import com.qa.demoga.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HoversPage extends BasePage {

    public HoversPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//div[@class='figure'])[1]")
    WebElement firstAvatar;

    @FindBy(xpath = "(//div[@class='figcaption']/h5)[1]")
    WebElement firstAvatarText;

    public HoversPage hoverOnFirstAvatar() {
        new Actions(driver).moveToElement(firstAvatar).perform();
        return this;
    }

    public String getFirstAvatarText() {
        return firstAvatarText.getText();
    }
}