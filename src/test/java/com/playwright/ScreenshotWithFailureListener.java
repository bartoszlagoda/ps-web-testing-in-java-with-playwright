package com.playwright;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(TestResultHandler.class)
public class ScreenshotWithFailureListener extends BaseTest{
    protected Page page;

    @BeforeEach
    protected void createContextAndPage(){
//        context = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true)); // inaczej nie pobiorą się żadne pliki
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1920,1080); // ustawienie rozmiarów strony
    }

    @Test
    public void screenshotTest(){
        page.navigate(home);
        assertFalse(page.isVisible("#boredOption"));

        page.selectOption("select#contactReason","Bored");
        assertTrue(page.isVisible("#boredOption"));

        page.selectOption("select#contactReason","Question");

        // this will fail - it's expected
        assertFalse(page.isVisible("#boredOption"),
                "The blue box should've disappeared after selecting another option");
    }
}