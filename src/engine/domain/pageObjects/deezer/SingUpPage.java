package engine.domain.pageObjects.deezer;

import engine.Driver;
import engine.Locatable;
import engine.domain.pageObjects.deezer.Controllers.LoginHeader;
import engine.enums.SearchBy;

public class SingUpPage extends LoginHeader {
    public static Driver driver = new Driver();
    private final Locatable singUpFormContainer =
            new Locatable(SearchBy.CLASSNAME, "unlogged-form-container",
                    "Sing up container");

    public boolean isSingUpContainerPresent() {
        return driver.isElementDisplayed(singUpFormContainer);
    }

}
