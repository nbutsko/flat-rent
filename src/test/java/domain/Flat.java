package domain;

public class Flat {
    private String address;
    private String price;

    public Flat(String address, String price) {
        this.address = address;
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "address='" + address + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
