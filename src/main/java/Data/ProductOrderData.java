package Data;

public class ProductOrderData {

    String name;
    int countryNumber;
    Customer customer;
    Product product;

    public ProductOrderData(Product product, Customer customer){
        this.customer = customer;
        this.product = product;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }


    public int getCountryNumber() {
        return countryNumber;
    }

    public void setCountryNumber(int countryNumber) {
        this.countryNumber = countryNumber;
    }
}
