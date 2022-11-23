package mobileTests.base;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import mobileTests.config.MobileLocalDriverProvider;
import mobileTests.config.MobileRemoteDriverProvider;
import mobileTests.helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestBase {

    @BeforeAll
    static void configure() throws Exception {

        String env = System.getProperty("environment");
        if (env == null) {
            env = "local";
        }
        switch (env) {
            case "local":
                new MobileLocalDriverProvider().setMobileDriverConfiguration();
                break;
            case "remote":
                new MobileRemoteDriverProvider().setMobileDriverConfiguration();
                break;
            default:
                throw new Exception("Wrong environment");
        }
    }

    @BeforeEach()
    void kludge() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        open();
    }

    @AfterEach
    void addAttachments() {

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        String env = System.getProperty("environment");
        if (env != null && env.equals("remote")) {
            String sessionId = sessionId().toString();
            step("Закрываем драйвер", () ->
                    closeWebDriver());
            Attach.addVideo(sessionId);
        } else {
            step("Закрываем драйвер", () ->
                    closeWebDriver());
        }
    }
}
