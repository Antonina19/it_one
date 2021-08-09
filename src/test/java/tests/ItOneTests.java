package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class ItOneTests extends TestBase {
    @Test
    @DisplayName("Проверка свойства title главной страницы")
    void titleTest() {
        step("Открытие страницы 'https://www.it-one.ru/'", () ->
                open("https://www.it-one.ru/"));

        step("Свойство title главной страницы сайта должно быть равно IT_ONE. Разработка программного обеспечения мирового уровня'", () -> {
            String expectedTitle = "IT_ONE. Разработка программного обеспечения мирового уровня";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Переход на страницу 'Услуги'")
    void checkOpenPageUslugi() {
        step("Открытие страницы 'https://www.it-one.ru/'", () ->
                open("https://www.it-one.ru/"));

        step("Клик по кнопке 'Услуги'", () -> {
            $(".main-intro__slide-button_1").click();
        });

        step("Свойство title открытой страницы сайта должно быть равно 'Услуги IT_ONE'", () -> {
            String expectedTitle = "Услуги IT_ONE";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Переход на страницу 'Карьера'")
    void checkOpenPageCareer() {
        step("Открытие страницы 'https://www.it-one.ru/'", () ->
                open("https://www.it-one.ru/"));

        step("Переключение на третий слайдер", () -> {
            $(".main-intro__switch_3").click();
        });

        step("Клик по кнопке 'Карьера'", () -> {
            $(".main-intro__slide-button_3").click();
        });

        step("Свойство title открытой страницы сайта должно быть равно 'Карьера в IT_ONE'", () -> {
            String expectedTitle = "Карьера в IT_ONE";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Поиск заголовка 'Технологии IT_ONE'")
    void checkHeading() {
        step("Открытие страницы 'https://www.it-one.ru/'", () ->
                open("https://www.it-one.ru/"));

        step("Проверка заголовка 'Технологии IT_ONE'", () -> {
            $$(".section__header").findBy(text("Технологии IT_ONE"));
        });
    }

    @Test
    @DisplayName("Переход на страницу 'Вакансии'")
    void checkOpenPageVacancies() {
        step("Открытие страницы 'https://www.it-one.ru/'", () ->
                open("https://www.it-one.ru/"));

        step("Клик по кнопке 'Все вакансии'", () -> {
            $(byId("job-section")).$(".common-button").click();
        });

        step("Свойство title открытой страницы сайта должно быть равно 'Вакансии'", () -> {
            String expectedTitle = "Вакансии";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }


}
