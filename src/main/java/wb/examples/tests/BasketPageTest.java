package wb.examples.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import wb.examples.pages.BasketPage;
import wb.examples.pages.CatalogPage;

public class BasketPageTest {

    @Test
    public void addProductAndComparison() {
        CatalogPage catalogPage = CatalogPage.openPage();
        catalogPage.verifyPage();
        String nameKT = catalogPage.GetNameCardSearchCatalog();
        int artKT = catalogPage.GetArticleCardSearchCatalog();
        int priceKT = catalogPage.GetPriceCardSearchCatalog();
        catalogPage.addToBasket();
        BasketPage basketPage = new BasketPage();
        basketPage.goToBasket();
        Selenide.sleep(2000);
        basketPage.compareProducts(artKT, nameKT, priceKT);
    }
}
