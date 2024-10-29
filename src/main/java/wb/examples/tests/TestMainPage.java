package wb.examples.tests;

import org.junit.jupiter.api.Test;
import wb.examples.pages.MainPage;

public class TestMainPage {
    @Test
    public void checkImportantElements(){
        MainPage mainPage = MainPage.openPage();
        mainPage.verifyPage();
        mainPage.getPageName();
    }

    @Test
    public void testBigBannerMainPage(){
        MainPage mainPage = MainPage.openPage();

    }
}
