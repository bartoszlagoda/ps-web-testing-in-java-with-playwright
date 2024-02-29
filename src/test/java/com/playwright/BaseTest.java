package com.playwright;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected String home = "file:///" + System.getProperty("user.dir") + "\\src\\web\\home.html";

    protected static Playwright playwright;
    protected static Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    protected static void setUp(){
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
    }

    @BeforeEach
    protected void createContextAndPage(){
//        context = browser.newContext(new Browser.NewContextOptions().setAcceptDownloads(true)); // inaczej nie pobiorą się żadne pliki
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1920,1080); // ustawienie rozmiarów strony
    }

    @AfterEach
    void closeContext(){
        context.close();
    }

    @AfterAll
    static void tearDown(){
//        browser.close();
        playwright.close();
    }
}

// page.close() -> zamyka tylko stronę
// context.close() -> zamyka konktekst i wszystkie przechodnie strony tego kontekstu
// browser.close() -> zamyka wszystkie powiązane konteksty i strony
// playwright.close() -> zamyka wszystko

// minimalne wymaganie to context.close() przy każdym teście, co zamknie również strony i wywoła
// zamknięcie playwrighta pod koniec wszystkich testów