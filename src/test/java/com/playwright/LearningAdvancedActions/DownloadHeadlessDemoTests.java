package com.playwright.LearningAdvancedActions;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Download;
import com.playwright.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;

public class DownloadHeadlessDemoTests extends BaseTest {

    @BeforeEach
    @Override
    protected void createContextAndPage(){
        browser = playwright.chromium().launch(); // headles by default
        context = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true)); // inaczej nie pobiorą się żadne pliki
        page = context.newPage();
    }

    @Test
    public void downloadHeadlessTest(){

        page.navigate(home);

        Download download = page.waitForDownload(
                () -> page.click("text=Download")
        );

        System.out.println(download.path());
        download.saveAs(Paths.get(new File("C:\\Users\\blagoda\\Desktop\\PlaywrightDownloads\\downloaded-headless.pdf").toURI()));
    }

}
