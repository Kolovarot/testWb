package wb.examples.tests;

import org.junit.jupiter.api.Test;
import wb.examples.pages.LoginPage;
import wb.examples.pages.MainPage;

public class TestLoginPage {
    //private final static String LOGIN_URL = "https://www.wildberries.ru/security/login?returnUrl=https%3A%2F%2Fwww.wildberries.ru%2F";
    private final static String PHONE_NUMBER = "72402202053";
    private final static String CODE = "605910";

    @Test
    public void authorization(){
        LoginPage loginPage = LoginPage.openPage();
        loginPage.inputNumber(PHONE_NUMBER);
        loginPage.clickCodeButton();
        loginPage.inputCode(CODE);
        MainPage mainPage = new MainPage();
        mainPage.waitFoPageLoad();
        mainPage.verifyAuthUser();
    }
}
