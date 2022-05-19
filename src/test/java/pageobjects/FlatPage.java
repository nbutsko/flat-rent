package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.UtilsClass;

public class FlatPage extends AbstractPage {

    @FindBy(css = "div.price")
    private WebElement rentalPrice;

    public int getPriceFromFlatPage() {
        String priceFromCard = rentalPrice.getText();
        logger.info(priceFromCard);
        return UtilsClass.parseRentalPriceFromStringToInt(priceFromCard);
    }
}
