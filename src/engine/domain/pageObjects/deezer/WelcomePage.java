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

    private final Locatable lyricsTab =
            new Locatable(SearchBy.XPATH, "(//*[@class='homepage-discover-link'])[3]",
                    "Lyrics tab");

    private final Locatable channelTab =
            new Locatable(SearchBy.XPATH, "(//*[@class='homepage-discover-link'])[2]",
                    "Channel tab");

    private final Locatable offlineModeTab =
            new Locatable(SearchBy.XPATH, "//*[@class='homepage-discover-link']",
                    "Offline mode tab");

    private final Locatable eQTab =
            new Locatable(SearchBy.XPATH, "(//*[@class='homepage-discover-link'])[4]",
                    "Emotional Intelligence tab");

    private final Locatable offlineModeTabText =
            new Locatable(SearchBy.XPATH, "//*[@class='visible']",
                    "Text from Offline mode block");

    private final Locatable channelText =
            new Locatable(SearchBy.XPATH, "//*[@class='visible']",
                    "Text from Channel block");

    private final Locatable lyricsText =
            new Locatable(SearchBy.XPATH, "//*[@class='visible']",
                    "Text from Lyrics block");

    private final Locatable eQText =
            new Locatable(SearchBy.XPATH, "//*[@class='visible']",
                    "Text from Lyrics block");

    private final Locatable russianLanguage =
            new Locatable(SearchBy.XPATH, "//*[@value='ru']", "Russian Language of interface");

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

    public boolean isOfflineModeTextCorrect() {
        return driver.isElementDisplayed(offlineModeTabText);
    }

    public String getChanelTabText() {
        return driver.getText(offlineModeTabText);

    }

    public String getLyricsTabText() {
        return driver.getText(lyricsText);

    }

    public String getEqTabText() {
        return driver.getText(eQText);

    }

    public WelcomePage clickOnChannelTab() {
        driver.click(channelTab, null, true);
        return this;
    }

    public WelcomePage clickOnLyricsTab() {
        driver.click(lyricsTab, null, true);
        return this;
    }

    public WelcomePage clickOnEqTab() {
        driver.click(eQTab, null, true);
        return this;
    }
}
