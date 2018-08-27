package tests.deezer;

import engine.domain.Navigate;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.UiTestRunner;

public class WelcomeTests extends UiTestRunner {
    @Test
    public final void changeLanguage(){
        String welcomeParagraphTest = "Слушайте вашу музыку без ограничений. Всегда и везде.";

        String changeLanguage;
        changeLanguage = Navigate
                .navigateToDeezerApp()
                .acceptUsageCookies()
                .scrollToChooseLanguage()
                .changeLanguage()
                .getWelcomeText();
        Assert.assertEquals(changeLanguage , welcomeParagraphTest);
    }
}
