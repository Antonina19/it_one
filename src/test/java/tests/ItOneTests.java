package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
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
}
