package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlatPage extends AbstractPage {

    @FindBy(css = "div.price")
    private WebElement rentalPrice;

    public FlatPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int getPriceFromFlatPage() {
        String priceFromCard = rentalPrice.getText();
        //int price = Integer.parseInt(priceFromCard.substring(0, priceFromCard.length() - 3).replaceAll("\\s", ""));
        logger.info(priceFromCard);
        return SearchResultsPage.parseRentalPriceFromStringToInt(priceFromCard);
    }
}
