package engine.domain.pageObjects.deezer;

import engine.Driver;
import engine.Locatable;
import engine.domain.pageObjects.deezer.Controllers.LoginHeader;
import engine.enums.SearchBy;

import static engine.Driver.scrollToElement;

public class LoginPage extends LoginHeader {

    public static Driver driver = new Driver();

    private final Locatable confirmedMail =
            new Locatable(SearchBy.ID, "reset_confirm_mailto",
                    "Email user on which confirm letter was sent");

    public final Locatable forgetPasswordLink =
            new Locatable(SearchBy.XPATH, "//span[text()='Forgotten your password?']",
                    "Link to form for recovering password");

    public final Locatable loginFormContainer =
            new Locatable(SearchBy.ID, "login_form",
                    "Form for login");

    public final Locatable resetPasswordContainer =
            new Locatable(SearchBy.ID, "reset_first",
                    "Container for reset password via sending new password on user Mail");

    public final Locatable successResetPasswordContainer =
            new Locatable(SearchBy.ID, "reset_second",
                    "Container that appears after sending email for reset");

    public final Locatable resetEmailField =
            new Locatable(SearchBy.ID, "reset_mail",
                    "Field for email in Reset container");

    public final Locatable emailLoginField =
            new Locatable(SearchBy.ID, "login_mail",
                    "Email field on Login Page");

    public final Locatable passwordLoginField =
            new Locatable(SearchBy.ID, "login_password",
                    "Password field on Login Page");

    public final Locatable clickResetButton =
            new Locatable(SearchBy.ID, "reset_password_submit",
                    "Submit reset button");

    public final Locatable submitLoginButton =
            new Locatable(SearchBy.ID, "login_form_submit",
                    "Login button");

    public final Locatable confirmationResetMessage =
            new Locatable(SearchBy.XPATH, "//div[contains(text(),'got mail')]",
                    "Reset email confirmation message");

    public final Locatable wrongLoginDataMessage =
            new Locatable(SearchBy.XPATH, "//div[contains(text(),'Your details are incorrect. Please try again.')]",
                    "Message about invalid data enter to Login form");



    //resetPassword(string email)
    public LoginPage clickResetButton() {
        driver.click(clickResetButton, null, true);
        return this;
    }

    //clickForgerPassword
    public LoginPage clickForgetPassword() {
        driver.click(forgetPasswordLink, null, true);
        return this;
    }
    //find out
    private MainPage submitLogin() {
        driver.click(submitLoginButton, null, true);
        return new MainPage();
    }

    private LoginPage submitLoginWithInvalidPassword() {
        driver.click(submitLoginButton, null, true);
        return this;
    }
    //find out
    public LoginPage clickLoginButton() {
        driver.click(submitLoginButton, null, true);
        return new LoginPage();
    }

    public boolean isLoginFormIsPresent() {
        return driver.isElementDisplayed(loginFormContainer);
    }

    public boolean isResetContainerIsVisible() {
        return driver.isElementDisplayed(resetPasswordContainer);
    }

    private LoginPage setEmail(String userEmail) {
        driver.setText(emailLoginField, userEmail, true);
        return this;
    }

    private LoginPage setPassword(String userPassword) {
        driver.setText(passwordLoginField, userPassword, true);
        return this;
    }

    public LoginPage setEmailToReset(String userEmail) {
        driver.setText(resetEmailField, userEmail, true);
        return this;
    }

    public boolean isResetSuccessfullContainerIsPresent() {
        return driver.isElementDisplayed(successResetPasswordContainer);
    }

    public boolean isIncorrectDataMessageIsPresent(){
        return driver.isElementDisplayed(wrongLoginDataMessage);
    }

    public String getWrongLoginMessage(){
        return driver.getText(wrongLoginDataMessage);
    }

    public String getEmailInResetDialogWindow() {
        return driver.getText(confirmedMail);
    }

    public String getResetConfirmationMessage() {
        return driver.getText(confirmationResetMessage);
    }

    public MainPage login (String userEmail, String userPassword){

       return setEmail(userEmail)
                .setPassword(userPassword)
                .submitLogin();
    }

    public LoginPage loginWithInvalidPassword (String userEmail, String invalidPassword){
      return setEmail(userEmail)
              .setPassword(invalidPassword)
              .submitLoginWithInvalidPassword();
    }

    public LoginPage resetPassword (String userEmail){
        return clickForgetPassword()
                .setEmailToReset(userEmail)
                .clickResetButton();
    }


}