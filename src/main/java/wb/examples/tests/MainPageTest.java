package wb.examples.tests;

import org.junit.jupiter.api.Test;
import wb.examples.pages.MainPage;

//fixme еще забыл сказать, классы с тестами называют обычно *Test, т.е. переименуй остальные классы по примеру.
public class MainPageTest {
    @Test
    public void testVerifyMainPage(){
        MainPage mainPage = MainPage.openPage();
        mainPage.verifyPage();
        mainPage.getPageName();//fixme данная строка ничего не делает
    }

    //fixme тут тест не доделан, просто открывается главная страница и больше никаких действий.
    @Test
    public void testBigBannerMainPage(){
        MainPage mainPage = MainPage.openPage();

    }
}
