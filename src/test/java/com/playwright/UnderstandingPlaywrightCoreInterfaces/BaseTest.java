package com.playwright.UnderstandingPlaywrightCoreInterfaces;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
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
    static void setUp(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch();
    }

    @BeforeEach
    void createContextAndPage(){
        context = browser.newContext();
        page = context.newPage();
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