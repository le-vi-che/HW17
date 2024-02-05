package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class IpotekaPage {
    private SelenideElement applyButton = $("[data-marker='Product.Button']");

    @Step("Проверяем, что доступна кнопка Подать заявку")
    public IpotekaPage checkIpotekaButton() {
        applyButton.shouldBe(visible);
      return this;
    }
}
