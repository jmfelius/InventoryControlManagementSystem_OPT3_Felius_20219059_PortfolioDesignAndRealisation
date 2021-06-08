package Delivery;

public class Transport extends Delivery implements DaysCalculation {

    private Boolean expressDelivery = false;
    private String nameTransportCie;
    private Integer countryNumberSupplier;


    public Transport(String orderDate, Integer countryNumberSupplier, String nameTransportCie, Boolean expressDelivery) {

        super.orderDate = orderDate;
        this.countryNumberSupplier = countryNumberSupplier;
        this.nameTransportCie = nameTransportCie;
        this.expressDelivery = expressDelivery;
        setExpectedDeliveryDate(orderDate);
    }


    @Override
    public void setExpectedDeliveryDate(String orderDate) {

        if (express(countryNumberSupplier, expressDelivery, nameTransportCie)) {
            super.date = (addDaysToDate(super.orderDate,1));
        }
        else {
            super.date = (addDaysToDate(super.orderDate, 3));
        }
    }


    /**
     * Method to determine standard delivery times based on standard Boolean countrySupplier number 1 through 10 or 11 and higher,
     * Boolean expressDelivery and Boolean PostNL (number||express)&PostNL
     * NL | express| PostNL| result (1 day is 1, 3 days is 0)
     * ____________________________________________
     * 0  |   0    |    0  |   0
     * 0      0         1      0
     * 0      1         0      0
     * 0      1         1      1
     * 1      0         0      0
     * 1      0         1      1
     * 1      1         0      0
     * 1      1         1      1
     *
     */


    public Boolean express (Integer countryNumberSupplier, Boolean expressDelivery, String nameTransportCie) {

       return (((countryNumberSupplier >=1 & countryNumberSupplier <= 10) || (expressDelivery)) & nameTransportCie.equals("PostNL"));
    }
}