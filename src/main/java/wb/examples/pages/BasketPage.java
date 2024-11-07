package wb.examples.pages;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wb.examples.util.Verify;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class BasketPage extends AbstractWbPage{
    private static final Logger LOGGER = LoggerFactory.getLogger(BasketPage.class);

    private static final SelenideElement PRODUCT_CARD_NAME_BASKET = $x("//*[@class='accordion__list-item list-item j-b-basket-item'][1]//span[@class='good-info__good-name']").as("Название товара в Корзине");
    private static final SelenideElement ARTICLE_BASKET = $x("//*[@class='accordion__list-item list-item j-b-basket-item'][1]//div[@data-nm]").as("Получение артикула товара в Корзине");
    private static final SelenideElement PRICE_CARD_BASKET = $x("//*[@class='accordion__list-item list-item j-b-basket-item'][1]//div[@data-link='{formatMoneyAnim priceSumWithWltDiscount}']").as("Получение цены товара со скидкой в Корзине");
    //Нужна хелпа в объяснении как вынести это в AbstractWbPage
    private static final SelenideElement BASKET = $x("//span[@class='navbar-pc__icon navbar-pc__icon--basket']").as("Корзина в хедере");
    private static final SelenideElement DELIVERY_METHOD = $x("//h2[@data-link='class{merge: deliveryPoint toggle='hide-mobile'}']");

    public BasketPage() {
        super("Корзина");
    }

    @Override
    public void waitFoPageLoad() {
        DELIVERY_METHOD.shouldBe(visible);
    }

    @Override
    public void verifyPage() {
        LOGGER.info(getPageName() + ": проверка основных элементов страницы");
        Verify.verifyElements(visible,DELIVERY_METHOD);
    }

    public void goToBasket() {
        BASKET.click();
    }

    public void compareProducts (int artKT, String nameKT, int priceKT) {
        LOGGER.info("Проверка того что в Корзину добавлен нужный товар");
        int GetArticleCardBasket = Integer.parseInt(ARTICLE_BASKET.getAttribute("data-nm"));
        String GetNameCardBasket = PRODUCT_CARD_NAME_BASKET.getText();
        int GetPriceCardBasket = Integer.parseInt(PRICE_CARD_BASKET.getText().replace(" ₽", ""));
        Assert.assertTrue("Сравнение артикулов",GetArticleCardBasket == artKT);
        Assert.assertTrue("Сравнение наименований",GetNameCardBasket.equals(nameKT));
        Assert.assertTrue("Сравнение цены со скидкой",GetPriceCardBasket == priceKT);
    }
}
