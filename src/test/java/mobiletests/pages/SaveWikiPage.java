package mobiletests.pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SaveWikiPage {

    public SaveWikiPage tapNegativeButton() {
        String negativeButton = "org.wikipedia.alpha:id/negativeButton";

        step("Нажать на кнопку \"Not Now\"", () ->
                $(AppiumBy.id(negativeButton)).click());

        return this;
    }

    public void checkEmptiness() {
        String emptyTitle = "org.wikipedia.alpha:id/empty_title",
                emptyMessage = "No saved pages yet";

        step("Проверить, что нет сохранённых статей", () ->
                $(AppiumBy.id(emptyTitle)).shouldHave(text(emptyMessage)));
    }
}
