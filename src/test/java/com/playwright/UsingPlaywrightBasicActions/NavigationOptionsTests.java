package com.playwright.UsingPlaywrightBasicActions;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import com.playwright.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NavigationOptionsTests extends BaseTest {

    @Test
    public void navigationOptions(){
        page.navigate(home, new Page.NavigateOptions()
                .setTimeout(0)
                .setWaitUntil(WaitUntilState.DOMCONTENTLOADED));

        Assertions.assertEquals(page.title(),"Home Page");
    }
}

// navigate("url", new Page.NavigateOptions()
//                              .setTimeout(millis) // 0 to disable
//                              .setWaitUntil(DOMCONTENTLOADED));
//                                            LOAD
//                                            NETWORKIDLE

// CYKL ŻYCIA NAWIGACJI:
// Nawigacja:
// - koniec gdy nagłówki odpowiedzi zostaną przeanalizowane,
// - historia sesji zostanie zaktualizowana,

// Ładowanie:
// - treść dokumentu jest załadowana przez sieć i przeanalizowana
// - Page.onDOMContentLoaded(handler) jako zdarzenie jest odpalone
// - strona załadowała skrypty i zasoby takie jak stylowanie i obrazki
// - Page.onLoad(handler) jest odpalone
// - strona odpaliła dynamicznie skrypty
// - networkidle odpalone dla bezczynności sieci ponad 500 ms

// page.goBack() + options
// page.reload() + options
// page.goForward() + options

