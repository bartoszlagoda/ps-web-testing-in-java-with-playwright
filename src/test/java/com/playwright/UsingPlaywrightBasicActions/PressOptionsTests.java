package com.playwright.UsingPlaywrightBasicActions;

import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.playwright.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PressOptionsTests extends BaseTest {

    @Test
    public void pressOptions(){

        page.navigate(home);

        Assertions.assertTrue(page.isEditable("#exampleFormControlInput1",new Page.IsEditableOptions().setStrict(true)));

        page.fill("#exampleFormControlInput1","myEmail@inbox.con"); // typo
        Keyboard kb = page.keyboard(); // wywołanie metod klawiaturowych

        kb.press("Backspace"); // wciśnięcie przycisku usuwania
        kb.press("m"); // dopisanie litery 'm'

        page.focus("#contactReason"); // focusowanie na następny element (jak TAB)
        kb.press("ArrowDown"); // strzałka w dół
        kb.press("ArrowDown");

        Assertions.assertTrue(page.isVisible("text=OK, but please make it interesting",new Page.IsVisibleOptions().setStrict(true)));

        // dostępne asercje:
        // .isVisible("locator", new Page.IsVisibleOptions().setStrict(true));
        // .isChecked("locator", new Page.IsCheckedOptions().setStrict(true));
        // .isDisabled("locator", new Page.IsDisabledOptions().setStrict(true));
        // .isEnabled("locator", new Page.IsEnabledOptions().setStrict(true));
        // .isHidden("locator", new Page.IsHiddenOptions().setStrict(true));
        // .isEditable("locator", new Page.IsEditableOptions().setStrict(true));
        // setStrict() wymusza niejako uruchomienie jednego konkretnego lokatora
    }

    @Test
    public void locatorExample(){

        page.navigate(home);
        Locator input = page.locator(".form-control"); // tworzenie lokatora jako zmienna

        System.out.println(input.count());

        // wypełnij pierwszy znaleziony lokator input
        input.first().fill("first");
        // wypełnij ostatni znaleziony lokator input
        input.last().fill("last");
        // wypełnij drugi element input z listy znalezionych elementów
        input.nth(1).fill("second");
    }
}
