package Delivery;

public class Supplier extends Delivery
{
    /**
     * input of order details; country will be used in Delivery.Delivery.TransportCie class
     *
     * @param orderDate initial date of order
     * @param countryNumber  country number  where supplier resides
     */
    public Supplier(String orderDate, Integer countryNumber) {
        super(orderDate,countryNumber);

        this.orderDate = orderDate;
        super.countryNumberSupplier = countryNumber;
    }

    public Integer getCountry()
    {
    return countryNumberSupplier;
    }

    @Override
    public void setExpectedDeliveryDate(String date) {

        super.date = date;
    }

    @Override
    public String getExpectedDeliveryDate() {

        return date;
    }
}
