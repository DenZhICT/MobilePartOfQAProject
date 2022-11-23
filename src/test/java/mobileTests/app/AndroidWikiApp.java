package mobileTests.app;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidWikiApp {

    private final String skipButton = "org.wikipedia.alpha:id/fragment_onboarding_skip_button",
            nextButton = "org.wikipedia.alpha:id/fragment_onboarding_forward_button",
            doneButton = "org.wikipedia.alpha:id/fragment_onboarding_done_button",
            negativeButton = "org.wikipedia.alpha:id/negativeButton",
            inputField = "org.wikipedia.alpha:id/search_src_text",
            listOfResponse = "org.wikipedia.alpha:id/page_list_item_title",
            emptyTitle = "org.wikipedia.alpha:id/empty_title",
            primaryView = "org.wikipedia.alpha:id/primaryTextView",
            view = "android.view.View",
            searchPlaceHolder = "Search Wikipedia",
            saved = "Saved",
            emptyMessage = "No saved pages yet";


    public AndroidWikiApp skipLanguage() {
        step("Пропустить первичную настройку", () ->
                $(AppiumBy.id(skipButton)).click());

        return this;
    }

    public AndroidWikiApp searchInput(String request) {
        step("Вставить \"" + request + "\" в строку поиска", () -> {
            $(AppiumBy.accessibilityId(searchPlaceHolder)).click();
            $(AppiumBy.id(inputField)).sendKeys(request);
        });

        return this;
    }

    public AndroidWikiApp chooseFirst() {
        step("Выбираем первую найденую статью", () ->
                $$(AppiumBy.id(listOfResponse))
                        .first().click());
        return this;
    }

    public AndroidWikiApp nextSlide() {
        step("Нажать на кнопку \"Continue\"", () ->
                $(AppiumBy.id(nextButton)).click());
        return this;
    }

    public AndroidWikiApp finalSlide() {
        step("Нажать на кнопку \"Get Started\"", () ->
                $(AppiumBy.id(doneButton)).click());
        return this;
    }

    public AndroidWikiApp goToSaves() {
        step("Перейти на страницу с сохранёнными статьями", () ->
                $(AppiumBy.accessibilityId(saved)).click());
        return this;
    }

    public AndroidWikiApp tapNegativeButton() {
        step("Нажать на кнопку \"Not Now\"", () ->
                $(AppiumBy.id(negativeButton)).click());

        return this;
    }

    public void checkEmptiness() {
        step("Проверить, что нет сохранённых статей", () ->
                $(AppiumBy.id(emptyTitle)).shouldHave(text(emptyMessage)));
    }

    public AndroidWikiApp checkPrimary(String text) {
        step("Проверяем, что имеется текст: " + text, () ->
                $(AppiumBy.id(primaryView)).shouldHave(text(text)));
        return this;
    }

    public void searchExisting() {
        step("Появилась строка поиска", () ->
        $(AppiumBy.accessibilityId(searchPlaceHolder)).shouldBe(exist));
    }

    public void greaterThanZero() {
        step("Проверяем, что иммется не менее одного результата", () ->
                $$(AppiumBy.id(listOfResponse))
                        .shouldHave(sizeGreaterThan(0)));
    }

    public void findCurrentText(String request) {
        step("В статье содержится текст запроса", () ->
                $(AppiumBy.className("android.webkit.WebView")).$(AppiumBy.className("android.webkit.WebView")).shouldHave(text(request)));
    }
}
