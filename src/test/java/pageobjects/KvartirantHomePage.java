package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class KvartirantHomePage extends AbstractPage{

    @FindBy(css = "div.links-menu a[href='https://www.kvartirant.by/ads/flats/rent/']")
    private WebElement buttonFlatForRent;

    public KvartirantHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public KvartirantHomePage openPage(){
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        return new KvartirantHomePage(driver);
    }

    public FlatsRentPage clickButtonFlatForRent(){
        buttonFlatForRent.click();
        return new FlatsRentPage(driver);
    }
}
