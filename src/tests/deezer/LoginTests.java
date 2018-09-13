package tests.deezer;

import engine.domain.Navigate;
import engine.domain.pageObjects.deezer.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.UiTestRunner;

public class LoginTests extends UiTestRunner {
    public static String userEmail = "mrs.tester.tested@gmail.com";
    public static String userPassword = "P@ssw0rd";
    public static String userInvalidPassword = "fake";

    @Test(priority = 0)
    public final void loginFormIsPresent() {
        boolean isLoginFormPresent = Navigate
                .navigateToDeezerApp()
                .navigateToLoginPage()
                .isLoginFormIsPresent();
        Assert.assertTrue(isLoginFormPresent, "Login form should be visible on page");
    }
    @AfterTest


    @Test(priority = 1)
    public final void singUpFormIsPresent() {
        boolean isSingUpFormIsPresent = Navigate
                .navigateToDeezerApp()
                .navigateToSignUp()
                .isSingUpFormIsPresent();
        Assert.assertEquals(isSingUpFormIsPresent, true, "Sing up form should be visible on the page");
    }

    @Test(priority = 2)
    public final void isPasswordResetDialogWindowIsPresent() {
        boolean isPasswordResetDialogWindowIsPresent = Navigate
                .navigateToDeezerApp()
                .navigateToLoginPage()
                .clickForgetPassword()
                .isResetContainerIsVisible();
        Assert.assertTrue(isPasswordResetDialogWindowIsPresent, "Reset password dialog window should be " +
                "visible on page");
    }

    @Test(priority = 3)
    public final void checkEmailIsEqualToEnteredWhileReset() {
        String receivedEmail = Navigate
                .navigateToDeezerApp()
                .navigateToLoginPage()
                .resetPassword(userEmail)
                .getEmailInResetDialogWindow();
        Assert.assertEquals(receivedEmail, userEmail,
                "Received email should be equal to entered email in reset password process");
    }

    @Test(priority = 4)
    public final void isResetMessageIsCorrect() {
        String expectedResetConfirmationMessage = "You've got mail!";

        String resetConfirmationMessage = Navigate
                .navigateToDeezerApp()
                .navigateToLoginPage()
                .resetPassword(userEmail)
                .getResetConfirmationMessage();
        Assert.assertEquals(resetConfirmationMessage, expectedResetConfirmationMessage);
    }

    @Test
    public final void isLoginIsSuccess() {
        boolean isPlayerPresent = Navigate
                .navigateToDeezerApp()
                .navigateToLoginPage()
                .login(userEmail, userPassword)
                .isPlayerPresent();
        Assert.assertTrue(isPlayerPresent, "User should see player if login is success");

    }

    @Test
    public final void isLoginIsFailed() {
        String expectedMessage = "Your details are incorrect. Please try again.";

        String wrongLoginDataMessage = Navigate
                .navigateToDeezerApp()
                .navigateToLoginPage()
                .loginWithInvalidPassword(userEmail, userInvalidPassword)
                .getWrongLoginMessage();

        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertNull(wrongLoginDataMessage);
        softAssertion.assertEquals(wrongLoginDataMessage, expectedMessage);
        softAssertion.assertAll();
    }
}
