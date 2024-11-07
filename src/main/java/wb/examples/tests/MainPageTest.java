package wb.examples.tests;

import org.junit.jupiter.api.Test;
import wb.examples.pages.MainPage;

public class MainPageTest extends TestBase {
    @Test
    public void testVerifyMainPage() {
        MainPage mainPage = MainPage.openPage();
        mainPage.verifyPage();
    }

    //todo тут тест не доделан, просто открывается главная страница и больше никаких действий.
    @Test
    public void testBigBannerMainPage() {
        MainPage mainPage = MainPage.openPage();
        mainPage.waitFoPageLoad();
        //Допишу, что нибудь будет делать
    }

    //fixme добавь новый тест на поиск, с главной страницы сделать поиск по рандомному слову из захардкоженного списка со словами, и проверить что в каталоге есть товары и кнопка [Все фильтры].
    //если будет тупить ввод слова в поле поиска, добавь слип на 3-5 секунд после открытия главной страницы и до начала ввода слова в поиск.
}
