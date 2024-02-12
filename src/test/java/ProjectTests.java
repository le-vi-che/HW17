import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

import java.util.Arrays;
import java.util.List;

import static data.TestData.INVALID_VAC;
import static data.TestData.VALID_VAC;

@Owner("emonovaev")
public class ProjectTests  extends TestBase {

    final List<String> list = Arrays.asList("Кредиты", "Ипотека", "Карты", "Сбережения",
            "Инвестиции", "Страхование", "Переводы", "Сервисы", "Про Онлайн-банк", "Ещё...");

    MainRaifPage mainPage = new MainRaifPage();
    IpotekaPage ipotekaPage = new IpotekaPage();
    AboutPage aboutPage = new AboutPage();

    ItDgtlVacancyPage itDgtlVacancyPage = new ItDgtlVacancyPage();
    VacancyMainPage vacancyPage = new VacancyMainPage();
    VacancySearchPage vacancySearchPage = new VacancySearchPage();

    @Test
    @Tag("raif-tests")
    @DisplayName("Проверка разделов в меню")
    void checkMenuContentTest() {
        mainPage.openPage()
                .checkMainChapters(list);
    }

    @Test
    @Tag("raif-tests")
    @DisplayName("Проверка ссылок на app Store")
    void checkLinkToAppTest() {
        mainPage.openPage()
                .checkSocialsLinks();
    }

    @Test
    @Tag("raif-tests")
    @DisplayName("Проверка подсвечивания незаполненных полей в онлайн чате")
    void checkOpenChatTest() {
        mainPage.openPage()
                .openChat()
                .chooseChat()
                .startChatButton()
                .checkLightField();
    }

    @Test
    @Tag("raif-tests")
    @DisplayName("Проверка наличия кнопки Подать заявку в разделе Ипотека")
    void checkIpotekaButton() {
        mainPage.openPage()
                .openIpotekaChapter();
        ipotekaPage.checkIpotekaButton();
    }

    @Test
    @Tag("vacancy-tests")
    @DisplayName("Проверка наличия вакансий IT и DGTL")
    void checkCareerChapterTest() {
        mainPage.openPage()
                .goToAbout();
        aboutPage.goToCareer();
        vacancyPage.openItVacancy();
        itDgtlVacancyPage.checkItVacancy();
    }

    @Test
    @Tag("vacancy-tests")
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
    @Tag("vacancy-tests")
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