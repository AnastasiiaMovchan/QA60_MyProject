package com.qa.demoga.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;

public class ContextMenuPage {
    private WebDriver driver;
    private By hotspot = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
    }

    public String rightClickAndGetAlertText() {
        WebElement box = driver.findElement(hotspot);
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();

        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
}