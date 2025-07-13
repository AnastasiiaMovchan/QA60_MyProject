package com.qa.demoga.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JavaScriptAlertsPage extends BasePage{

    public JavaScriptAlertsPage(WebDriver driver){
        super(driver);
    }
    @FindBy (xpath = "//button[text()='Click for JS Alert']")
    private WebElement jsAlertButton;

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    private WebElement jsConfirmButton;

    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    private WebElement jsPromptButton;

    @FindBy(id="result")
    private WebElement resultText;

    public void  triggerJSConfirm(boolean accept){
        click(jsConfirmButton);
        Alert alert = driver.switchTo().alert();
        if (accept){
            alert.accept();
        }else {
            alert.dismiss();
        }
    }
    public void triggerJSPrompt(String inputText,boolean accept){
        click(jsPromptButton);
        Alert alert = driver.switchTo().alert();
        if (inputText!=null){
            alert.sendKeys(inputText);
        }if (accept){
            alert.accept();
        }else {
            alert.dismiss();
        }
    }
    public void triggerJSAlert(){
        click(jsAlertButton);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    public String getResultText(){

        return resultText.getText();
    }
}
