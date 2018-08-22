package tests.deezer;

import engine.Driver;
import engine.domain.Navigate;
import engine.domain.pageObjects.deezer.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.UiTestRunner;

import java.net.URL;

public class LoginTests extends UiTestRunner {
    public static String userEmail = "mrs.tester.tested@gmail.com";
    public static String userPassword = "P@ssw0rd";
    public static String userWrongPassword = "fake";

    @Test
    public final void loginFormIsPresent() {
        boolean isLoginFormPresent = Navigate
                .navigateToDeezerApp()
                .navigateToSignIn()
                .isLoginFormContainerIsPresent();
        Assert.assertTrue(isLoginFormPresent, "Login form should be visible on page");
    }

    @Test
    public final void singUpFormIsPresent() {
        boolean isSingUpFormIsPresent = Navigate
                .navigateToDeezerApp()
                .navigateToSignUp()
                .isSingUpContainerPresent();
        Assert.assertEquals(isSingUpFormIsPresent, true, "Sing up form should be visible on the page");
    }

    @Test
    public final void isOfferContainerPresent() {
        boolean isOfferContainerPresent = Navigate
                .navigateToDeezerApp()
                .navigateToOfferPage()
                .isOfferContainerVisible();
        Assert.assertTrue(isOfferContainerPresent, "Offer container should be visible on page");
    }

    @Test
    public final void isPasswordResetPresent() {
        boolean isPasswordResetPresent = Navigate
                .navigateToDeezerApp()
                .navigateToSignIn()
                .clickForgetPassword()
                .isResetContainerIsVisible();
        Assert.assertTrue(isPasswordResetPresent, "Reset form should be visible on page");
    }

    @Test
    public final void isPasswordResetIsSuccess() {
        String isPasswordResetIsSuccess = Navigate
                .navigateToDeezerApp()
                .navigateToSignIn()
                .clickForgetPassword()
                .emailReset(userEmail)
                .clickResetButton()
                .resetConfirmation();
        Assert.assertEquals(isPasswordResetIsSuccess, userEmail,
                "Password reset should be successful");
    }

    @Test
    public final void isMessageResetIsSuccess() {
        String isMessageResetIsSuccess = Navigate
                .navigateToDeezerApp()
                .navigateToSignIn()
                .clickForgetPassword()
                .emailReset(userEmail)
                .clickResetButton()
                .messageRecieved();
        Assert.assertEquals(isMessageResetIsSuccess, "You've got mail!");
    }

    @Test
    public final void isLoginIsSuccess() {
        boolean isLoginIsSuccess = Navigate
                .navigateToDeezerApp()
                .navigateToSignIn()
                .login(userEmail, userPassword)
                .isPlayerPresentOnMainPage();
        Assert.assertTrue(isLoginIsSuccess, "User should login");
    }

    @Test
    public final void isLoginIsFailed() {
        boolean isLoginIsSuccess = Navigate
                .navigateToDeezerApp()
                .navigateToSignIn()
                .setWrongPassword(userEmail, userWrongPassword)
                .isMessageAboutNotCorrectDataIsPresent();
        Assert.assertTrue(isLoginIsSuccess, "User should`nt login");
    }

    @Test
    public final void changeLanguage (){
        boolean isScroll;
        isScroll = Navigate
                .navigateToDeezerApp()
                .scroll()
                .isScrolledElementVisible();
        Assert.assertTrue(isScroll , "Scroll should works");
}

}
