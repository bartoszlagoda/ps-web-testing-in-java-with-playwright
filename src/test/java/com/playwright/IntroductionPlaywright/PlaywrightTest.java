package com.playwright.IntroductionPlaywright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlaywrightTest {

    @Test
    public void firstTest(){
        // przejście na stronę i kliknięcie w obiekt
        // playwright -> browserType -> browser -> page.click

        try(Playwright playwright = Playwright.create()){
            BrowserType browserType = playwright.chromium();
            Browser browser = browserType.launch(); // załączanie przeglądarki
            Page page = browser.newPage(); // otwarcie nowej strony
            page.navigate("https://playwright.dev");
            System.out.println(page.title());
        } // to daje nam pewność, że przeglądarka i strony zostaną zamknięte na końcu
    }

    @Test
    public void firstPlaywrightScriptRefactored(){
        try(Playwright playwright = Playwright.create()){
            Page page = playwright.chromium().launch().newPage();
            page.navigate("https://playwright.dev");

            Assertions.assertEquals("Playwright",page.title());
        }
    }
}
