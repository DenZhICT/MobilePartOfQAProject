package mobiletests.tests.mobiletests;

import mobiletests.app.AndroidWikiApp;
import mobiletests.base.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("All")
@DisplayName("Тесты для приложения Wikipedia")
public class WikiTests extends TestBase {

    private final String request = "Quality assurance";
    AndroidWikiApp wikiApp = new AndroidWikiApp();

    @Tag("Search")
    @DisplayName("Проверка, что поиск выдаёт хотя бы одну статью по запросу")
    @Test
    void searchTest() {
        wikiApp
                .skipLanguage()
                .searchInput(request)
                .greaterThanZero();
    }

    @Tag("Search")
    @DisplayName("Проверка того, что первая выводимая статья та, что нужна по запросу")
    @Test
    void searchArticleTest() {
        wikiApp
                .skipLanguage()
                .searchInput(request)
                .chooseFirst()
                .findCurrentText(request);
    }

    @Tag("GetStarted")
    @DisplayName("Проверка каждой страницы первичной настройки")
    @Test
    void doNotSkippedOnBoardingTest() {
        wikiApp.checkPrimary("The Free Encyclopedia\n…in over 300 languages")
                .nextSlide()
                .checkPrimary("New ways to explore")
                .nextSlide()
                .checkPrimary("Reading lists with sync")
                .nextSlide()
                .checkPrimary("Send anonymous data")
                .finalSlide()
                .searchExisting();
    }

    @Tag("Save")
    @DisplayName("Проверка пустотности сохранённых статей")
    @Test
    void emptySavesEmpty() {
        wikiApp
                .skipLanguage()
                .goToSaves()
                .tapNegativeButton()
                .checkEmptiness();
    }
}
