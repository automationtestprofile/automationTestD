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

    private final  Locatable test =
            new Locatable(SearchBy.XPATH, "//option[@value='ru']",
                    "Icon for navigate to facebook page");

    private final Locatable agreeWithCookiesButton =
            new Locatable(SearchBy.CLASSNAME, "cookie-right",
                    "Accept cookies usage button");

    private final Locatable russianLanguage =
            new Locatable(SearchBy.XPATH, "//*[@id=\"language_select\"]/option[19]", "Russian Language of interface");

    private final Locatable welcomeText =
            new Locatable(SearchBy.CLASSNAME, "hero-block-heading-1", "First Welcome Paragraph");

    public WelcomePage acceptUsageCookies()
    {
        driver.click(agreeWithCookiesButton, null, true);
                return this;
    }

    public WelcomePage scrollToChooseLanguage(){
        scrollToElement(languageSelector);
        return this;
    }

    private WelcomePage clickOnLanguageList(){
        driver.click(languageSelector, null, true);
        return this;
    }

    private WelcomePage selectRussian(){
        driver.click(russianLanguage, null, true);
        return this;
    }

    public String getWelcomeText()
    {
        return driver.getText(welcomeText);
    }

    public WelcomePage changeLanguage()
    {
        return clickOnLanguageList()
                .selectRussian();
    }

}
