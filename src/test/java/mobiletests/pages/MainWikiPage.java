package mobiletests.pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class MainWikiPage {

    private final String
            searchPlaceHolder = "Search Wikipedia";

    public MainWikiPage searchInput(String request) {
        String inputField = "org.wikipedia.alpha:id/search_src_text";
        step("Вставить \"" + request + "\" в строку поиска", () -> {
            $(AppiumBy.accessibilityId(searchPlaceHolder)).click();
            $(AppiumBy.id(inputField)).sendKeys(request);
        });

        return this;
    }

    public MainWikiPage goToSaves() {
        String saved = "Saved";

        step("Перейти на страницу с сохранёнными статьями", () ->
                $(AppiumBy.accessibilityId(saved)).click());
        return this;
    }

    public void searchExisting() {
        step("Появилась строка поиска", () ->
                $(AppiumBy.accessibilityId(searchPlaceHolder)).shouldBe(exist));
    }
}