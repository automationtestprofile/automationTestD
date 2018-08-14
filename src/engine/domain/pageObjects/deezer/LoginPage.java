package engine.domain.pageObjects.deezer;

import engine.Driver;
import engine.Locatable;
import engine.domain.pageObjects.deezer.Controllers.LoginHeader;
import engine.enums.SearchBy;

public class LoginPage extends LoginHeader {
    public static Driver driver = new Driver();

    public static String userEmail = "mrs.tester.tested@gmail.com";
    public static String userPassword = "P@ssw0rd";

    private final Locatable facebookButton =
            new Locatable(SearchBy.XPATH, "//span[text()='Facebook']",
                    "Button for navigate to login via facebook");
    private final Locatable confirmMailTo =
            new Locatable(SearchBy.ID, "reset_confirm_mailto", "Mail confirm");

    private final Locatable facebookPopUp =
            new Locatable(SearchBy.CLASSNAME,
                    "login_form_label", "Popup conteiner for login via Facebook");

    public final Locatable googleButton =
            new Locatable(SearchBy.XPATH, "//span[text()='Google']",
                    "Button for navigate to login via gmail mail");

    public final Locatable mailField =
            new Locatable(SearchBy.ID, "login_mail", "Field for entering user`s mail");

    public final Locatable passwordField =
            new Locatable(SearchBy.ID, "login_password", "Field for enteting user`s password");

    public final Locatable enterButton =
            new Locatable(SearchBy.ID, "login_form_submit", "Button for enter to account");

    public final Locatable forgetPasswordLink =
            new Locatable(SearchBy.XPATH, "//span[text()='Forgotten your password?']",
                    "Link to form for recovering password");

    public final Locatable registrationLink =
            new Locatable(SearchBy.XPATH, "(//a[text()='Регистрация'])[2]", "Link to registration page");

    public final Locatable loginFormContainer =
            new Locatable(SearchBy.ID, "login_form", "Mail and password form containers");

    public final Locatable resetPasswordContainer =
            new Locatable(SearchBy.ID, "reset_first", "Container for reset password");
    public final Locatable resetPasswordSuccseesContainer =
            new Locatable(SearchBy.ID, "reset_second",
                    "Container with inforation about sucssedful reset password");
    public final Locatable resetEmailField =
            new Locatable(SearchBy.ID, "reset_mail", "Field for email");
    public final Locatable emailSingInField =
            new Locatable(SearchBy.ID, "login_mail", "Email field on Sing in Page");
    public final Locatable passwordSingInField =
            new Locatable(SearchBy.ID, "login_password", "Password field on Sing in Page");
    public final Locatable resetSubmitButton =
            new Locatable(SearchBy.ID, "reset_password_submit", "Submit reset button");

    public final Locatable logInSubmitButton =
            new Locatable(SearchBy.ID, "login_form_submit", "Login button");

    public boolean isLoginFormContainerIsPresent() {
        return driver.isElementDisplayed(loginFormContainer);
    }

    public final Locatable successMailMessageRecieved =
            new Locatable(SearchBy.XPATH, "//div[contains(text(),'got mail')]",
                    "Message about successfull reseting email");

    public boolean isPopUpFacebookIsPresentForSingIn() {
        return driver.isElementDisplayed(facebookPopUp);
    }

    public LoginPage navigateToResetButton() {
        driver.click(resetSubmitButton, null, true);
        return new LoginPage();
    }

    public LoginPage navigateToFacebookButton() {
        driver.click(facebookButton, null, true);
        return new LoginPage();
    }

    public LoginPage navigateToForgetPasswordLink() {
        driver.click(forgetPasswordLink, null, true);
        return new LoginPage();
    }

    public LoginPage navigateToSubmitResetMail() {
        driver.click(resetSubmitButton, null, true);
        return new LoginPage();
    }

    public LoginPage navigateToSubmtLogInButton() {
        driver.click(logInSubmitButton, null, true);
        return new LoginPage();
    }

    public boolean isResetContainerIsVisible() {
                return driver.isElementDisplayed(resetPasswordContainer);
    }

    public LoginPage setTextToEmailFiledSingInPAge() {
        driver.setText(emailSingInField, userEmail, true);
        return new LoginPage();
    }

    public LoginPage setTextToPasswordSingInFiled() {
        driver.setText(passwordSingInField, userPassword, true);
        return new LoginPage();
    }

    public LoginPage setTextToResetEmailFiled() {
        driver.setText(resetEmailField, userEmail, true);
        return new LoginPage();
    }


    public boolean isResetSuccessfullContainerIsPresent() {
        return driver.isElementDisplayed(resetPasswordSuccseesContainer);
    }

    public String getTextAboutConfirm() {
        return driver.getText(confirmMailTo);
    }

    public String gerTextFromMessageReceived() {
        return driver.getText(successMailMessageRecieved);
    }

    public MainPage navigateToSubmitSingInButton() {
        driver.click(logInSubmitButton, null, true);
        return new MainPage();
    }
}