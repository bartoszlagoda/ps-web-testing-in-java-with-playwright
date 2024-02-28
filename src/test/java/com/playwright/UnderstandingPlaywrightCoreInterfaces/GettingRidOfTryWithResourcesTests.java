package com.playwright.UnderstandingPlaywrightCoreInterfaces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GettingRidOfTryWithResourcesTests extends BaseTest{

    @Test
    public void firstPlayWrightTestWithTheContext(){
        page.navigate(home);

        Assertions.assertEquals(page.title(),"Home Page");
    }

    @Test
    public void secondPlayWrightTestWithTheContext(){
        page.navigate(home);
        String content = page.content(); // pobieranie pełnej zawartości HTML jako ciąg

        Assertions.assertTrue(content.contains("Cat In The Bag"));
    }
}
