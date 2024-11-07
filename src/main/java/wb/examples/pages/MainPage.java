package wb.examples.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wb.examples.util.Verify;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage extends AbstractWbPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainPage.class);

    String namePage = "Главная страница сайта";
    private static final SelenideElement GEO = $x("//span[@data-wba-header-name=\"DLV_Adress\"]").as("ГЕО в шапке");
    private static final SelenideElement SALE_ON_WB = $x("//a[@data-wba-header-name=\"Seller\"]").as("Продавайте на Wildberries");
    private static final SelenideElement WORK_AT_WB = $x("//a[@data-wba-header-name=\"Job\"]").as("Работа на Wildberries");
    private static final SelenideElement LOGO = $x("//img[@alt=\"Wildberries\"]").as("Логотип ВБ в шапке");
    private static final SelenideElement MENU_BURGER = $x("//button[@data-wba-header-name=\"Catalog\"]").as("Бургер Меню");
    private static final SelenideElement SEARCH_FIELD = $x("//input[@data-wba-header-name=\"Search_text\"]").as("Поле поиска");
    private static final SelenideElement ADDRESS = $x("//a[@data-wba-header-name=\"Pick_up_points\"]").as("Адреса");
    private static final SelenideElement LOGIN = $x("//a[@data-wba-header-name=\"Login\"]").as("Войти");
    private static final SelenideElement BASKET = $x("//a[@data-wba-header-name=\"Cart\"]").as("Корзина");
    private static final SelenideElement CURRENCY = $x("//div[@class=\"simple-menu__item header__currency j-b-header-country\"]").as("Валюта");
    private static final SelenideElement BANNER = $x("//div[@data-analitics-code=\"MBB\"]").as("Баннер на главной");

    public MainPage() {
        super("Главная страница сайта");
    }

    public static MainPage openPage() {
        LOGGER.info("Открыть главную страницу сайта");

        Selenide.open("https://www.wildberries.ru/");
        MainPage mainPage = new MainPage();
        mainPage.waitFoPageLoad();
        return mainPage;
    }

    public void verifyPage() {
        LOGGER.info(getPageName() + ": проверка основных элементов страницы");
        Verify.verifyElements(visible, GEO, SALE_ON_WB, WORK_AT_WB, LOGO, MENU_BURGER, SEARCH_FIELD, ADDRESS, LOGIN, BASKET, CURRENCY);
    }

    @Override
    public void waitFoPageLoad() {
        BANNER.shouldBe(visible);
    }
}
