package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage{

    @FindBy(css = "div.links-menu a[href='https://www.kvartirant.by/ads/flats/rent/']")
    private WebElement buttonFlatForRent;


    public HomePage openPage(){
        driver.get(BASE_URL);
        return this;
    }

    public RentFlatPage clickButtonFlatForRent(){
        buttonFlatForRent.click();
        return new RentFlatPage();
    }
}
