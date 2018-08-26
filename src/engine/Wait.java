package engine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public final class Wait {
    final static int TIMEOUT = 30;

    public static List<WebElement> getVisibleElements(WebDriver driver, Locatable locatable) {
        try {
            return new WebDriverWait(driver, TIMEOUT)
                    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatable.getBy()));
        } catch (WebDriverException e) {
            //add later
            throw new WebDriverException();
        }
    }

    public static WebElement getVisibleElement(WebDriver driver, Locatable locatable) {
        try {
            return new WebDriverWait(driver, TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated(locatable.getBy()));
        } catch (WebDriverException e) {
            e.getMessage();
            throw e;
        }
    }

    public static WebElement getClickableElement(WebDriver driver, Locatable locatable){
        try{
            return new WebDriverWait(driver, TIMEOUT)
                    .until(ExpectedConditions.elementToBeClickable(locatable.getBy()));
        }
        catch (WebDriverException e){
            throw new WebDriverException();
        }
    }

    public static WebElement waitForOptionalVisibility(WebDriver driver, Locatable locatable){
        try{
            return new WebDriverWait(driver, TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated(locatable.getBy()));
        }
        catch (WebDriverException e){
            throw new WebDriverException();
        }
    }

    public static boolean waitForOptionalInvisibility(WebDriver driver, Locatable locatable){
        try{
            return new WebDriverWait(driver, TIMEOUT)
                    .until(ExpectedConditions.invisibilityOfElementLocated(locatable.getBy()));
        }
        catch (WebDriverException e){
            throw new WebDriverException();
        }
    }
}
