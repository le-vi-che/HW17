package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.$;

public class InsurancesPage {
    private SelenideElement ipotekaInsurances = $("[class='Buttonstyles__Box-sc-vmym2s-0 bGQkMP']",2);
    @Step("Выбираем услугу Клиентам ипотеки")
    public InsurancesPage ipotekaInsurancesClick() {
        ipotekaInsurances.click();
        return this;
    }
}