package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FlatsRentPage extends AbstractPage {

    private Actions action = new Actions(driver);

    public final static int WAIT_TIMEOUT_SECONDS = 20;
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));

    private JavascriptExecutor executor = (JavascriptExecutor) driver;

    @FindBy(css = "div.region-search-item>ul>li>a")
    private WebElement buttonRegion;

    @FindBy(css = "div.region-search-item ul.choise-city-block>li>a")
    private List<WebElement> regions;

    @FindBy(css = "div.search-block-menu a[href*='rent']")
    private WebElement buttonRentAFlat;

    @FindBy(xpath = "//div[@class='search-item']/*[contains(text(),'Район:')]/following-sibling::span//span[@class='select']")
    //@FindBy(xpath = "//*[@id='form1']/div[2]/span[2]")
    private WebElement selectorCityArea;

    //FindBy(xpath = "//div[@class='search-item']/*[contains(text(),'Район:')]/following-sibling::span/ul/li")
    //private List<WebElement> cityAreas;

    @FindBy(xpath = "//div[@class='search-item']/*[contains(text(),'Район:')]/following-sibling::span//ul[@class='dropdown']")
    private WebElement dropdownAreas;

    @FindBy(css = "input[type='checkbox'][name='tx_uedbadsboard_pi1[search][rooms][]']")
    private List<WebElement> checkboxesNumberOfRooms;

    @FindBy(css = "div.search-buttons>div.right input[type='submit']")
    private WebElement buttonFindObjects;

    public FlatsRentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public FlatsRentPage selectRegion(String selectedRegion) {
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

    public FlatsRentPage clickButtonRentAFlat() {
        buttonRentAFlat.click();
        wait.until(ExpectedConditions.visibilityOf(buttonRentAFlat));
        return this;
    }

    public FlatsRentPage selectCityArea(String selectedArea) {
        //executor.executeScript("arguments[0].click();", selectorCityArea);
        action.moveToElement(selectorCityArea).click().build().perform();
        //selectorCityArea.click();
        wait.until(ExpectedConditions.visibilityOf(dropdownAreas));
        List<WebElement> cityAreas = driver.findElements(By.xpath("//div[@class='search-item']/*[contains(text(),'Район:')]/following-sibling::span/ul/li"));
        System.out.println("SIZE " + cityAreas.size());
        return this;
    }

    public FlatsRentPage selectNumberOfRooms(String selectedNumber) {
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
        return new SearchResultsPage(driver);
    }
}
