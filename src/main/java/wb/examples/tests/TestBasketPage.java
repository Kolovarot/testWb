package wb.examples.tests;

import org.junit.jupiter.api.Test;
import wb.examples.pages.BasketPage;

public class TestBasketPage {
    //fixme
    //0. Создай класс CatalogPage, в нем будет метод проверки страницы, метод добавление первого товара в корзину и статический метод открытия каталога (смотри wb.examples.pages.MainPage.openPage).
    //1. addProductWithoutSizeFromSearchCatalog - должен быть в классе CatalogPage
    //2. addProductToBasket должен быть внутри метода addProductWithoutSizeFromSearchCatalog
    // После тест должен быть из действий (методов):
//    1. Открыть страницу каталога
//    2. Проверить страницу каталога: основные элементы каталога (штуки 3-5) и проверка что есть товары
//    3. Добавить первый товар в корзину
//    4. Перейти в корзину
//    5. Передать в метод проверки товара в классе BasketPage артикул + имя+ цену и проверить что все совпадает, для проверки что все сделано верно, передай неправильные значения, тест должен падать на них.
    //если чет не получиться, будет онлайн делать или спрашивай частями вопрос + скрин кода
    @Test
    public void addProductAndComparasion() {
        BasketPage basketPage = BasketPage.addProductWithoutSizeFromSearchCatalog();
        String nameInCatalog = basketPage.getProductName();
        basketPage.addProductToBasket();
        basketPage.goToBasket();
        String nameInBasket = basketPage.getProductNameInBasket();
        nameInCatalog.equals(nameInBasket);//fixme ты же делал метод для сравнения на странице корзины wb.examples.pages.BasketPage.compareProducts, используй его.
        System.out.println(nameInBasket);
        System.out.println(nameInCatalog);
    }
}
