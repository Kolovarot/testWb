package wb.examples.tests;

import org.junit.jupiter.api.Test;
import wb.examples.pages.BasketPage;
import wb.examples.pages.CatalogPage;

public class BasketPageTest extends TestBase {

    //fixme модифицируй тест так, чтобы добавлялось 5 товаров и проверяй у них так же артикул, имя, цену.
    //создай новый класс Product, с полями артикул, имя, цену, в конструкторе на вход будут идти эти 3 переменные.
    //метод добавления товаров в корзину из каталога должен принимать количество добавляемых товаров, товары должны браться рандомные, от 0 до 30 (примерно), иначе там ленивая подгрузка товаров на странице
    //метод добавления товаров в корзину из каталога будет возвращать список продуктов которые добавил List<Product>, данные для каждого продукта так же парсишь прям со страницы.
    @Test
    public void addProductAndComparison() {
        CatalogPage catalogPage = CatalogPage.openPage();
        catalogPage.verifyPage();
        String nameKTFromCatalog = catalogPage.GetNameCardSearchCatalog();
        String artKTFromCatalog = catalogPage.getArticleCardSearchCatalog();
        String priceKTFromCatalog = catalogPage.getPriceCardSearchCatalog();
        catalogPage.addFirstProductToBasket();
        BasketPage basketPage = catalogPage.clickBasketIcon();
        basketPage.verifyFirstProduct(artKTFromCatalog, nameKTFromCatalog, priceKTFromCatalog);
    }
}
