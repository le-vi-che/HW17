package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VacancyMainPage {

    private  SelenideElement itChapter =  $(".tabs-0-2-6").$(byText("IT и DGTL"));
    private  SelenideElement vacancyChapter = $(".tabs-0-2-6").$(byText("Вакансии"));

    @Step("Переходим в раздел вакансий IT")
    public VacancyMainPage openItVacancy() {
        itChapter.click();
        return this;
    }

    @Step("Переходим в раздел вакансий")
    public VacancyMainPage openVacancyPage() {
        vacancyChapter.click();
        return this;
    }

}
