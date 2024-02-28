package com.playwright.UsingPlaywrightBasicActions;

import com.microsoft.playwright.Keyboard;
import com.playwright.BaseTest;
import org.junit.jupiter.api.Test;

public class PressOptionsTests extends BaseTest {

    @Test
    public void pressOptions(){

        page.navigate(home);
        page.fill("#exampleFromControlInput1","myEmail@inbox.con"); // typo
        Keyboard kb = page.keyboard();

        kb.press("Backspace");
        kb.press("m");

        page.focus("#contactReason");
        kb.press("ArrowDown");
        kb.press("ArrowDown");
    }
}
