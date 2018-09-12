package engine;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import engine.utils.LoggerUtil;

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

            LoggerUtil.info("Starting browser: " + BROWSER_NAME.toUpperCase());

        } catch (Exception e) {
            LoggerUtil.error("Failed to start browser: " + e.getMessage());
            throw e;
        }
    }

    public static void quit() {
        try {
            instance.quit();

            LoggerUtil.info("Closed browser");

        } catch (Exception e) {
            LoggerUtil.error("Failed to close browser: " + e.getMessage());
            throw e;
        }
    }

    public static void load(String url) {
        try {
            instance.get(url);

            LoggerUtil.info("Loaded: " + url);
        } catch (Exception e) {
            LoggerUtil.error("Failed to load " + "'" + url +  "'" + ": " + e.getMessage());
            throw e;
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

            Wait.getClickableElement(instance, locator)
                    .click();

            LoggerUtil.info("Clicked on " + locator.name);
        } catch (Exception e) {
            LoggerUtil.error("Failed to click on " + "'" + locator + "'" + ": " + e.getMessage());
        }
    }

    public static void setText(Locatable locator, String text, boolean clearBefore) {
        try {
            WebElement element = Wait.getVisibleElement(instance, locator);

            if (clearBefore) {
                LoggerUtil.info("Created " + "'" + locator.name + "'");
                element.clear();
            }
            if (text == null)
                return;
            element.sendKeys(text);

            LoggerUtil.info("Filled " + "'" + locator.name + "'" + " with text " + text);
        } catch (Exception e) {
            LoggerUtil.error("Failed to fill " + locator + " with text" + text + ": " + e.getMessage());
            throw e;
        }
    }

    public static String getText(Locatable locator) {
        String elementsText = null;
        try {
            elementsText = Wait.getVisibleElement(instance, locator).getText();
            LoggerUtil.info("Got " + "'" + elementsText + "'" + " from " + "'" + locator.name + "'");
        } catch (Exception e) {
            LoggerUtil.error("Failed to get text from " + "'" + locator + "'" + ": " + e.getMessage());
            throw e;
        }
        return elementsText;
    }

    public static boolean isElementDisplayed(Locatable locator) {
        WebElement element = null;
        try {
            element = Wait.waitForOptionalVisibility(instance, locator);

        } catch (Exception e) {
            LoggerUtil.error("Can't discover visibility of element " + "'" + locator + "'" + ": " + e.getMessage());
            throw e;
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
            stringList = Wait.getVisibleElements(instance, locator)
                    .stream()
                    .map(x -> x.getText().trim())
                    .collect(Collectors.toList());

            LoggerUtil.info("Got " + stringList.toString() + "from " + "'" + locator.name + "'");
        } catch (Exception e) {
            LoggerUtil.error("Failed to get list with strings from " + "'" + locator + "'" + ": " + e.getMessage());
            throw e;
        }
        return stringList;
    }

    public static void scrollToElement (Locatable  locator){
        try{
            ((JavascriptExecutor)instance).executeScript("arguments[0].scrollIntoView(true);",
                    Wait.getVisibleElement(instance, locator));

            LoggerUtil.info("Scrolled to element " + "'" + locator.name + "'");
        }
        catch (Exception e){
            LoggerUtil.error("Failed to scroll to element " + "'" + locator + "'" + ": " + e.getMessage());
            throw e;
        }
    }
    
    public static void takeSnapShot(WebDriver instance, String fileWithPath)
        throws Exception{
        TakesScreenshot scrShot =((TakesScreenshot)instance);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public static String timestamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
    }
}

