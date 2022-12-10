package mobiletests.tests.mobiletests;

import mobiletests.pages.MainWikiPage;
import mobiletests.pages.SearchWikiPage;
import mobiletests.pages.StartWikiPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("All")
@Tag("Search")
@DisplayName("Тесты для приложения Wikipedia")
public class SearchWikiTests extends TestBase{
    private final String request = "Quality assurance";

    StartWikiPage startPage = new StartWikiPage();
    SearchWikiPage searchPage = new SearchWikiPage();
    MainWikiPage mainPage = new MainWikiPage();

    @DisplayName("Проверка, что поиск выдаёт хотя бы одну статью по запросу")
    @Test
    void searchTest() {
        startPage
                .skipLanguage();
        mainPage
                .searchInput(request);
        searchPage
                .greaterThanZero();
    }

    @DisplayName("Проверка того, что первая выводимая статья та, что нужна по запросу")
    @Test
    void searchArticleTest() {
        startPage
                .skipLanguage();
        mainPage
                .searchInput(request);
        searchPage
                .chooseFirst()
                .findCurrentText(request);
    }

}
