package wb.examples.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import wb.examples.util.Verify;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class BasketPage extends AbstractWbPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasketPage.class);

    private final SelenideElement productCardNameBasket = $x("//*[@class='accordion__list-item list-item j-b-basket-item'][1]//span[@class='good-info__good-name']").as("Название товара в Корзине");
    private final SelenideElement articleBasket = $x("//*[@class='accordion__list-item list-item j-b-basket-item'][1]//div[@data-nm]").as("Артикул товара в Корзине");
    private final SelenideElement priceCardBasket = $x("//*[@class='accordion__list-item list-item j-b-basket-item'][1]//div[@data-link='{formatMoneyAnim priceSumWithWltDiscount}']").as("Цена товара со скидкой в Корзине");
    private final SelenideElement deliveryMethod = $x("//h2[contains(@data-link, 'deliveryPoint')]").as("Блок 'Способ доставки'");


    public BasketPage() {
        super("Страница Корзина");
    }

    @Override
    public void waitFoPageLoad() {
        deliveryMethod.shouldBe(visible);
    }

    @Override
    public void verifyPage() {
        super.verifyPage();//fixme сделай на всех страницах-наследниках вызов метода verifyPage у родителя, т.е. проверить сначала родитель свое, потом текущий класс свое.
        LOGGER.info(getPageName() + ": проверка основных элементов страницы");
        Verify.verifyElements(visible, deliveryMethod);
    }

    public void goToBasket() {
        basket.click();
    }

    public void verifyFirstProduct(String artKT, String nameKT, String priceKT) {
        LOGGER.info("Проверка того что в Корзину добавлен нужный товар"); //fixme логировать информацию о товаре, который будешь проверять, смотри метод toString() у классов.
        Selenide.sleep(2000);//animation prices
        Assert.assertEquals("Сравнение артикулов", articleBasket.getAttribute("data-nm"), artKT);
        Assert.assertEquals("Сравнение наименований", productCardNameBasket.getText(), nameKT);
        Assert.assertEquals("Сравнение цены со скидкой", priceCardBasket.getText(), priceKT);
    }
}
