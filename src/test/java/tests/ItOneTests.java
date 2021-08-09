package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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
    @DisplayName("Поиск заголовка 'Технологии IT_ONE'")
    void checkHeading() {
        step("Открытие страницы 'https://www.it-one.ru/'", () ->
                open("https://www.it-one.ru/"));

        step("Проверка заголовка 'Технологии IT_ONE'", () -> {
            $$(".section__header").findBy(text("Технологии IT_ONE"));
        });
    }

    @Test
    @DisplayName("Переход на страницу 'Контакты'")
    void checkOpenPage() {
        step("Открытие страницы 'https://www.it-one.ru/'", () ->
                open("https://www.it-one.ru/"));

        step("Переход на страницу 'Контакты'", () -> {
            $$(".footer__nav__item").findBy(text("Контакты")).click();
        });

        step("Проверка заголовка 'Наши контакты'", () -> {
            $$(".large-line").findBy(text("Наши контакты"));
        });

    }
}
