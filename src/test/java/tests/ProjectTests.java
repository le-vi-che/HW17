package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

import static data.TestData.MAIN_MENU_LIST;

@Owner("emonovaev")
@Story("raifaizen tests")
@Tag("raif-tests")
public class ProjectTests  extends TestBase {

    MainRaifPage mainPage = new MainRaifPage();
    InsurancesPage insurancesPage = new InsurancesPage();
    IpotekaInsurancesPage ipotekaInsurancesPage = new IpotekaInsurancesPage();
    OfficePage officePage = new OfficePage();
    FirstOfficePage firstOfficePage = new FirstOfficePage();
    SellRentPage sellRentPage = new SellRentPage();


    @Test
    @DisplayName("Проверка разделов в меню")
    void checkMenuContentTest() {
        mainPage.openPage()
                .checkMainChapters(MAIN_MENU_LIST);
    }

    @Test
    @DisplayName("Открытие первого офиса из списка")
    void checkFirstOfficeTest() {
        mainPage.openPage()
                .openOfficePage();
        officePage.chooseCity()
                  .listCitySearch()
                  .firstOfficeOpen();
        firstOfficePage.checkNameOffice();
    }

    @Test
    @DisplayName("Проверка подсвечивания незаполненных полей в онлайн чате")
    void checkOpenChatTest() {
        mainPage.openPage()
                .openChat()
                .chooseChat()
                .startChatButton()
                .checkLightField();
    }

    @Test
    @DisplayName("Проверка наличия объектов к аренде")
    void checkRentBanksOffice() {
        mainPage.openPage()
                .goToSellChapter();
        sellRentPage.goToRentChapter()
                .checkRentObject();
    }

    @Test
    @DisplayName("Проверка наличия списка страховых компаний")
    void checkListOfInsurances (){
        mainPage.openPage()
                .openInsurancesChapter();
        insurancesPage.ipotekaInsurancesClick();
        ipotekaInsurancesPage.openCompanyList()
                .checkCompanyInsurancesList();
    }
}