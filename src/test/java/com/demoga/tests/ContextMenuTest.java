package com.demoga.tests;

import com.qa.demoga.pages.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest {

    @Test
    public void testRightClickShowsAlert() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.open();

        String alertText = contextMenuPage.rightClickAndGetAlertText();

        Assert.assertEquals(alertText, "You selected a context menu");

        contextMenuPage.acceptAlert();
    }
}