package engine.domain.pageObjects.deezer;

import engine.Driver;
import engine.Locatable;
import engine.domain.pageObjects.deezer.Controllers.LoginHeader;
import engine.enums.SearchBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;


import static engine.Driver.getInstance;
import static engine.Driver.scrollToElement;

public class WelcomePage extends LoginHeader {
    public static Driver driver = new Driver();

    private final Locatable tryPremiumPlusButton =
            new Locatable(SearchBy.XPATH, "(//span[text()='Попробуйте Premium+'])[1]",
                    "Try premium+ button");
    private final Locatable welcomeTitleText =
            new Locatable(SearchBy.CLASSNAME, "hero-block-heading-1",
                    "Welcome text on Main Page");
    public final Locatable languageSelector =
            new Locatable(SearchBy.CLASSNAME, "lang-label", "Dropdown with languages");

    private final Locatable test =
            new Locatable(SearchBy.XPATH, "//option[@value='ru']",
                    "Icon for navigate to facebook page");

    private final Locatable agreeWithCookiesButton =
            new Locatable(SearchBy.CLASSNAME, "cookie-right",
                    "Accept cookies usage button");

    private final Locatable lyrics =
            new Locatable(SearchBy.XPATH, "//*[contains(text(),'Lyrics')]",
                    "Lyrics tab");

    private final Locatable channel =
            new Locatable(SearchBy.XPATH, "//*[contains(text(),'Channel')]",
                    "Channel tab");

    private final Locatable offlineModeTab =
            new Locatable(SearchBy.XPATH, "//*[contains(text(),'Offline mode')]",
                    "Offline mode tab");

    private final Locatable eQ =
            new Locatable(SearchBy.XPATH, "//*[contains(text(),'EQ')]",
                    "Emotional Intelligence tab");

    private final Locatable offlineModeTabText =
            new Locatable(SearchBy.XPATH, "//*[contains(text(),'Download your favourite songs, playlists and " +
                    "albums on WiFi then find them all in one place to listen to later. ')], " ,
                    "Text from Offline mode block");

    private final Locatable channelText =
            new Locatable(SearchBy.XPATH, "//*[contains(text(),'Browse curated collections of music and " +
                    "podcasts by genre to discover new classics and hidden gems.')], " ,
                    "Text from Channel block");

    private final Locatable lyricsText =
            new Locatable(SearchBy.XPATH, "//*[contains(text(),'The days of pretending you know the words are " +
                    "over! See the lyrics to all your favourites on-screen and never sing" +
                    " \"sweet dreams are made of cheese\" again.')], " ,
                    "Text from Lyrics block");

    private final Locatable eQText =
            new Locatable(SearchBy.XPATH, "//*[contains(text(),'Tweak the equalizer and hear your music exactly " +
                    "like you like it.')], " ,
                    "Text from Lyrics block");

    private final Locatable russianLanguage =
            new Locatable(SearchBy.XPATH, "//*[@id=\"language_select\"]/option[19]", "Russian Language of interface");

    private final Locatable welcomeText =
            new Locatable(SearchBy.CLASSNAME, "hero-block-heading-1", "First Welcome Paragraph");

    public WelcomePage acceptUsageCookies() {
        driver.click(agreeWithCookiesButton, null, true);
        return this;
    }

    public WelcomePage scrollToChooseLanguage() {
        scrollToElement(languageSelector);
        return this;
    }

    private WelcomePage clickOnLanguageList() {
        driver.click(languageSelector, null, true);
        return this;
    }

    private WelcomePage selectRussian() {
        driver.click(russianLanguage, null, true);
        return this;
    }

    public String getWelcomeText() {
        return driver.getText(welcomeText);
    }

    public WelcomePage changeLanguage() {
        return clickOnLanguageList()
                .selectRussian();
    }

    public WelcomePage scrollToOfflineModeTest() {
        scrollToElement(offlineModeTab);
        return this;
    }

    public boolean isOfflineModeTextCorrect(){return driver.isElementDisplayed(offlineModeTabText);}

    public boolean isChannelTextCorrect() {return driver.isElementDisplayed(channelText);}

    public boolean isLyricsTextCorrect() {return  driver.isElementDisplayed(lyricsText);}

    public boolean isEqTextCorrect() {return  driver.isElementDisplayed(eQText);}
}
