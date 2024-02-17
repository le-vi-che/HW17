package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static data.TestData.RESP;
import static data.TestData.VALID_VAC;

public class VacancySearchPage {

    private SelenideElement searchField = $("[placeholder='Поиcк']");
    private  SelenideElement resultField =  $("[target='_blank']");
    private SelenideElement noVacancies =  $(".root-0-2-162");

    @Step("Вводим параметры поиска")
    public VacancySearchPage inputVacToFilter(String testData) {
        searchField.setValue(testData);
        return this;
    }

    @Step("Проверяем, что вакансии есть")
    public VacancySearchPage checkQaVacancy() {
        resultField.shouldHave(text(VALID_VAC));
        return this;
    }

    @Step("Проверяем, что вакансий не обнаружено")
    public VacancySearchPage checkNoVacancies() {
        noVacancies.shouldHave(text(RESP));
        return this;
    }
}
