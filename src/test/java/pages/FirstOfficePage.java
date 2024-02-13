package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static data.TestData.OFFICE_NAME;

public class FirstOfficePage {
    private SelenideElement nameOffice =  $(".b-page-heading__title").$("h2");

    @Step("Проверяем, что открылась страница первого отделения из списка")
    public FirstOfficePage checkNameOffice() {
        nameOffice.shouldHave(text(OFFICE_NAME));
        return this;
    }
}
