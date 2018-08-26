package tests.deezer;

import engine.domain.Navigate;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.UiTestRunner;

public class OffersTests extends UiTestRunner {

    @Test
    public final void isOffersPropositionIsPresent() {
        boolean isOfferContainerPresent = Navigate
                .navigateToDeezerApp()
                .navigateToOffersPage()
                .isOffersPropositionIsPresent();
        Assert.assertTrue(isOfferContainerPresent, "Offer container should be visible on page");
    }
}
