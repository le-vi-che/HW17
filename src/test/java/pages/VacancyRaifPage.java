package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class VacancyRaifPage {

    public String prof = "QA";
    public String notexistvac = "nh'lkjlkj";
    public String resp = "Вакансий по запросу не найдено";

    private  SelenideElement itChapter =  $(".tabs-0-2-6").$(byText("IT и DGTL"));
    private  SelenideElement vacancyChapter = $(".tabs-0-2-6").$(byText("Вакансии"));
    private  SelenideElement searchField = $("[placeholder='Поиcк']");
    private  SelenideElement resultField =  $("[target='_blank']");
    private SelenideElement noVacancies =  $(".Headingstyles__Box-sc-vu5axy-0");
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
        searchField.setValue(prof);
        return this;
    }

    @Step("Проверяем, что вакансии есть")
    public VacancyRaifPage checkQaVacancy() {
        resultField.shouldHave(text(prof));
        return this;
    }

    @Step("Вводим несуществующую вакансию")
    public VacancyRaifPage inputNotExistVac() {
        searchField.setValue(notexistvac);
        return this;
    }

    @Step("Проверяем, что вакансий не обнаружено")
    public VacancyRaifPage checkNoVacancies() {
        noVacancies.shouldHave(text(resp));
        return this;
    }
}
