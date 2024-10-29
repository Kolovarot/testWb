package wb.examples.tests;

import org.junit.jupiter.api.Test;
import wb.examples.pages.BasketPage;

public class TestBasketPage {
    @Test
    public void addProductAndComparasion(){

        BasketPage basketPage = BasketPage.addProductWithoutSizeFromSearchCatalog();
        String nameInCatalog = basketPage.getProductName();
        basketPage.addProductToBasket();
        basketPage.goToBasket();
        String nameInBasket = basketPage.getProductNameInBasket();
        nameInCatalog.equals(nameInBasket);
        System.out.println(nameInBasket);
        System.out.println(nameInCatalog);
    }
}
