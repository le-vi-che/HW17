package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class MainRaifPage {

    private ElementsCollection mainMenuCh = $("[data-marker='MainMenu.MainMenuWrapper']").$$("a");
    private ElementsCollection linkSearch = $("[data-marker='MobileApp.Box']").$$("[data-marker='MobileApp.Button']");

    private SelenideElement chatBut = $("[data-marker='Chat.Button']");

   // miniBuiss
    private SelenideElement chatWindow = $("[data-testid='rchat-root-window']");
    private SelenideElement ipotekaButton = $("[data-marker='MainMenu.MainMenuWrapper']").$(byText("Ипотека"));
    private SelenideElement vtorichkaButton = $("[data-marker='MainMenu.div_3']").$(byText("Вторичный рынок"));

    private SelenideElement aboutButton = $("[data-marker='LinkList.LinkListNav']").$(byText("О банке"));

    @Step("Открываем главную страницу")
    public MainRaifPage openPage() {
        open("");
        return this;
    }

    @Step("Проверяем наличие разделов")
    public MainRaifPage checkMainChapters(List<String> mainMenuChapters) {
        mainMenuCh.shouldHave(textsInAnyOrder(mainMenuChapters));
        return this;
    }

    @Step("Проверяем наличия ссылок на app Store")
    public MainRaifPage checkSocialsLinks() {
        linkSearch.shouldHave(size(3));
            return this;
}

    @Step("Нажимаем кнопку чат")
    public MainRaifPage openChat() {
        chatBut.click();
             return this;
}

    @Step("Проверяем, что чат открылся")
    public MainRaifPage checkChat() {
        chatWindow.should(appear);
                return this;
}

    @Step("Переходим в раздел Вторичная ипотека")
    public MainRaifPage openIpotekaChapter() {
        ipotekaButton.click();
        vtorichkaButton.click();
        return this;
    }

    @Step("Переходим в Обанке")
    public MainRaifPage goToAbout() {
        aboutButton.click();
        return this;
    }
}