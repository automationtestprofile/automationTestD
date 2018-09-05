package tests.deezer;

import engine.domain.Navigate;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.UiTestRunner;

public class WelcomeTests extends UiTestRunner {
    @Test
    public final void changeLanguage() {
        String welcomeParagraphTest = "Слушайте вашу музыку без ограничений. Всегда и везде.";

        String changeLanguage;
        changeLanguage = Navigate
                .navigateToDeezerApp()
                .acceptUsageCookies()
                .scrollToChooseLanguage()
                .changeLanguage()
                .getWelcomeText();
        Assert.assertEquals(changeLanguage, welcomeParagraphTest);
    }

    @Test
    public final void isOfflineModeTextIsCorrect() {
        boolean isOfflineModeTextCorrect = Navigate
                .navigateToDeezerApp()
                .acceptUsageCookies()
                .scrollToOfflineModeTest()
                .isOfflineModeTextCorrect();
        Assert.assertTrue(isOfflineModeTextCorrect);
    }

    @Test
    public final void isChanelTabTestIsCorrect() {
        String chanelTabText = "Browse curated collections of music and podcasts by genre to discover new classics and hidden gems.";
        String actualChanelTabText = Navigate
                .navigateToDeezerApp()
                .acceptUsageCookies()
                .scrollToOfflineModeTest()
                .clickOnChannelTab()
                .getChanelTabText();
        Assert.assertEquals(actualChanelTabText, chanelTabText);
    }

    @Test
    public final void isLyricsTabTestIsCorrect() {
        String lyricsTabText = "The days of pretending you know the words are over! See the lyrics to all your favourites " +
                "on-screen and never sing \"sweet dreams are made of cheese\" again.";
        String actualLyricsTabText = Navigate
                .navigateToDeezerApp()
                .acceptUsageCookies()
                .scrollToOfflineModeTest()
                .clickOnLyricsTab()
                .getLyricsTabText();
        Assert.assertEquals(lyricsTabText, actualLyricsTabText);
    }

    @Test
    public final void isEqTabTestIsCorrect() {
        String eqTabText = "Tweak the equalizer and hear your music exactly like you like it.";
        String actualEqTabText = Navigate
                .navigateToDeezerApp()
                .acceptUsageCookies()
                .scrollToOfflineModeTest()
                .clickOnEqTab()
                .getEqTabText();
        Assert.assertEquals(eqTabText, actualEqTabText);
    }
}
