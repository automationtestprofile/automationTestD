package engine.domain.pageObjects.deezer.Controllers;

import engine.Driver;
import engine.Locatable;
import engine.domain.pageObjects.deezer.LoginPage;
import engine.domain.pageObjects.deezer.OffersPage;
import engine.domain.pageObjects.deezer.SingUpPage;
import engine.enums.SearchBy;

public class LoginHeader {
    public static Driver driver = new Driver();

    private final Locatable returnToMainPageButton =
            new Locatable(SearchBy.ID, "topbar-deezer-logo", "Button for returning to the main page" );

    private final Locatable goToRatesButton =
            new Locatable(SearchBy.ID, "topbar-link-offers", "Button for navigating on rates page" );

    private final Locatable loginButton =
            new Locatable(SearchBy.ID, "topbar-login-button", "Button for navigate to login page" );

    private final Locatable registrationButton =
            new Locatable(SearchBy.ID, "topbar-register-button",
                    "Button for navigate to registration page" );

    public LoginPage navigateToSignIn(){
        driver.click(loginButton, null, true);
        return new LoginPage();
    }
    public SingUpPage navigateToSignUp(){
        driver.click(registrationButton, null, true);
        return new SingUpPage();
    }
    public OffersPage navigateToOfferPage(){
        driver.click(goToRatesButton, null, true);
        return new OffersPage();
    }



}
