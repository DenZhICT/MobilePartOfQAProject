package mobiletests.pages;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class SearchWikiPage {
    private final String listOfResponse = "org.wikipedia.alpha:id/page_list_item_title",
            webView = "android.webkit.WebView";

    public SearchWikiPage chooseFirst() {
        step("Выбираем первую найденую статью", () ->
                $$(AppiumBy.id(listOfResponse))
                        .first().click());
        return this;
    }

    public void greaterThanZero() {
        step("Проверяем, что иммется не менее одного результата", () ->
                $$(AppiumBy.id(listOfResponse))
                        .shouldHave(sizeGreaterThan(0)));
    }

    public void findCurrentText(String request) {
        step("В статье содержится текст запроса", () ->
                $(AppiumBy.className(webView)).$(AppiumBy.className(webView)).shouldHave(text(request)));
    }
}
