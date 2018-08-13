package engine;

import engine.enums.SearchBy;
import org.openqa.selenium.By;

public class Locatable {
    private String originalValue;

    private SearchBy searchBy;

    public String name;

    public String value;

    public Locatable(SearchBy searchBy, String value, String name) {
        this.searchBy = searchBy;
        this.name = name;
        this.value = value;
        this.originalValue = this.value;
    }

    public By getBy() {
        By by;
        switch (searchBy) {
            case ID:
                by = By.id(value);
                break;
            case NAME:
                by = By.name(value);
                break;
            case CLASSNAME:
                by = By.className(value);
                break;
            case CSSSELECTOR:
                by = By.cssSelector(value);
                break;
            case XPATH:
                by = By.xpath(value);
                break;
            default:
                System.out.println("No implementation yet.");
                throw new IllegalArgumentException();
        }

        return by;
    }

    public Locatable modify(String modified) {
        this.value = String.format(originalValue, modified);

        return this;
    }
}