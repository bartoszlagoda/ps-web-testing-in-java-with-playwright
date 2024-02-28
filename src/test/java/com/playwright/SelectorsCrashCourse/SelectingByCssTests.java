package com.playwright.SelectorsCrashCourse;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

public class SelectingByCssTests {

    String home = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";

    @Test
    public void cssSelectorsTest(){
        try(Playwright playwright = Playwright.create()){
            Page page = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000)).newPage();
            page.navigate(home);

            // wyszuka pierwszy input
            page.fill("input","first input box that PW finds");
            // wyszuka poprzez CSS pierwszy element z taką klasą
            page.fill(".form-control","First box with this class");
            // wyszuka formularz z konkretnym atrybutem, ale również tylko ten pierwszy
            page.fill("form #exampleFormControlInput1","Combined");
            // wyszuka konkretnie drugi formularz
            page.fill(":nth-match(.form-control,2)","Hello there stranger");
        }
    }
}
