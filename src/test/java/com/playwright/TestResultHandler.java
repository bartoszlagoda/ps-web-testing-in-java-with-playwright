package com.playwright;

import com.microsoft.playwright.Page;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.lang.reflect.Field;
import java.nio.file.Paths;

public class TestResultHandler implements AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext extensionContext){
        // pobranie instancji testowej (obiektu testu) z kontekstu rozszerzenia
        Object testInstance = extensionContext.getRequiredTestInstance();
        // pobranie metody testowej, która była wykonywana, a następnie jej reprezentacja jako string
        String testRequiredTestMethod = extensionContext.getRequiredTestMethod().toString();
        // Znalezienie indeksu, od którego zaczyna się fraza "com."
        int indexOfCom = testRequiredTestMethod.indexOf("com.");
        // dostowanie pobranej metody testowej do pobrania potrzebnych informacji
        String partOfTestRequiredTestMethod = testRequiredTestMethod.substring(indexOfCom,testRequiredTestMethod.length()-2);
        // sprawdzenie, czy test zakończył się niepowodzeniem sprawdzający czy wyjątek podczas jego wykonania był obecny
        Boolean testFailed = extensionContext.getExecutionException().isPresent();

        if (testFailed) {
            Field resultField = null;
            try {
                // pobranie pola "page" z klasy testowej; w przypadku niepowodzenia zostanie wyświetlony stos wywołań
                resultField = testInstance.getClass().getDeclaredField("page");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            Page page = null;
            try {
                // pobranie wartości pola Page z instancji testowej, aby umożliwić zrobienie zrzutu ekranu strony
                page = (Page) resultField.get(testInstance);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("src/test/resources/screenshots/" + partOfTestRequiredTestMethod + "_failure.png")));
        }
    }
}
