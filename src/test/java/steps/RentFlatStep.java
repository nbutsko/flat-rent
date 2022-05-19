package steps;

import domain.Flat;
import pageobjects.RentFlatPage;
import pageobjects.HomePage;
import pageobjects.SearchResultsPage;
import utils.UtilsClass;

import java.util.ArrayList;
import java.util.List;

public class RentFlatStep extends RentFlatPage {

    public void openPageAndSearchFlat(String region, String cityArea, String numberOfRooms) {
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
        return UtilsClass.getListOfParametersFromListOfWebElements(SearchResultsPage.getListOfFoundFlatCards(), addressSelector);
    }

    private List<String> getListOfRentalPrice() {
        String priceSelector = "div.info>p.price";
        return UtilsClass.getListOfParametersFromListOfWebElements(SearchResultsPage.getListOfFoundFlatCards(), priceSelector);
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

    public int getLowestPriceInResultList() {
        int lowerPrice = getListOfRentalPrice().stream()
                .map(UtilsClass::parseRentalPriceFromStringToInt)
                .min(Integer::compareTo)
                .get();
        logger.info(lowerPrice);
        return lowerPrice;
    }
}
