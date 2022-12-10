package mobiletests.tests.mobiletests;

import mobiletests.pages.MainWikiPage;
import mobiletests.pages.SaveWikiPage;
import mobiletests.pages.StartWikiPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("All")
@Tag("Save")
@DisplayName("Тесты для приложения Wikipedia")
public class SaveWikiTests extends TestBase{

    @DisplayName("Проверка пустотности сохранённых статей")
    @Test
    void emptySavesEmpty() {
        StartWikiPage startPage = new StartWikiPage();
        MainWikiPage mainPage = new MainWikiPage();
        SaveWikiPage savePage = new SaveWikiPage();

        startPage
                .skipLanguage();
        mainPage
                .goToSaves();
        savePage
                .tapNegativeButton()
                .checkEmptiness();
    }
}
