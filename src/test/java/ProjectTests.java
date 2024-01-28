import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class ProjectTests  extends TestBase{

    @Test
    @DisplayName("Проверка разделов в меню")
    void checkMenuContentTest(){
        open("https://www.raiffeisen.ru/");
        $("[data-marker='MainMenu.MainMenuWrapper']").shouldHave(text("Кредиты"));
        $("[data-marker='MainMenu.MainMenuWrapper']").shouldHave(text("Ипотека"));
        $("[data-marker='MainMenu.MainMenuWrapper']").shouldHave(text("Карты"));
        $("[data-marker='MainMenu.MainMenuWrapper']").shouldHave(text("Сбережения"));
        $("[data-marker='MainMenu.MainMenuWrapper']").shouldHave(text("Инвестиции"));
        $("[data-marker='MainMenu.MainMenuWrapper']").shouldHave(text("Страхование"));
        $("[data-marker='MainMenu.MainMenuWrapper']").shouldHave(text("Переводы"));
        $("[data-marker='MainMenu.MainMenuWrapper']").shouldHave(text("Сервисы"));
        $("[data-marker='MainMenu.MainMenuWrapper']").shouldHave(text("Про Онлайн-банк"));
    }

@Test
@DisplayName("Проверка ссылок на app Store")
    void checkLinkToAppTest(){
        open("https://www.raiffeisen.ru/");
        $("[data-marker='MobileApp.Box']").$$("[data-marker='MobileApp.Button']").shouldHave(size(3));
    }


    @Test
    @DisplayName("Проверка открытия чата")

    void checkOpenChatTest(){
        open("https://www.raiffeisen.ru/");
        $("[data-marker='Chat.Button']").click();
        $("[data-testid='rchat-root-window']").should(appear);
    }

    @Test
    @DisplayName("Проверка наличия кнопки Подать заявку в разделе Ипотека")

    void checkIpotekaButton(){
        open("https://www.raiffeisen.ru/");
        $("[data-marker='MainMenu.MainMenuWrapper']").$(byText("Ипотека")).click();
        $("[data-marker='MainMenu.div_3']").$(byText("Вторичный рынок")).click();
        $("[data-marker='Product.Button']").shouldBe(visible);
    }

    @Test
    @DisplayName("Проверка наличия вакансий IT и DGTL")
    void checkCareerChapterTest(){
        open("https://www.raiffeisen.ru/");
        $("[data-marker='LinkList.LinkListNav']").$(byText("О банке")).click();
        $("[data-marker='StoryIconBlockItem.Grid.Col']", 1).click();
        $(".tabs-0-2-6").$(byText("IT и DGTL")).click();
        $(".vacancies-0-2-95").$$("[target='_blank']").shouldHave(size(0));
    }

    @Test
    @DisplayName("Поиск вакансии QA")
    void searchQaVacancyTest(){
        open("https://www.raiffeisen.ru/about/");
        $("[data-marker='StoryIconBlockItem.Grid.Col']", 1).click();
        $(".tabs-0-2-6").$(byText("Вакансии")).click();
        $("[placeholder='Поиcк']").setValue("QA");
        $("[target='_blank']").shouldHave(text("QA"));
    }
}
