package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.UtilsClass;

public class FlatPage extends AbstractPage {

    @FindBy(css = "div.price")
    private WebElement rentalPrice;

    public FlatPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int getPriceFromFlatPage() {
        String priceFromCard = rentalPrice.getText();
        logger.info(priceFromCard);
        return UtilsClass.parseRentalPriceFromStringToInt(priceFromCard);
    }
}
