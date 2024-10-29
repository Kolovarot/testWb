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
    private final SelenideElement basket = $x("//span[@class=\"navbar-pc__icon navbar-pc__icon--basket\"]");
    //private final SelenideElement searchInput = $x("//*[@id=\"searchInput\"]");
    private final SelenideElement productCardNameCatalog = $x("//*[@class=\"product-card__name\"]");
    private final SelenideElement productCardNameBasket = $x("//*[@class='accordion__list-item list-item j-b-basket-item'][1]//span[@class=\"good-info__good-name\"]");

    public BasketPage() {
        super("Каталог безразмерных товаров");
    }
    //Добавоение безразмерного товара из каталога поиска
    public static BasketPage addProductWithoutSizeFromSearchCatalog() {
        LOGGER.info("Открыть каталог безразмерных товаров");
        Selenide.open("https://www.wildberries.ru/catalog/0/search.aspx?search=mask");
        BasketPage basketPage = new BasketPage();
        basketPage.waitFoPageLoad();
        return basketPage;
    }

    public String getProductName() {
        String nameProductCatalog = productCardNameCatalog.getText();
        return nameProductCatalog;
    }

    public void addProductToBasket() {
        addCardBasket.click();
    }

    public void goToBasket() {
        basket.click();
    }

    public String getProductNameInBasket (){
        String nameProductBasket = productCardNameBasket.getText();
        return nameProductBasket;
    }

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
