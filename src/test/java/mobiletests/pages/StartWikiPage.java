package mobiletests.pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class StartWikiPage {
    private final String skipButton = "org.wikipedia.alpha:id/fragment_onboarding_skip_button",
            nextButton = "org.wikipedia.alpha:id/fragment_onboarding_forward_button",
            doneButton = "org.wikipedia.alpha:id/fragment_onboarding_done_button",
            primaryView = "org.wikipedia.alpha:id/primaryTextView";

    public StartWikiPage skipLanguage() {
        step("Пропустить первичную настройку", () ->
                $(AppiumBy.id(skipButton)).click());

        return this;
    }

    public StartWikiPage nextSlide() {
        step("Нажать на кнопку \"Continue\"", () ->
                $(AppiumBy.id(nextButton)).click());
        return this;
    }

    public StartWikiPage finalSlide() {
        step("Нажать на кнопку \"Get Started\"", () ->
                $(AppiumBy.id(doneButton)).click());
        return this;
    }


    public StartWikiPage checkPrimary(String text) {
        step("Проверяем, что имеется текст: " + text, () ->
                $(AppiumBy.id(primaryView)).shouldHave(text(text)));
        return this;
    }
}