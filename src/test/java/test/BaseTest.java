package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.FlatPage;
import pageobjects.KvartirantHomePage;
import pageobjects.SearchResultsPage;


public class BaseTest extends AbstractTest {

    @Test
    public void testLowestPrice() {
        String region = "Минск и обл";
        String cityArea = "Центральный район";
        String numberOfRooms = "1";

        SearchResultsPage searchResultsPage = new KvartirantHomePage(driver).openPage()
                .clickButtonFlatForRent()
                .selectRegion(region)
                .clickButtonRentAFlat()
                //.selectCityArea(cityArea)
                .selectNumberOfRooms(numberOfRooms)
                .clickButtonFindObjects();

        int lowestPriceFromResults = searchResultsPage.getLowestPriceInResultList();
        searchResultsPage.uploadToLogSearchResults();

        FlatPage flatPage = searchResultsPage.openFlatPageWithLowestPrice();

        Assert.assertEquals(flatPage.getPriceFromFlatPage(), lowestPriceFromResults);
    }
}
