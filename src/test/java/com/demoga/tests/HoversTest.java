
package com.demoga.tests;

import com.qa.demoga.pages.interactions.HoversPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HoversTest extends BaseTest {

    @BeforeMethod
    public void openHoversPage() {
        driver.get("https://the-internet.herokuapp.com/hovers");
    }

    @Test
    public void testHoverOnFirstAvatar() {
        HoversPage hoversPage = new HoversPage(driver);
        hoversPage.hoverOnFirstAvatar();
        String text = hoversPage.getFirstAvatarText();
        assertEquals(text, "name: user1");
    }
}