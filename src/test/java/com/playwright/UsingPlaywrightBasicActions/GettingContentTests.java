package com.playwright.UsingPlaywrightBasicActions;

import com.playwright.BaseTest;
import org.junit.jupiter.api.Test;

public class GettingContentTests extends BaseTest {

    @Test
    public void gettingElements(){
        page.navigate(home);

        System.out.println("======= Text content =======");
        System.out.println(page.textContent("#hero-banner"));

        System.out.println("======= Inner text =======");
        System.out.println(page.innerText("#hero-banner"));

        System.out.println("======= Inner HTML =======");
        System.out.println(page.innerHTML("#hero-banner"));

        System.out.println("======= Get Attribute =======");
        System.out.println(page.getAttribute("img","alt")); // bag
    }

    // innerHTML() - otrzymuje kod HTML elementu, a więc tagi i tekst
    // innerText() - otrzymuje tylko widoczny tekst zamieniając elementy podziału na znaki nowej linii
    // textContent() - zwraca cały tekst, który faktycznie znajduje się w kodzie HTML ignorując elementy podziału
    // getAttribute() - nie pobiera tekstu między znacznikami, a wartość atrybutu, który jest częścią znacznika
}
