package test;

import domain.QuerySearch;
import org.testng.annotations.Test;
import steps.RentFlatStep;

public class BaseTest extends AbstractTest {

    @Test
    public void testLowestPrice() {
        QuerySearch querySearch = new QuerySearch("Минск и обл", "Центральный район", "1");

        RentFlatStep flatsRentStep = new RentFlatStep();
        flatsRentStep.openPageAndSearchFlat(querySearch.getRegion(), querySearch.getCityArea(), querySearch.getNumberOfRooms());

        flatsRentStep.getListOfFlats();
    }
}
