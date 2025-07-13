package com.demoga.tests;

import com.qa.demoga.pages.HorizontalSliderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTest extends BaseTest {

    @Test
    public void testSliderMovement() {
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        HorizontalSliderPage sliderPage = new HorizontalSliderPage(driver);
        sliderPage.moveSliderTo(3.5);

        String currentValue = sliderPage.getSliderValue();
        Assert.assertEquals(currentValue, "3.5", "Slider value should be 3.5");
    }
}