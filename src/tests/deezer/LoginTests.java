package tests.deezer;

import engine.Driver;
import engine.domain.Navigate;
import engine.domain.pageObjects.deezer.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.UiTestRunner;

import java.net.URL;

public class LoginTests extends UiTestRunner {
    @Test
    public final void loginFormIsPresent(){
        boolean isLoginFormPresent = Navigate
                .navigateToDeezerApp()
                .navigateToSignIn()
                .isLoginFormContainerIsPresent();

        Assert.assertTrue(isLoginFormPresent, "Login form should be visible on page");
    }
    @Test
    public final void singUpFormIsPresent(){
        boolean isSingUpFormIsPresent = Navigate
                .navigateToDeezerApp()
                .navigateToSignUp()
                .isSingUpContainerPresent();
        Assert.assertEquals(isSingUpFormIsPresent,true, "Sing up form should be visible on the page");
    }
    @Test
    public final void isOfferContainerPresent(){
        boolean isOfferContainerPresent = Navigate
                .navigateToDeezerApp()
                .navigateToOfferPage()
                .isOfferContainerVisible();
        Assert.assertTrue(isOfferContainerPresent, "Offer container shoud be present");
    }
    @Test
    public final void isPasswordResetPresent(){
        boolean isPasswordResetPresent = Navigate
                .navigateToDeezerApp()
                .navigateToSignIn()
                .navigateToForgetPasswordLink()
                .isResetContainerIsVisible();
        Assert.assertTrue(isPasswordResetPresent, "Password reset container should be visible");
    }
    @Test
    public final void isPasswordResetIsSuccess(){
        String isPasswordResetIsSuccess = Navigate
                .navigateToDeezerApp()
                .navigateToSignIn()
                .navigateToForgetPasswordLink()
                .setTextToResetEmailFiled()
                .navigateToSubmitResetMail()
                .getTextAboutConfirm();
        Assert.assertEquals(isPasswordResetIsSuccess, LoginPage.userEmail);
    }
    @Test
    public final void isMessageResetIsSuccess() {
        String isMessageResetIsSuccess = Navigate
                .navigateToDeezerApp()
                .navigateToSignIn()
                .navigateToForgetPasswordLink()
                .setTextToResetEmailFiled()
                .navigateToSubmitResetMail()
                .gerTextFromMessageReceived();
        Assert.assertEquals(isMessageResetIsSuccess, "You've got mail!");
    }
    @Test
    public final void isLoginIsSuccess(){
        boolean isLoginIsSuccess = Navigate
                .navigateToDeezerApp()
                .navigateToSignIn()
                .setTextToEmailFiledSingInPAge()
                .setTextToPasswordSingInFiled()
                .navigateToSubmitSingInButton()
                .isPlayerPresentOnMainPage();
        Assert.assertTrue(isLoginIsSuccess);
    }
//    @Test
//    public final void isFacebookPopUpIsPresent(){
//        boolean isLoginFacebookPopUpIsPresent = Navigate
//                .navigateToDeezerApp()
//                .navigateToSignIn()
//                .navigateToFacebookButton()
//                .isPopUpFacebookIsPresentForSingIn();
//        Assert.assertTrue(isLoginFacebookPopUpIsPresent, "Login Popup should appears");
//
//    }

}
