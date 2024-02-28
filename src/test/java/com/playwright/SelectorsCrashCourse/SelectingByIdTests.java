package com.playwright.SelectorsCrashCourse;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class SelectingByIdTests {
    // Supported:
    // - id
    // - data-testid
    // data-test-id
    // data-test
    String home = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";

    @Test
    public void idSelectorsTest(){
        try(Playwright playwright = Playwright.create()){
            Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000)).newPage();
            page.navigate(home);

            // fill zastępuje wszystko to co zostało wcześniej wprowadzone
            page.fill("id=surnameInput","John");
            page.fill("data-test-id=surnameInput","Sarah");
        }
    }
}
