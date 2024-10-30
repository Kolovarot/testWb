package wb.examples.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends AbstractWbPage{
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);
    private final SelenideElement inputFieldNumber = $x("//input[@class=\"input-item\"]").as("Поле ввода номера");
    private final SelenideElement inputFieldCode = $x("//div[@class=\"login__code form-block\"]//input[2]").as("Поле ввода кода");
    private final SelenideElement getCodeButton = $x("//button[@id=\"requestCode\"]").as("Кнопка \"Получить код\"");

    public LoginPage() {
        super("Страница авторизации");
    }

    public static LoginPage openPage(){
        Selenide.open("https://www.wildberries.ru/security/login?returnUrl=https%3A%2F%2Fwww.wildberries.ru%2F");
        LOGGER.info("Открыть страницу авторизации");
        LoginPage loginPage = new LoginPage();
        loginPage.waitFoPageLoad();
        return loginPage;
    }


    public void inputNumber(String numberPhone){
        LOGGER.info("Ввесит номер телефона: " + numberPhone);
        if (numberPhone==null || numberPhone.isEmpty()){
            throw new IllegalArgumentException("Проверяемый телефон должен быть указан");
        }
        inputFieldNumber.click();
        inputFieldNumber.val(numberPhone);
    }
    public void clickCodeButton(){
        LOGGER.info("Кликнуть на '" + getCodeButton.getAlias() + "'");
        getCodeButton.click();
    }
    public void inputCode(String code){
        LOGGER.info("Ввесит код: " + code);
        inputFieldCode.click();
        inputFieldCode.val(code);
    }

    @Override
    public void waitFoPageLoad() {
        inputFieldNumber.shouldBe(visible);
    }

    @Override
    public void verifyPage() {

    }

}
