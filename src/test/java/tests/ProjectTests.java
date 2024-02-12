package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

import java.util.Arrays;
import java.util.List;

@Owner("emonovaev")
@Story("Main page tests")
@Tag("raif-tests")
public class ProjectTests  extends TestBase {

    final List<String> list = Arrays.asList("Кредиты", "Ипотека", "Карты", "Сбережения",
            "Инвестиции", "Страхование", "Переводы", "Сервисы", "Про Онлайн-банк", "Ещё...");

    MainRaifPage mainPage = new MainRaifPage();
    IpotekaPage ipotekaPage = new IpotekaPage();

    @Test
    @DisplayName("Проверка разделов в меню")
    void checkMenuContentTest() {
        mainPage.openPage()
                .checkMainChapters(list);
    }

    @Test
    @DisplayName("Проверка ссылок на app Store")
    void checkLinkToAppTest() {
        mainPage.openPage()
                .checkSocialsLinks();
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
    @DisplayName("Проверка наличия кнопки Подать заявку в разделе Ипотека")
    void checkIpotekaButton() {
        mainPage.openPage()
                .openIpotekaChapter();
        ipotekaPage.checkIpotekaButton();
    }
}