package com.qa.demoga.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public  DropdownPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
    public void selectOptionByValue(String value){
        Select select = new Select(driver.findElement(dropdown));
        select.selectByValue(value);
    }
    public String
    getSelectedOptionText(){
        Select select = new Select(driver.findElement(dropdown));
        return
                select.getFirstSelectedOption().getText();
    }
}
