package engine.domain.pageObjects.deezer;

import engine.Driver;
import engine.Locatable;
import engine.domain.pageObjects.deezer.Controllers.LoginHeader;
import engine.enums.SearchBy;

public class LoginPage extends LoginHeader {

    public static Driver driver = new Driver();

    private final Locatable facebookButton =
            new Locatable(SearchBy.XPATH, "//span[text()='Facebook']",
                    "Button for navigate to login via facebook");

    private final Locatable confirmMailTo =
            new Locatable(SearchBy.ID, "reset_confirm_mailto", "Mail confirm");

    public final Locatable mailField =
            new Locatable(SearchBy.ID, "login_mail", "Field for entering user`s mail");

    public final Locatable passwordField =
            new Locatable(SearchBy.ID, "login_password", "Field for entering user`s password");

    public final Locatable loginSubmitButton =
            new Locatable(SearchBy.ID, "login_form_submit", "Button for Sing in to account");

    public final Locatable forgetPasswordLink =
            new Locatable(SearchBy.XPATH, "//span[text()='Forgotten your password?']",
                    "Link to form for recovering password");

    public final Locatable registrationLink =
            new Locatable(SearchBy.XPATH, "(//a[text()='Sign up'])[2]",
                    "Link to registration page");

    public final Locatable loginFormContainer =
            new Locatable(SearchBy.ID, "login_form",
                    "Mail and password form containers");

    public final Locatable resetPasswordContainer =
            new Locatable(SearchBy.ID, "reset_first",
                    "Container for reset password");

    public final Locatable resetPasswordSuccessContainer =
            new Locatable(SearchBy.ID, "reset_second",
                    "Container that appears after sending email for reset");

    public final Locatable resetEmailField =
            new Locatable(SearchBy.ID, "reset_mail",
                    "Field for email");

    public final Locatable emailSingInField =
            new Locatable(SearchBy.ID, "login_mail",
                    "Email field on Sing in Page");

    public final Locatable passwordSingInField =
            new Locatable(SearchBy.ID, "login_password",
                    "Password field on Sing in Page");

    public final Locatable resetSubmitButton =
            new Locatable(SearchBy.ID, "reset_password_submit",
                    "Submit reset button");

    public final Locatable logInSubmitButton =
            new Locatable(SearchBy.ID, "login_form_submit",
                    "Login button");

    public final Locatable successMailMessageRecieved =
            new Locatable(SearchBy.XPATH, "//div[contains(text(),'got mail')]",
                    "Message about successful reseting email");

    public final Locatable wrongLogInDataMessage =
            new Locatable(SearchBy.XPATH, "//div[contains(text(),'Your details are incorrect. Please try again.')]",
                    "Message about no valid data enter to Login form");

    //resetPassword(string email)
    public LoginPage navigateToResetButton() {
        driver.click(resetSubmitButton, null, true);
        return this;
    }

    //clickForgerPassword
    public LoginPage navigateToForgetPasswordLink() {
        driver.click(forgetPasswordLink, null, true);
        return this;
    }

    public LoginPage navigateToSubmitResetMail() {
        driver.click(resetSubmitButton, null, true);
        return this;
    }

    private MainPage clickSingInButton() {
        driver.click(logInSubmitButton, null, true);
        return new MainPage();
    }
    public LoginPage navigateToSubmtLogInButton() {
        driver.click(logInSubmitButton, null, true);
        return new LoginPage();
    }

    public boolean isLoginFormContainerIsPresent() {
        return driver.isElementDisplayed(loginFormContainer);
    }

    public boolean isResetContainerIsVisible() {
        return driver.isElementDisplayed(resetPasswordContainer);
    }

    private LoginPage setEmail(String userEmail) {
        driver.setText(emailSingInField, userEmail, true);
        return this;
    }

    private LoginPage setPassword(String userPassword) {
        driver.setText(passwordSingInField, userPassword, true);
        return this;
    }

    public LoginPage emailReset(String userEmail) {
        driver.setText(resetEmailField, userEmail, true);
        return this;
    }

    public boolean isResetSuccessfullContainerIsPresent() {
        return driver.isElementDisplayed(resetPasswordSuccessContainer);
    }

    public boolean isMessageAboutNotCorrectDataIsPresent(){
        return driver.isElementDisplayed(wrongLogInDataMessage);
    }

    public String resetConfirmation() {
        return driver.getText(confirmMailTo);
    }

    public String messageRecieved() {
        return driver.getText(successMailMessageRecieved);
    }

    public MainPage login (String userEmail, String userPassword){
//        setEmail(userEmail);
//        setPassword(userPassword);
//        clickSingInButton();
//        return new MainPage();

        //!
       return setEmail(userEmail)
                .setPassword(userPassword)
                .clickSingInButton();
    }

    //?
    public LoginPage setWrongPassword (String userEmail, String userWrongPassword){
        setEmail(userEmail);
        setPassword(userWrongPassword);
        clickSingInButton();

        return this;
    }
}