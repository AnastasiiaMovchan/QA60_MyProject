package com.demoga.tests;

import com.qa.demoga.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {

    @Test
    public void testDropdownOptionSelection() {
        DropdownPage dropdownPage = new DropdownPage(driver);
        dropdownPage.open();

        dropdownPage.selectOptionByValue("2");
        String selectedText=dropdownPage.getSelectedOptionText();
        Assert.assertEquals(selectedText,"Option 2");
    }
}
