package wb.examples.util;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;
import com.codeborne.selenide.ex.UIAssertionError;
import org.openqa.selenium.WebDriverException;

public class Verify {
    public static void verifyElements(WebElementCondition condition, SelenideElement... elements){
        for (SelenideElement element : elements) {
            try {
                element.shouldBe(condition);
            } catch (WebDriverException | UIAssertionError e) {
                System.out.println("[ERROR] Element '" + element.getAlias() + "': " + e.getMessage());
            }
        }
    }
}
