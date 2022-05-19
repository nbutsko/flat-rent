package steps;

import domain.Flat;
import org.openqa.selenium.WebDriver;
import pageobjects.RentFlatPage;
import pageobjects.HomePage;
import pageobjects.SearchResultsPage;
import utils.UtilsClass;

import java.util.ArrayList;
import java.util.List;

public class RentFlatStep extends RentFlatPage {

    public void openPageAndSearchFlat(String region, String cityArea, String numberOfRooms){
        new HomePage()
                .openPage()
                .clickButtonFlatForRent()
                .selectRegion(region)
                .clickButtonRentAFlat()
                .selectCityArea(cityArea)
                .selectNumberOfRooms(numberOfRooms)
                .clickButtonFindObjects();
    }

    private List<String> getListOfFlatAddresses() {
        String addressSelector = "div.title-obj span";
        return UtilsClass.getListOfParametersFromListOfWebElements(SearchResultsPage.getListOfFoundFlat(), addressSelector);
    }

    private List<String> getListOfRentalPrice() {
        String priceSelector = "div.info>p.price";
        return UtilsClass.getListOfParametersFromListOfWebElements(SearchResultsPage.getListOfFoundFlat(), priceSelector);
    }

    public int getLowestPriceInResultList() {
        return getListOfRentalPrice().stream()
                .map(UtilsClass::parseRentalPriceFromStringToInt)
                .min(Integer::compareTo)
                .get();
    }

    public List<Flat> getListOfFlats() {
        List<Flat> result = new ArrayList<>();
        for (int i = 0; i < getListOfFlatAddresses().size(); i++) {
            Flat flat = new Flat(getListOfFlatAddresses().get(i), getListOfRentalPrice().get(i));
            result.add(flat);
            logger.info(flat.toString());
        }
        return result;
    }
}
