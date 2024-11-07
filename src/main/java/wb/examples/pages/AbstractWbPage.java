package wb.examples.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

abstract public class AbstractWbPage {
    private final SelenideElement profileElement = $x("//a[@data-wba-header-name='LK']").as("Ссылка [Профиль] в шапке сайта");
    private final SelenideElement basket = $x("//span[@class='navbar-pc__icon navbar-pc__icon--basket']").as("Корзина в хедере");
    private final SelenideElement buttonCookies = $x("//button[@class='cookies__btn btn-minor-md']").as("Плашка с куки");

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

    abstract public void verifyPage();

    public void goToBasket() {
        basket.click();
        //Описать общий переход через корзину (из хеедера)
    }

}
