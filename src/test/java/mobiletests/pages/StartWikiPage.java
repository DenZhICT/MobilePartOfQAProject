package mobiletests.pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class StartWikiPage {

    public StartWikiPage skipLanguage() {
        String skipButton = "org.wikipedia.alpha:id/fragment_onboarding_skip_button";

        step("Пропустить первичную настройку", () ->
                $(AppiumBy.id(skipButton)).click());

        return this;
    }

    public StartWikiPage nextSlide() {
        String nextButton = "org.wikipedia.alpha:id/fragment_onboarding_forward_button";

        step("Нажать на кнопку \"Continue\"", () ->
                $(AppiumBy.id(nextButton)).click());
        return this;
    }

    public StartWikiPage finalSlide() {
        String doneButton = "org.wikipedia.alpha:id/fragment_onboarding_done_button";

        step("Нажать на кнопку \"Get Started\"", () ->
                $(AppiumBy.id(doneButton)).click());
        return this;
    }


    public StartWikiPage checkPrimary(String text) {
        String primaryView = "org.wikipedia.alpha:id/primaryTextView";

        step("Проверяем, что имеется текст: " + text, () ->
                $(AppiumBy.id(primaryView)).shouldHave(text(text)));
        return this;
    }
}