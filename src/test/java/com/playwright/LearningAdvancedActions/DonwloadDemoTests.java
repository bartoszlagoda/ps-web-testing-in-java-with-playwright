package com.playwright.LearningAdvancedActions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Download;
import com.playwright.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DonwloadDemoTests extends BaseTest {

    @BeforeEach
    @Override
    protected void createContextAndPage(){
        context = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true)); // inaczej nie pobiorą się żadne pliki
//        context = browser.newContext();
        page = context.newPage();
//        page.setViewportSize(1920,1080); // ustawienie rozmiarów strony
    }

    @Test
    public void downloadTestWithHandler(){

        page.navigate(home);

        page.onDownload(download -> {
            System.out.println(download.path());
            download.saveAs(Paths.get(new File("C:\\Users\\blagoda\\Desktop\\PlaywrightDownloads\\downloaded.zip").toURI()));
        });

        page.click("text=Download ZIP");
    }

    @Test
    public void downloadTestWitWaitForEvent(){

        page.navigate(home);

        Download download = page.waitForDownload(() -> {
            page.click("text=Download ZIP");
        });

        Path path = download.path();
        System.out.println(path);
    }
}
