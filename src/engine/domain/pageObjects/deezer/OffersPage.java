package engine.domain.pageObjects.deezer;

import engine.Driver;
import engine.Locatable;
import engine.domain.pageObjects.deezer.Controllers.LoginHeader;
import engine.enums.SearchBy;

public class OffersPage extends LoginHeader {
    public static Driver driver = new Driver();
    private final Locatable offersContainer =
            new Locatable(SearchBy.CLASSNAME,"unlogged-plans-list-container", "Form with iformation about offers and prices");
    public boolean isOfferContainerVisible (){
        return driver.isElementDisplayed(offersContainer);
    }

}
