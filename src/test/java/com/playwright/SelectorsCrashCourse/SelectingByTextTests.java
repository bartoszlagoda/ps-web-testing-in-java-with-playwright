package com.playwright.SelectorsCrashCourse;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SelectingByTextTests {

    String home = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";

    @Test
    public void textSelectorsTest(){
        try(Playwright playwright = Playwright.create()){
            Page page = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions()
                            .setHeadless(false) // pokaz kroki wykonywanego testu
                            .setSlowMo(2000)).newPage(); // ustaw spowolnienie do wykonywanych kroków
            page.navigate(home);
            page.click("text=More Info");

            Assertions.assertEquals(page.title(),"Advantages");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "text=More Info",
            "text=more info",
            "'More Info'"
    })
    public void textSelectorsParametrizedTest(String stringSelector){
        try(Playwright playwright = Playwright.create()){
            Page page = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions()
                            .setHeadless(false) // pokaz kroki wykonywanego testu
                            .setSlowMo(2000)).newPage(); // ustaw spowolnienie do wykonywanych kroków
            page.navigate(home);
            page.click(stringSelector);

            Assertions.assertEquals(page.title(),"Advantages");
        } // domyślny timeout wynosi 30 sekund
    }
}
