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

    public final Locatable submitloginButton =
            new Locatable(SearchBy.ID, "login_form_submit",
                    "Login button");

    public final Locatable resetMessageSuccess =
            new Locatable(SearchBy.XPATH, "//div[contains(text(),'got mail')]",
                    "Message about successful reset email");

    public final Locatable wrongLoginDataMessage =
            new Locatable(SearchBy.XPATH, "//div[contains(text(),'Your details are incorrect. Please try again.')]",
                    "Message about no valid data enter to Login form");



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
    private MainPage submitloginButton() {
        driver.click(submitloginButton, null, true);
        return new MainPage();
    }
    //find out
    public LoginPage clickLoginButton() {
        driver.click(submitloginButton, null, true);
        return new LoginPage();
    }

    public boolean isLoginFormContainerIsPresent() {
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

    public LoginPage emailReset(String userEmail) {
        driver.setText(resetEmailField, userEmail, true);
        return this;
    }

    public boolean isResetSuccessfullContainerIsPresent() {
        return driver.isElementDisplayed(successResetPasswordContainer);
    }

    public boolean isMessageAboutNotCorrectDataIsPresent(){
        return driver.isElementDisplayed(wrongLoginDataMessage);
    }

    public String resetConfirmation() {
        return driver.getText(confirmedMail);
    }

    public String messageRecieved() {
        return driver.getText(resetMessageSuccess);
    }

    public MainPage login (String userEmail, String userPassword){

       return setEmail(userEmail)
                .setPassword(userPassword)
                .submitloginButton();
    }

    public LoginPage setWrongPassword (String userEmail, String userWrongPassword){
        setEmail(userEmail);
        setPassword(userWrongPassword);
        submitloginButton();

        return this;
    }


}