public class TransportCie extends Delivery implements DaysCalculation
{
    private Boolean expressDelivery = false;
    //private String date;
    private String nameTransportCie;
    //private String orderDate;
    private Integer countryNumberSupplier;

    /**
     * input of order details
     *
     * @param orderDate for TransportCie is actualDeliveryDate of the supplier => starting date of the transport
     * @param countryNumberSupplier residence of supplier
     */
    public TransportCie(String orderDate, Integer countryNumberSupplier, String nameTransportCie)
    {
        super(orderDate, countryNumberSupplier, nameTransportCie);

        super.orderDate = orderDate;
        super.countryNumberSupplier = countryNumberSupplier;
        super.nameTransportCie = nameTransportCie;
    }

    @Override
    public void setExpectedDeliveryDate(String date)
    {
        if (express(countryNumberSupplier, expressDelivery, nameTransportCie))
        {
            super.finalDeliveryDate = (addDaysToDate(super.orderDate,1));
        }
        else
        {
            super.finalDeliveryDate = (addDaysToDate(super.orderDate, 3));
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

    public void expressDelivery(Boolean expressDelivery)
    {
        this.expressDelivery = expressDelivery;
    }

    public Boolean express (Integer countryNumberSupplier, Boolean expressDelivery, String nameTransportCie)
    {
       return (((countryNumberSupplier >=1 & countryNumberSupplier <= 10) || (expressDelivery == true)) & nameTransportCie.equals("PostNL"));
    }

    public void setActualDeliveryDate()
    {
        if (express(countryNumberSupplier, expressDelivery, nameTransportCie))
        {
            super.finalDeliveryDate = (addDaysToDate(super.orderDate,1));
        }
        else
        {
            super.finalDeliveryDate = (addDaysToDate(super.orderDate, 3));
        }

    }



}