package utils;

public class UtilsClass {

    public static int parseRentalPriceFromStringToInt(String price){
        return Integer.parseInt(price.substring(0, price.length() - 3).replaceAll("\\s", ""));
    }
}
