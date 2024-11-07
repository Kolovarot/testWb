package wb.examples.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wb.examples.util.Verify;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CatalogPage extends AbstractWbPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogPage.class);

    //fixme убери статик у всех SelenideElement и регистр переменных поправь
    private static final SelenideElement ADD_CARD_BASKET = $x("//article[1]//p[2]/a").as("Добавление товара в корзину");
    private static final SelenideElement PRODUCT_CARD_NAME_CATALOG = $x("//*[@class='product-card__name']").as("Получение названия товара из каталога поиска");
    private static final SelenideElement ARTICLE_CATALOG = $x("//article[1]").as("Получение артикула товара из каталога поиска");
    private static final SelenideElement PRICE_CARD_CATALOG = $x("//article[1]//span[@class='price__wrap']//ins").as("Получение цены товара из каталога поиска");
    private static final SelenideElement RECOMMENDATION_FOR_YOU = $x("//a[@class='searching-results__suggest hide-mobile']").as("Кнопка 'Рекоммендации для вас'");
    private static final SelenideElement SEARCH_QUERY = $x("//h1[@class='searching-results__title']").as("Заголовок поискового запроса");
    private static final SelenideElement PRODUCTS_FOUND = $x("//span[@class='searching-results__count']").as("Кол-во найденных товаров");
    private static final SelenideElement ALL_FILTER = $x("//div[@class='dropdown-filter j-show-all-filtres']").as("Кнопка Все фильтры");

    public CatalogPage() {
        super("Каталог поиска");
    }

    public static CatalogPage openPage() {
        Selenide.open("https://www.wildberries.ru/catalog/0/search.aspx?search=mask");
        LOGGER.info("Открыть каталог поиска с безразмерным товаром");
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.closeCookies(); //После того как Костя подскажет как выставить разрешение - удалить!!!!
        catalogPage.waitFoPageLoad();
        return catalogPage;
    }

    public void addFirstProductToBasket() {
        LOGGER.info("Поисковый каталог. Добавление товара в корзину");
        ADD_CARD_BASKET.click();
    }

    public String getArticleCardSearchCatalog() {
        LOGGER.info("Получение артикула из Каталога поиска");
        return ARTICLE_CATALOG.getAttribute("data-nm-id");
    }

    //fixme с маленькой буквы методы, проверь все методы
    public String GetNameCardSearchCatalog() {
        LOGGER.info("Получение названия товара из Каталога поиска");
        return PRODUCT_CARD_NAME_CATALOG.getText().replace("/ ", "");
    }

    public String getPriceCardSearchCatalog() {
        LOGGER.info("Получение цены товара из Каталога поиска");
        return PRICE_CARD_CATALOG.getText();
    }

    public void waitFoPageLoad() {
        ALL_FILTER.shouldBe(visible);
    }

    public void verifyPage() {
        LOGGER.info(getPageName() + ": проверка основных элементов страницы");
        Verify.verifyElements(visible, RECOMMENDATION_FOR_YOU, SEARCH_QUERY, PRODUCTS_FOUND, ALL_FILTER);
    }
}
