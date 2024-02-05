package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class AboutPage {

    private SelenideElement vacancyPageGoButton = $("[data-marker='StoryIconBlockItem.Grid.Col']", 1);
    @Step("Переходим в Обанке")
    public AboutPage goToCareer() {
        vacancyPageGoButton.click();
        return this;
    }
}
