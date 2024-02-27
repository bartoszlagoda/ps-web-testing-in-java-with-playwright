package com.playwright;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.List;

public class BrowserSupportDemo {

    @Test
    public void browserSupport(){
        try(Playwright playwright = Playwright.create()){

            List<BrowserType> browserTypes = List.of(playwright.chromium(),playwright.firefox(),playwright.webkit());

            for(BrowserType type : browserTypes){
                Page page = type.launch().newPage();
                page.navigate("https://www.whatsmybrowser.org/");
                page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(type.name() + ".png")));
            }
        }
    }
}
