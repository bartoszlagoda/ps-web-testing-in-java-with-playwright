package com.playwright.UnderstandingPlaywrightCoreInterfaces;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayWrightBrowserWithContextTests {

    String home = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";

    @Test
    public void firstPlayWrightTestWithTheContext(){
        try(Playwright playwright = Playwright.create()){
            BrowserType browserType = playwright.chromium();

            BrowserContext context = browserType.launch().newContext();
            Page page = context.newPage();
            page.navigate(home);

            Assertions.assertEquals(page.title(),"Home Page");
        }
    }

    @Test
    public void secondPlayWrightTestWithTheContext(){
        try(Playwright playwright = Playwright.create()){
            BrowserType browserType = playwright.chromium();

            BrowserContext context = browserType.launch().newContext();
            Page page = context.newPage();
            page.navigate(home);
            String content = page.content(); // pobieranie pełnej zawartości HTML jako ciąg
            Assertions.assertTrue(content.contains("Cat In The Bag"));
        }
    }

    @Test
    public void thirdPlayWrightTestWithTheContext(){

        Playwright playwright = Playwright.create();
        BrowserType browserType = playwright.chromium();

        BrowserContext context = browserType.launch().newContext();
        Page page = context.newPage();
        page.navigate(home);
        String content = page.content(); // pobieranie pełnej zawartości HTML jako ciąg
        Assertions.assertTrue(content.contains("Cat In The Bag"));

        playwright.close();
    }
}
