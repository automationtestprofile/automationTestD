package engine.domain.pageObjects.deezer;

import engine.Driver;
import engine.Locatable;
import engine.enums.SearchBy;

public class MainPage {
    public static Driver driver = new Driver();

    private final Locatable playerForm =
            new Locatable(SearchBy.ID, "player", "Player on main page");

    private final Locatable playButton =
            new Locatable(SearchBy.CLASSNAME, "control control-play", "Play button");

    private final Locatable pauseButton =
            new Locatable(SearchBy.CLASSNAME, "svg-icon svg-icon-pause", "Pause button");

    public boolean isPlayerPresent() {
        return driver.isElementDisplayed(playerForm);
    }

}
