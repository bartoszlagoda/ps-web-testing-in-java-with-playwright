package com.playwright.UsingPlaywrightBasicActions;

import com.playwright.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectOptionsTests extends BaseTest {

    @Test
    public void selectScenarioTest(){

        page.navigate(home);
        page.selectOption("id=contactReason","I'm just bored"); // wybranie selecta poprzez jego tekst

        Assertions.assertTrue(page.isVisible("text=OK, but please make it interesting"));
    }
}
