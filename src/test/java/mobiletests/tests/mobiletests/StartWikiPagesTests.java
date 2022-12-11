package mobiletests.tests.mobiletests;

import mobiletests.pages.MainWikiPage;
import mobiletests.pages.StartWikiPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("All")
@Tag("GetStarted")
@DisplayName("Тесты для приложения Wikipedia")
public class StartWikiPagesTests extends TestBase{

    @DisplayName("Проверка каждой страницы первичной настройки")
    @Test
    void doNotSkippedOnBoardingTest() {
        StartWikiPage startPage = new StartWikiPage();
        MainWikiPage mainPage = new MainWikiPage();

        startPage
                .checkPrimary("The Free Encyclopedia\n…in over 300 languages")
                .nextSlide()
                .checkPrimary("New ways to explore")
                .nextSlide()
                .checkPrimary("Reading lists with sync")
                .nextSlide()
                .checkPrimary("Send anonymous data")
                .finalSlide();
        mainPage.searchExisting();
    }
}
