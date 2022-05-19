package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends AbstractPage {

    @FindBy(css = "div.bb-ad-item")
    private static List<WebElement> foundFlats;

    public static List<WebElement> getListOfFoundFlatCards() {
        return foundFlats;
    }
}
