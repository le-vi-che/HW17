package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;

public class ItDgtlVacancyPage {

    private ElementsCollection resultVacancySearch= $(".vacancies-0-2-95").$$("[target='_blank']");


    @Step("Проверяем, что вакансии в разделе IT есть")
    public ItDgtlVacancyPage checkItVacancy() {
        resultVacancySearch.shouldHave(size(0));
        return this;
    }


}


