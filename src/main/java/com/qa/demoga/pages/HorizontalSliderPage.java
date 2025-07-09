package com.qa.demoga.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HorizontalSliderPage extends BasePage {

    @FindBy(css = "input[type='range']")
    private WebElement slider;

    @FindBy(id = "range")
    private WebElement value;

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
    }

    public void moveSliderTo(double targetValue) {
        double currentValue = Double.parseDouble(value.getText());

        // Если текущее значение уже нужное — ничего не делаем
        if (currentValue == targetValue) return;

        // Шаг слайдера на этой странице = 0.5
        double step = 0.5;

        // Решаем, в каком направлении двигаться
        Keys direction = (currentValue < targetValue) ? Keys.ARROW_RIGHT : Keys.ARROW_LEFT;

        // Считаем, сколько раз нужно нажать
        int numberOfSteps = (int) Math.round(Math.abs(targetValue - currentValue) / step);

        for (int i = 0; i < numberOfSteps; i++) {
            slider.sendKeys(direction);
        }
    }

    public String getSliderValue() {
        return value.getText();
    }
}