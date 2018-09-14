package engine;

import engine.utils.LoggerUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.rmi.runtime.Log;

import java.util.List;

public final class Wait {
    final static int TIMEOUT = 30;

    public static List<WebElement> getVisibleElements(WebDriver driver, Locatable locatable) {
        try {
            LoggerUtil.info("Waiting for list of elements" + locatable.name);
            return new WebDriverWait(driver, TIMEOUT)
                    .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locatable.getBy()));

        } catch (WebDriverException e) {
            LoggerUtil.error("Can`t discover the visibility of element" + locatable+ e.getMessage());
            //add later
            throw new WebDriverException();
        }
    }

    public static WebElement getVisibleElement(WebDriver driver, Locatable locatable) {
        try {
            LoggerUtil.info("Waiting for element" + locatable.name);
            return new WebDriverWait(driver, TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated(locatable.getBy()));
        } catch (WebDriverException e) {
            LoggerUtil.error("Can`t discover the element:" + locatable + e.getMessage());
            throw e;
        }
    }

    public static WebElement getClickableElement(WebDriver driver, Locatable locatable){
        try{
            LoggerUtil.info("Waiting for clickable element" + locatable.name);
            return new WebDriverWait(driver, TIMEOUT)
                    .until(ExpectedConditions.elementToBeClickable(locatable.getBy()));
        }
        catch (WebDriverException e){
            LoggerUtil.error("Failed to find clickable element" +"'"+ locatable +"'"+":"+ e.getMessage());
            throw new WebDriverException();
        }
    }

    public static WebElement waitForOptionalVisibility(WebDriver driver, Locatable locatable){
        try{
            LoggerUtil.info("Waiting for visibility of " + locatable.name);
            return new WebDriverWait(driver, TIMEOUT)
                    .until(ExpectedConditions.visibilityOfElementLocated(locatable.getBy()));
        }
        catch (WebDriverException e){
            LoggerUtil.error("Failed to find visible webElement" + "'" + locatable.name+ "'" +":"+ e.getMessage());
            throw new WebDriverException();
        }
    }

    public static boolean waitForOptionalInvisibility(WebDriver driver, Locatable locatable){
        try{
            LoggerUtil.info("Waiting fot visibility of" + locatable.name);
            return new WebDriverWait(driver, TIMEOUT)
                    .until(ExpectedConditions.invisibilityOfElementLocated(locatable.getBy()));
        }
        catch (WebDriverException e){
            LoggerUtil.error("Failed to find visible element" + "'"+locatable.name+"'"+":" + e.getMessage());
            throw new WebDriverException();
        }
    }
}
