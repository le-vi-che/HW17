package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static data.TestData.COMPANY_LIST;

public class IpotekaInsurancesPage {
    private SelenideElement goToCompanyList = $("[data-marker='Tabs.DCTabs.Tab']", 2);
    private SelenideElement checkCompanyList = $("[data-marker='Paragraph.ParagraphWrapper']", 0);
    @Step("Переходим в раздел Список компаний")
    public IpotekaInsurancesPage  openCompanyList() {
        goToCompanyList.click();
        return this;
    }

    @Step("Проверяем список страховых компаний")
    public IpotekaInsurancesPage checkCompanyInsurancesList(){
        checkCompanyList.shouldHave(text(COMPANY_LIST));
        return this;
    }
}