package com.playwright.UsingPlaywrightBasicActions;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;
import com.playwright.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClickFillOptionsTests extends BaseTest {

    @Test
    public void clickOptionsCountTest(){

        page.navigate(home);
        // dwukrotne kliknięcie
        page.click("#clap-image", new Page.ClickOptions().setClickCount(2));

        Assertions.assertTrue(page.isVisible("#thank-you-2"));
        // OR
        Assertions.assertTrue(page.isVisible("text=You can only clap once, but thanks for your enthusiasm."));
    }

    @Test
    public void dblClickOptionsCountTest(){

        page.navigate(home);
        // dwukrotne kliknięcie
        page.dblclick("#clap-image");

        Assertions.assertTrue(page.isVisible("#thank-you-2"));
        // OR
        Assertions.assertTrue(page.isVisible("text=You can only clap once, but thanks for your enthusiasm."));
    }

    @Test
    public void fillOptionsTest(){
        page.navigate(home);
        page.fill("id=exampleMessage","So I was thinking the other day...",
                new Page.FillOptions().setForce(true)); // omiń kontrolę widoczności
    }

    @Test
    public void fillContactUsFormTest(){
        page.navigate(home);
        page.fill("id=exampleFormControlInput1","test@email.com");
        page.fill("id=exampleMessage","Not sure how to say this...");

        page.check("id=sendCopy"); // check - metoda zaznaczenia
        page.click("id=submit-contact");

        Assertions.assertTrue(page.isVisible("text=We sent you a copy of your message : Not sure how to say this..."));

    }

    @Test
    public void fillContactUsFormWithUncheckSendCopyBtnTest(){
        page.navigate(home);
        page.fill("id=exampleFormControlInput1","test@email.com");
        page.fill("id=exampleMessage","Not sure how to say this...");

        page.check("id=sendCopy"); // check - metoda zaznaczenia
        page.uncheck("id=sendCopy"); // uncheck - metoda odznaczenia
        page.click("id=submit-contact");

        Assertions.assertFalse(page.isVisible("text=We sent you a copy of your message : Not sure how to say this..."));
    }
}
