package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class MainRaifPage {

    private ElementsCollection mainMenuCh = $("[data-marker='MainMenu.MainMenuWrapper']").$$("a");
    private SelenideElement officePage = $("[data-marker='MenuItem.Link']", 8);
    private SelenideElement chatBut = $("[data-marker='Chat.Button']");
    private SelenideElement chatWindow = $("[data-testid='rchat-selectable-skill-7']");
    private SelenideElement startBt =  $("[data-testid='rchat-form-start-chat-button']");
    private SelenideElement checkField =$("[data-testid='rchat-form-name-input']");
    private SelenideElement goToRealEstate =$("[data-marker='LinkList.div_0']");
    private SelenideElement insurancesButton = $("[data-marker='MainMenu.MainMenuWrapper']").$(byText("Страхование"));
    private SelenideElement insurancesCreditButton = $("[data-marker='MainMenu.div_3']").$(byText("Заемщикам кредитов"));

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
    public MainRaifPage openOfficePage() {
        officePage.click();
            return this;
    }

    @Step("Нажимаем кнопку чат")
    public MainRaifPage openChat() {
        chatBut.click();
             return this;
    }

    @Step("Выбираем Чат для меня")
    public MainRaifPage chooseChat() {
        chatWindow.click();
                return this;
    }


    @Step("Нажимаем кнопку Начать чат, без заполнения полей")
    public MainRaifPage startChatButton() {
        startBt.click();
        return this;
    }

    @Step("Проверяем, что обязательные незаполненые поля подсвечены")
    public MainRaifPage checkLightField() {
        checkField.shouldHave(Condition.cssValue("border-bottom-color", "rgba(238, 80, 90, 1)"));;
        return this;
    }

    @Step("Перходим в раздел Продажа и аренда недвижимости банка")
    public MainRaifPage goToSellChapter() {
        goToRealEstate.$(byText("Продажа и аренда недвижимости банка")).click();
        return this;
    }



    @Step("Переходим в раздел Страхоние для заемщиков кредитов")
    public MainRaifPage openInsurancesChapter() {
        insurancesButton.click();
        insurancesCreditButton.click();
        return this;
    }

    @Step("Переходим в Обанке")
    public MainRaifPage goToAbout() {
        aboutButton.click();
        return this;
    }
}