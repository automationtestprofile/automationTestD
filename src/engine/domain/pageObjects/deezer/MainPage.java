package engine.domain.pageObjects.deezer;

import engine.Driver;
import engine.Locatable;
import engine.enums.SearchBy;

public class MainPage {
    public static Driver driver = new Driver();

    private final Locatable playerForm =
            new Locatable(SearchBy.ID, "player", "Player on main page");

    public boolean isPlayerPresent() {
        return driver.isElementDisplayed(playerForm);
    }

}
