package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;
import static data.TestData.INVALID_VAC;
import static data.TestData.VALID_VAC;

@Owner("emonovaev")
@Story("Vacancy page tests")
@Tag("vacancy-tests")
public class VacancyTests extends TestBase {

    MainRaifPage mainPage = new MainRaifPage();
    AboutPage aboutPage = new AboutPage();
    ItDgtlVacancyPage itDgtlVacancyPage = new ItDgtlVacancyPage();
    VacancyMainPage vacancyPage = new VacancyMainPage();
    VacancySearchPage vacancySearchPage = new VacancySearchPage();

    @Test
    @DisplayName("Проверка наличия вакансий IT и DGTL")
    void checkCareerChapterTest() {
        mainPage.openPage()
                .goToAbout();
        aboutPage.goToCareer();
        vacancyPage.openItVacancy();
        itDgtlVacancyPage.checkItVacancy();
    }

    @Test
    @DisplayName("Поиск вакансии QA")
    void searchQaVacancyTest() {
        mainPage.openPage()
                .goToAbout();
        aboutPage.goToCareer();
        vacancyPage.openVacancyPage();
        vacancySearchPage.
                inputVacToFilter(VALID_VAC)
                .checkQaVacancy();
    }

    @Test
    @DisplayName("Проверка нотифкации при отсутсвии вакансии")
    void checkNotificationTextTest() {
        mainPage.openPage()
                .goToAbout();
        aboutPage.goToCareer();
        vacancyPage.openVacancyPage();
        vacancySearchPage
                .inputVacToFilter(INVALID_VAC)
                .checkNoVacancies();
    }
}
