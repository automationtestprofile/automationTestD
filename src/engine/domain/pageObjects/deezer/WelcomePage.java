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
            new Locatable(SearchBy.CLASSNAME, "btn btn-primary btn-block", "Dropdown with languages");


    public WelcomePage scroll(){

    scrollToElement(languageSelector);
        return this;
    }
    public boolean isScrolledElementVisible(){return  driver.isElementDisplayed(languageSelector);}

}
