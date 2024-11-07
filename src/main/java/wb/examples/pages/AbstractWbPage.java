package wb.examples.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import wb.examples.util.Verify;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

abstract public class AbstractWbPage {
    protected final SelenideElement profileElement = $x("//a[@data-wba-header-name='LK']").as("Ссылка [Профиль] в шапке сайта");
    protected final SelenideElement basket = $x("//span[@class='navbar-pc__icon navbar-pc__icon--basket']").as("Корзина в хедере");
    protected final SelenideElement buttonCookies = $x("//button[@class='cookies__btn btn-minor-md']").as("Плашка с куки");

    private final String pageName;

    public AbstractWbPage(String pageName) {
        this.pageName = pageName;
    }

    public String getPageName() {
        return pageName;
    }

    abstract public void waitFoPageLoad();

    public String getPageHeader() {
        return null;
    }

    public void closeCookies() {
        buttonCookies.click();
    }

    public void refreshPage() {
        Selenide.refresh();
        waitFoPageLoad();
    }

    public void verifyAuthUser() {
        profileElement.shouldBe(visible);
    }

    public void verifyPage() {
        Verify.verifyElements(visible, basket);
    }

    public BasketPage clickBasketIcon() {
        basket.click();
        BasketPage basketPage = new BasketPage();
        basketPage.waitFoPageLoad();
        return basketPage;
        //Описать общий переход через корзину (из хеедера)
    }

}
