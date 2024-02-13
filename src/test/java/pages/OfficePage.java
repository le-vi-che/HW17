package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class OfficePage {

    private  SelenideElement chooseCityBt = $(".informer__btns").$(byText("Да"));
    private SelenideElement listCityBt = $(".b-switch__block");
    private SelenideElement firstOffice = $(".e-office-item__title");

    @Step("Выбираем город Москва")
    public OfficePage chooseCity() {
        chooseCityBt.click();
        return this;
    }

    @Step("Выбираем поиск офиса Списком")
    public OfficePage listCitySearch() {
        listCityBt.click();
        return this;
    }

    @Step("Переходим в первый офис из списка")
    public OfficePage firstOfficeOpen() {
        firstOffice.click();
        return this;
    }
}
