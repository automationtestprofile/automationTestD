package engine;

import engine.domain.pageObjects.deezer.WelcomePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public final class Driver {
    final static String BROWSER_NAME = "chrome";
    private static WebDriver instance;

    public static WebDriver getInstance() {
        return instance;
    }

    static JavascriptExecutor js = (JavascriptExecutor)instance;

    public static void start() {
        try {
            instance = DriverFactory.getDriver(BROWSER_NAME);
            instance.manage()
                    .window()
                    .maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void quit() {
        try {
            instance.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void load(String url) {
        try {
            instance.get(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void click(Locatable locator, Locatable locatorToWaitOn, boolean waitOnVisibility) {
        try {
            if (locatorToWaitOn != null) {
                if (waitOnVisibility) {
                    Wait.waitForOptionalVisibility(instance, locator);
                } else {
                    Wait.waitForOptionalInvisibility(instance, locator);
                }
            }

            Wait.getClicableElement(instance, locator)
                    .click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setText(Locatable locator, String text, boolean clearBefore) {
        try {
            WebElement element = Wait.getVisbleElement(instance, locator);

            if (clearBefore) {
                element.clear();
            }
            if (text == null)
                return;
            element.sendKeys(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getText(Locatable locator) {
        String elementsText = null;
        try {
            elementsText = Wait.getClicableElement(instance, locator).getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementsText;
    }

    public static boolean isElementDisplayed(Locatable locator) {
        WebElement element = null;
        try {
            element = Wait.waitForOptionalVisibility(instance, locator);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (element != null) {
            return true;
        } else {
            return false;
        }
    }

    public static List<String> getStringList(Locatable locator) {
        List<String> stringList = null;
        try {
            stringList = Wait.gerVisibleElements(instance, locator)
                    .stream()
                    .map(x -> x.getText().trim())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringList;
    }

    public static void scrollToElement (Locatable  locator){

        ((JavascriptExecutor)instance).executeScript("arguments[0].scrollIntoView(true);", locator);

    }
}

