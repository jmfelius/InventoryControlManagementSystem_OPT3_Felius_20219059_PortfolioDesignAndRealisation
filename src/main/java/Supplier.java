public class Supplier extends Delivery
{
    Integer countryNumber;


    /**
     * input of order details; country will be used in TransportCie class
     *
     * @param orderDate initial date of order
     * @param countryNumber  country number  where supplier resides
     */
    public Supplier(String orderDate, Integer countryNumber)
    {
        super(orderDate);
        this.countryNumber = countryNumber;
    }

    public Integer getCountry()
    {
    return countryNumber;
    }

    @Override
    public void setExpectedDeliveryDate(String date) {
        this.date = date;

    }
}
