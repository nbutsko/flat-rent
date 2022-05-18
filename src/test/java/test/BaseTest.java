package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.FlatPage;
import pageobjects.KvartirantHomePage;
import pageobjects.SearchResultsPage;


public class BaseTest extends AbstractTest {

    @Test
    public void testLowestPrice(){
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

        searchResultsPage.uploadToLogSearchResults();

        FlatPage flatPage = searchResultsPage.openFlatPageWithLowestPrice();

        System.out.println("Min rental price " + searchResultsPage.getLowestPriceInResultList());
        System.out.println("Flat rental price " + flatPage.getPriceFromFlatPage());

        Assert.assertEquals(flatPage.getPriceFromFlatPage(), searchResultsPage.getLowestPriceInResultList());
    }
}
