package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.SearchResultsPage;

import java.util.List;
import java.util.stream.Collectors;

public class UtilsClass {

    public static int parseRentalPriceFromStringToInt(String price){
        return Integer.parseInt(price.substring(0, price.length() - 3).replaceAll("\\s", ""));
    }

    public static List<String> getListOfParametersFromListOfWebElements(List<WebElement> list, String parametersCSSSelector){
        return list.stream()
                .map(webElement -> webElement.findElement(By.cssSelector(parametersCSSSelector)).getText())
                .collect(Collectors.toList());
    }
}
