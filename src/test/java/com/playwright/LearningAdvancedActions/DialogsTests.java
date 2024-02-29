package com.playwright.LearningAdvancedActions;

import com.microsoft.playwright.Page;
import com.playwright.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;

public class DialogsTests extends BaseTest {

    @Test
    public void alertWithOnDialogMethodTest(){
        page.navigate(home);
        page.fill("#donation","50");

        page.onDialog(dialog -> {
            try {
                sleep(2000); // chcemy zobaczyć wykonanie
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            dialog.accept(); // jest to wystarczające dla poprawnego wykonania kodu
        });

        page.click("#submit-donation");
        Assertions.assertTrue(page.isVisible("text=Thank you!",new Page.IsVisibleOptions().setStrict(true)));
    }

    @Test
    public void alertTest(){
        page.navigate(home);
        page.fill("#donation","50");

        // dla alertów metoda onDialog jest domyślna i nie trzeba jej wywoływać

        page.click("#submit-donation");
        Assertions.assertTrue(page.isVisible("text=Thank you!",new Page.IsVisibleOptions().setStrict(true)));
    }

    @Test
    public void confirmTest(){
        page.navigate(home);
        page.fill("#donation","200");

        page.onDialog(dialog -> {
            try {
                sleep(2000); // chcemy zobaczyć wykonanie
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            dialog.accept(); // jest to wystarczające dla poprawnego wykonania kodu
        });

        page.click("#submit-donation");
        Assertions.assertTrue(page.isVisible("text=Thanks for confirming!",new Page.IsVisibleOptions().setStrict(true)), "Actual: " + page.locator("#donation-confirmation").textContent());
    }

    @Test
    public void promptTest(){
        page.navigate(home);
        page.fill("#donation","2000");

        page.onDialog(dialog -> {
            try {
                sleep(2000); // chcemy zobaczyć wykonanie
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            dialog.accept("Yes"); // jest to wystarczające dla poprawnego wykonania kodu
        });

        page.click("#submit-donation");
        Assertions.assertTrue(page.isVisible("text=Thank you for your generosity",new Page.IsVisibleOptions().setStrict(true)),page.locator("#donation-confirmation").textContent());
    }

    @Test
    public void promptWithOnceDialogMethodTest(){
        page.navigate(home);
        page.fill("#donation","2000");

        page.onceDialog(dialog -> {
            try {
                sleep(2000); // chcemy zobaczyć wykonanie
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            dialog.accept("Yes"); // jest to wystarczające dla poprawnego wykonania kodu
        });

        page.click("#submit-donation");
        Assertions.assertTrue(page.isVisible("text=Thank you for your generosity",new Page.IsVisibleOptions().setStrict(true)),page.locator("#donation-confirmation").textContent());
    }

    // Alert - wymaga tylko akceptacji
    // Confirm - OK / Cancel
    // Prompt - Input użytkownika + OK / Cancel
}
