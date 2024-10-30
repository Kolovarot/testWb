package wb.examples.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class BasketPage extends AbstractWbPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasketPage.class);
    private final SelenideElement addCardBasket = $x("//article[1]//p[2]/a");
    //fixme пройдись по всем элементам в проекте и ковычки двойные в xpath поменяй на одинарные '
    //fixme название должно быть у всех SelenideElement, а не просто xpath, это тоже касается всех элементов в проекте
    private final SelenideElement basket = $x("//span[@class=\"navbar-pc__icon navbar-pc__icon--basket\"]");
    //private final SelenideElement searchInput = $x("//*[@id=\"searchInput\"]");
    private final SelenideElement productCardNameCatalog = $x("//*[@class=\"product-card__name\"]");
    private final SelenideElement productCardNameBasket = $x("//*[@class='accordion__list-item list-item j-b-basket-item'][1]//span[@class=\"good-info__good-name\"]");

    public BasketPage() {
        super("Каталог безразмерных товаров");
    }

    //fixme данный метод должен открыть каталог и добавить товар в корзину, переход на страницу корзины должен быть отдельным действием прям внутри теста.
    //fixme а данный метод открывает урл каталога, затем показывает что отклась страницы корзины, хотя открыта страница каталога.
    //Добавоение безразмерного товара из каталога поиска
    public static BasketPage addProductWithoutSizeFromSearchCatalog() {
        LOGGER.info("Открыть каталог безразмерных товаров");
        Selenide.open("https://www.wildberries.ru/catalog/0/search.aspx?search=mask");
        BasketPage basketPage = new BasketPage();
        basketPage.waitFoPageLoad();
        return basketPage;
    }

    //fixme В этом классе должны быть только методы связанные со страницей корзины, каталожная карточка тут причем (судя по названию)?
    public String getProductName() {
        String nameProductCatalog = productCardNameCatalog.getText();
        return nameProductCatalog;
    }

    //fixme в корзину добавляем со страницы каталога, тащи метод туда
    public void addProductToBasket() {
        addCardBasket.click();
    }

    //fixme унеси в AbstractWbPage, т.е. с любой страницы где есть шапка сайта можно кликнуть на корзину, а не только со страницы корзины
    public void goToBasket() {
        basket.click();
    }

    public String getProductNameInBasket (){
        String nameProductBasket = productCardNameBasket.getText();
        return nameProductBasket;
    }

    //fixme
    //1. Метод не используется
    //2. В него лучше передавать артикул, название КТ и цену, это типа минимальный набор проверок, будет кайф.
    //потом берешь элемент на странице артикул, название КТ, цену и проверяешь с тем, что ты передал в этот метод.
    public void compareProducts(String nameProductCatalog, String nameProductBasket){
        nameProductBasket.equals(nameProductCatalog);
    }


    @Override
    public void waitFoPageLoad() {
        productCardNameCatalog.shouldBe(visible);
    }

    @Override
    public void verifyPage() {

    }
}
