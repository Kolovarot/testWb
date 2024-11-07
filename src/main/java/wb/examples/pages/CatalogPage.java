package wb.examples.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wb.examples.util.Verify;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage extends AbstractWbPage{
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPage.class);

    private static final SelenideElement addCardBasket = $x("//article[1]//p[2]/a").as("Добавление товара в корзину");
    private static final SelenideElement productCardNameCatalog = $x("//*[@class='product-card__name']").as("Получение названия товара из каталога поиска");
    private static final SelenideElement articleCatalog = $x("//article[1]").as("Получение артикула товара из каталога поиска");
    private static final SelenideElement priceCardCatalog = $x("//article[1]//span[@class='price__wrap']//ins").as("Получение цены товара из каталога поиска");
    private static final SelenideElement recommendationForYou = $x("//a[@class='searching-results__suggest hide-mobile']").as("Кнопка 'Рекоммендации для вас'");
    private static final SelenideElement searchQuery = $x("//h1[@class='searching-results__title']").as("Заголовок поискового запроса");
    private static final SelenideElement productsFound = $x("//span[@class='searching-results__count']").as("Кол-во найденных товаров");
    private static final SelenideElement allFilter = $x("//div[@class='dropdown-filter j-show-all-filtres']").as("Кнопка Все фильтры");

    public CatalogPage() {
        super("Каталог поиска");
    }

    public static CatalogPage openPage(){
        Selenide.open("https://www.wildberries.ru/catalog/0/search.aspx?search=mask");
        LOGGER.info("Открыть каталог поиска с безразмерным товаром");
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.closeCookies(); //После того как Костя подскажет как выставить разрешение - удалить!!!!
        catalogPage.waitFoPageLoad();
        return catalogPage;
    }

    public void addToBasket(){
        LOGGER.info("Поисковый каталог. Добавление товара в корзину");
        addCardBasket.click();
    }

    public int GetArticleCardSearchCatalog() {
        LOGGER.info("Получение артикула из Каталога поиска");
        return Integer.parseInt(articleCatalog.getAttribute("data-nm-id"));
    }

    public String GetNameCardSearchCatalog() {
        LOGGER.info("Получение названия товара из Каталога поиска");
        return productCardNameCatalog.getText().replace("/ ", "");
    }

    public int GetPriceCardSearchCatalog() {
        LOGGER.info("Получение цены товара из Каталога поиска");
        String getPrice = priceCardCatalog.getText();
        getPrice = getPrice.replace(" ₽", "");
        return Integer.parseInt(getPrice);
    }

    public void waitFoPageLoad() {
        allFilter.shouldBe(visible);
    }

    public void verifyPage(){
        LOGGER.info(getPageName() + ": проверка основных элементов страницы");
        Verify.verifyElements(visible,recommendationForYou,searchQuery,productsFound,allFilter);
    }
}
