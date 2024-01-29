package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VacancyRaifPage {

    private  SelenideElement itChapter =  $(".tabs-0-2-6").$(byText("IT и DGTL"));
    private  SelenideElement vacancyChapter = $(".tabs-0-2-6").$(byText("Вакансии"));
    private  SelenideElement searchField = $("[placeholder='Поиcк']");
    private  SelenideElement resultField =  $("[target='_blank']");

    private ElementsCollection resultVacancySearch= $(".vacancies-0-2-95").$$("[target='_blank']");

    @Step("Переходим в раздел вакансий IT")
    public VacancyRaifPage openItVacancy() {
        itChapter.click();
        return this;
    }

    @Step("Проверяем, что вакансии в разделе IT есть")
    public VacancyRaifPage checkItVacancy() {
        resultVacancySearch.shouldHave(size(0));
        return this;
    }

    @Step("Переходим в раздел вакансий")
    public VacancyRaifPage openVacancyPage() {
        vacancyChapter.click();
        return this;
    }

    @Step("Вводим параметры поиска")
    public VacancyRaifPage inputQAtoFilter() {
        searchField.setValue("QA");
        return this;
    }

    @Step("Проверяем, что вакансии есть")
    public VacancyRaifPage checkQaVacancy() {
        resultField.shouldHave(text("QA"));
        return this;
    }
}
