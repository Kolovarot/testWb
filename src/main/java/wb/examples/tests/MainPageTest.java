package wb.examples.tests;

import org.junit.jupiter.api.Test;
import wb.examples.pages.MainPage;

public class MainPageTest {
    @Test
    public void testVerifyMainPage() {
        MainPage mainPage = MainPage.openPage();
        mainPage.verifyPage();
    }

    //fixme тут тест не доделан, просто открывается главная страница и больше никаких действий.
    @Test
    public void testBigBannerMainPage() {
        MainPage mainPage = MainPage.openPage();
        mainPage.waitFoPageLoad();
        //Допишу, что нибудь будет делать
    }
}
