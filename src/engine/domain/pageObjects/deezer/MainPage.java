package engine.domain.pageObjects.deezer;

import engine.Driver;
import engine.Locatable;
import engine.enums.SearchBy;

public class MainPage {
    public static Driver driver = new Driver();

    private final Locatable playerForm =
            new Locatable(SearchBy.ID, "player", "Player on main page");

    private final Locatable playButton =
            new Locatable(SearchBy.XPATH, "//*[@class=\"svg-icon svg-icon-play\"]", "Play button");

    private final Locatable pauseButton =
            new Locatable(SearchBy.XPATH, "//*[@class=\"svg-icon svg-icon-pause\"]", "Pause button");
//svg-icon svg-icon-qlist active
    private final Locatable queueButton =
            new Locatable(SearchBy.XPATH, "//*[@class=\"control control-qlist\"]",
                    "Button to open list with songs button");

    private final Locatable queuePanel =
            new Locatable(SearchBy.XPATH, "//*[@class=\"panel-header panel-upnext\"]",
                    "Queue panel with songs");

    private final Locatable previousSongButton =
            new Locatable(SearchBy.XPATH, "", "");

    public boolean isPlayerPresent() {
        return driver.isElementDisplayed(playerForm);
    }

    public MainPage clickOnPlayButton(){
        driver.click(playButton, null, true);
        return this;
    }

    public MainPage clickOnQueueButton(){
        driver.click(queueButton, null,true);
        return this;
    }
    public boolean isPauseButtonAppears(){
        return driver.isElementDisplayed(pauseButton);
    }
    public boolean isQueuePannelIsVisible(){
        return driver.isElementDisplayed(queuePanel);
    }


}
