package domain;

public class QuerySearch {

    private String region;
    private String cityArea;
    private String numberOfRooms;

    public QuerySearch(String region, String cityArea, String numberOfRooms) {
        this.region = region;
        this.cityArea = cityArea;
        this.numberOfRooms = numberOfRooms;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCityArea() {
        return cityArea;
    }

    public void setCityArea(String cityArea) {
        this.cityArea = cityArea;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }
}
