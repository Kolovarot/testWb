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
    private static final SelenideElement geo = $x("//span[@data-wba-header-name=\"DLV_Adress\"]").as("ГЕО в шапке");
    private static final SelenideElement saleOnWb = $x("//a[@data-wba-header-name=\"Seller\"]").as("Продавайте на Wildberries");
    private static final SelenideElement workAtWb = $x("//a[@data-wba-header-name=\"Job\"]").as("Работа на Wildberries");
    private static final SelenideElement logo = $x("//img[@alt=\"Wildberries\"]").as("Логотип ВБ в шапке");
    private static final SelenideElement menuBurger = $x("//button[@data-wba-header-name=\"Catalog\"]").as("Бургер Меню");
    private static final SelenideElement searchField = $x("//input[@data-wba-header-name=\"Search_text\"]").as("Поле поиска");
    private static final SelenideElement address = $x("//a[@data-wba-header-name=\"Pick_up_points\"]").as("Адреса");
    private static final SelenideElement login = $x("//a[@data-wba-header-name=\"Login\"]").as("Войти");
    private static final SelenideElement basket = $x("//a[@data-wba-header-name=\"Cart\"]").as("Корзина");
    private static final SelenideElement currency = $x("//div[@class=\"simple-menu__item header__currency j-b-header-country\"]").as("Валюта");
    private static final SelenideElement banner = $x("//div[@data-analitics-code=\"MBB\"]").as("Баннер на главной");

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
        LOGGER.info(getPageName() + ": проверка важных элементов страницы");
        Verify.verifyElements(visible, geo, saleOnWb, workAtWb, logo, menuBurger, searchField, address, login, basket, currency);
    }

    @Override
    public void waitFoPageLoad() {
        banner.shouldBe(visible);
    }
}
