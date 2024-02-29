package com.playwright.LearningAdvancedActions;

import com.microsoft.playwright.Page;
import com.playwright.BaseTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScreenShotDemoTests extends BaseTest {

    @Test
    public void screenshotTest(){

        page.navigate(home);

        page.selectOption("select#contactReason","Bored");
        assertTrue(page.isVisible("#boredOption"));

        page.selectOption("select#contactReason","Question");

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/resources/screenshots/box.png")));

        assertFalse(page.isVisible("#boredOption"),
                "The blue box should've disappeared after selecting another option");
    }

    @AfterEach
    public void cleanUp(){
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/resources/screenshots/box.png")));
    }
}
