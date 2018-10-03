package deezer;

import engine.domain.Navigate;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainPageTests extends tests.UiTestRunner {

    private static String userEmail = "mrs.tester.tested@gmail.com";
    private static String userPassword = "P@ssw0rd";

    @Test
    public final void isPlayerStarts() {
        boolean isPlayerStarts = Navigate
                .navigateToDeezerApp()
                .navigateToLoginPage()
                .login(userEmail, userPassword)
                .clickOnPlayButton()
                .isPauseButtonAppears();

        Assert.assertTrue(isPlayerStarts, "User should see pause button if player starts");
    }
    @Test
    public final void isQueuePanelIsPresent() {
        boolean isQueuePanelIsPresent = Navigate
                .navigateToDeezerApp()
                .navigateToLoginPage()
                .login(userEmail, userPassword)
                .clickOnQueueButton()
                .isQueuePannelIsVisible();

        Assert.assertTrue(isQueuePanelIsPresent, "User should see Queue pannel with songs");
    }
    }