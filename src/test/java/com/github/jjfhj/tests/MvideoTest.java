package com.github.jjfhj.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.github.jjfhj.tests.TestData.MVIDEO_URL;
import static io.qameta.allure.Allure.step;

@DisplayName("Тестирование веб-приложения М.Видео")
public class MvideoTest extends TestBase {

    @ValueSource(strings = {"Ирригатор B.Well WI-911 150мл (2 насадки)",
            "Ирригатор B.Well WI-912 (5 насадок)"})
    @DisplayName("Результаты поиска")
    @Tags({@Tag("Web"), @Tag("Blocker"), @Tag("High")})
    @ParameterizedTest(name = "Отображение товара {0} в результатах поиска")
    @Owner("Карина Гордиенко (jjfhj)")
    @Feature("Поиск")
    @Story("Страница результатов поиска")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "М.Видео", url = "https://www.mvideo.ru/")
    void searchResultsTest(String searchQuery) {
        step("Открыть главную страницу М.Видео", () -> {
            open(MVIDEO_URL);
        });
        step("Найти ирригаторы торговой марки B.Well", () -> {
            $(".input__field").setValue("Ирригатор B.Well").pressEnter();
        });
        step("Найти отображение товара " + searchQuery + " в результатах поиска", () -> {
            $$("div.product-cards-layout--grid").shouldHave(texts(searchQuery));
        });
    }

    @CsvSource(value = {
            "Зеркало косметическое | Зеркала косметические",
            "Apple Magic Mouse | Беспроводные мыши Apple"
    }, delimiter = '|')
    @DisplayName("Фильтр 'Категория'")
    @Tags({@Tag("Web"), @Tag("Minor"), @Tag("Low")})
    @ParameterizedTest(name = "Отображение категории {1} в фильтре 'Категория'")
    @Owner("Карина Гордиенко (jjfhj)")
    @Feature("Фильтры")
    @Story("Блок фильтров")
    @Severity(SeverityLevel.MINOR)
    @Link(name = "М.Видео", url = "https://www.mvideo.ru/")
    void filterCategoryTest(String searchQuery, String categoryName) {
        step("Открыть главную страницу М.Видео", () -> {
            open(MVIDEO_URL);
        });
        step("Найти товар " + searchQuery, () -> {
            $(".input__field").setValue(searchQuery).pressEnter();
        });
        step("Найти отображение категории " + categoryName + " в фильтре 'Категория'", () -> {
            $(".filter-checkbox-list").shouldHave(text(categoryName));
        });
    }
}
