package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsPage extends AbstractPage {

    @FindBy(css = "div.bb-ad-item")
    private List<WebElement> foundFlats;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private List<String> getListOfFlatAddresses() {
        String addressSelector = "div.title-obj span";
        List<String> addressesInResult = foundFlats.stream()
                .map(webElement -> webElement.findElement(By.cssSelector(addressSelector)).getText())
                .collect(Collectors.toList());
        return addressesInResult;
    }

    private List<String> getListOfRentalPrice() {
        String priceSelector = "div.info>p.price";
        List<String> pricesInResult = foundFlats.stream()
                .map(webElement -> webElement.findElement(By.cssSelector(priceSelector)).getText())
                .collect(Collectors.toList());
        return pricesInResult;
    }

    public int getLowestPriceInResultList() {
        int lowestPrice = getListOfRentalPrice().stream()
                .map(s -> s.substring(0, s.length() - 3).replaceAll("\\s", ""))
                .map(Integer::parseInt)
                .min(Integer::compareTo)
                .get();
        return lowestPrice;
    }

    public FlatPage openFlatPageWithLowestPrice() {
        String priceSelector = "div.info>p.price";
        String buttonFlatTitleSelector = "div.title-obj>a";
        for (WebElement flatCard : foundFlats) {
            String priceFromCard = flatCard.findElement(By.cssSelector(priceSelector)).getText();
            int price = parseRentalPriceFromStringToInt(priceFromCard);
            if (price == getLowestPriceInResultList()) {
                flatCard.findElement(By.cssSelector(buttonFlatTitleSelector)).click();
                break;
            }
        }
        return new FlatPage(driver);
    }

    public void uploadToLogSearchResults() {
        for (int i = 0; i < getListOfFlatAddresses().size(); i++) {
            logger.info(getListOfFlatAddresses().get(i));
            logger.info(getListOfRentalPrice().get(i));
        }
    }

    public static int parseRentalPriceFromStringToInt(String price){
        return Integer.parseInt(price.substring(0, price.length() - 3).replaceAll("\\s", ""));
    }
}
