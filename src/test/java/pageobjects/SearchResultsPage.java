package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends AbstractPage {

    @FindBy(css = "div.bb-ad-item")
    private static List<WebElement> foundFlats;

    public static List<WebElement> getListOfFoundFlat() {
        return foundFlats;
    }

    /*public FlatPage openFlatPageWithLowestPrice() {
        String priceSelector = "div.info>p.price";
        String buttonFlatTitleSelector = "div.title-obj>a";
        for (WebElement flatCard : foundFlats) {
            String priceFromCard = flatCard.findElement(By.cssSelector(priceSelector)).getText();
            int price = UtilsClass.parseRentalPriceFromStringToInt(priceFromCard);
            if (price == getLowestPriceInResultList()) {
                flatCard.findElement(By.cssSelector(buttonFlatTitleSelector)).click();
                break;
            }
        }
        return new FlatPage(driver);
    }*/


}
