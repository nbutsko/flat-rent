package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RentFlatPage extends AbstractPage {

    private Actions action = new Actions(driver);

    public final static int WAIT_TIMEOUT_SECONDS = 20;
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));

    @FindBy(css = "div.region-search-item>ul>li>a")
    private WebElement buttonRegion;

    @FindBy(css = "div.region-search-item ul.choise-city-block>li>a")
    private List<WebElement> regions;

    @FindBy(css = "div.search-block-menu a[href*='rent']")
    private WebElement buttonRentAFlat;

    @FindBy(xpath = "(//span[@class='selectbox'])[1]")
    private WebElement selectorCityArea;

    @FindBy(xpath = "//div[@class='search-item']/*[contains(text(),'Район:')]/following-sibling::span/ul/li")
    private List<WebElement> cityAreas;

    @FindBy(xpath = "//div[@class='search-item']/*[contains(text(),'Район:')]/following-sibling::span//ul[@class='dropdown']")
    private WebElement dropdownAreas;

    @FindBy(css = "input[type='checkbox'][name='tx_uedbadsboard_pi1[search][rooms][]']")
    private List<WebElement> checkboxesNumberOfRooms;

    @FindBy(css = "div.search-buttons>div.right input[type='submit']")
    private WebElement buttonFindObjects;

    public RentFlatPage selectRegion(String selectedRegion) {
        action.moveToElement(buttonRegion).build().perform();
        wait.until(ExpectedConditions.visibilityOf(regions.get(0)));
        selectRegionByName(selectedRegion);
        wait.until(ExpectedConditions.visibilityOf(buttonRegion));
        return this;
    }

    private void selectRegionByName(String regionName) {
        switch (regionName) {
            case ("Брест и обл"):
                regions.get(0).click();
                break;
            case ("Витебск и обл"):
                regions.get(1).click();
                break;
            case ("Гомель и обл"):
                regions.get(2).click();
                break;
            case ("Гродно и обл"):
                regions.get(3).click();
                break;
            case ("Минск и обл"):
                regions.get(4).click();
                break;
            case ("Могилев и обл"):
                regions.get(5).click();
                break;
        }
    }

    public RentFlatPage clickButtonRentAFlat() {
        buttonRentAFlat.click();
        wait.until(ExpectedConditions.visibilityOf(buttonRentAFlat));
        return this;
    }

    public RentFlatPage selectCityArea(String selectedArea) {
        selectorCityArea.click();
        for (WebElement area : cityAreas) {
            if (area.getText().contains(selectedArea)) {
                area.click();
                break;
            }
        }
        return this;
    }

    public RentFlatPage selectNumberOfRooms(String selectedNumber) {
        for (WebElement rooms : checkboxesNumberOfRooms) {
            if (rooms.getAttribute("value").equals(selectedNumber)) {
                rooms.click();
                break;
            }
        }
        return this;
    }

    public SearchResultsPage clickButtonFindObjects() {
        buttonFindObjects.click();
        return new SearchResultsPage();
    }
}
