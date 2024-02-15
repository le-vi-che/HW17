package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SellRentPage {

    private SelenideElement rentChapter = $("[data-marker='Tabs.DCTabs.Tab']",1);
    private ElementsCollection rentObject = $$("[data-marker='ProductListItem.ProductListItemWrapper']");

    @Step("Переходим в раздел Аренда")
    public SellRentPage goToRentChapter() {
        rentChapter .click();
        return this;
    }

    @Step("Проверяем наличие объекта аренды")
    public SellRentPage checkRentObject() {
        rentObject.shouldBe(sizeGreaterThan(0));
        return this;
    }
}
