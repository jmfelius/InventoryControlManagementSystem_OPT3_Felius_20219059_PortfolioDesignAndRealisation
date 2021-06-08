package Delivery;

import Data.Customer;
import Data.Product;
import Data.SupplierCompany;
import Data.TransportCompany;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * In this class an order is processed by inputting dates of reception of order by supplier/transportcie,
 * updates of dates and actual delivery dates
 */
public class Delivery implements DaysCalculation {

    protected String orderDate;
    protected String date;
    protected String finalDeliveryDate;
    protected Integer countryNumberSupplier;
    public ArrayList<Delivery> deliveries;

    /**
     * a constructor is built with arrayList and various parameters
     */
    public Delivery(Customer customer, Product product, String orderDate, String deliveryDateSupplier,
                        SupplierCompany supplierCompany, TransportCompany transportCompany, boolean expressDelivery) {

        this.deliveries = new ArrayList<>();

        Delivery supplier = new Supplier(orderDate, supplierCompany.getCountryNumber());
        supplier.setExpectedDeliveryDate(deliveryDateSupplier);
        Delivery transport = new Transport (supplier.getExpectedDeliveryDate(), supplierCompany.getCountryNumber(), transportCompany.getName(), expressDelivery);

        deliveries.add(supplier);
        deliveries.add(transport);
    }

    public Delivery(String orderDate, Integer countryNumber) {
    }

    public Delivery(String orderDate, Integer countryNumberSupplier, String nameTransportCie, Boolean expressDelivery) {
    }


    /**
     * Based on input supplier/transportcie expected date is established;
     * this method remains empty in this class; is being implemented in subclasses.
     */
    public  void setExpectedDeliveryDate (String date){

        this.date = date;
    }


    /**
     * Based on updated info of supplier/transportcie a new expected deliverydate is established
     * @param today date of today dd-MM-yyyy
     */
    public void updateExpectedDeliveryDate (String today)
    {
        int deltaDays = (int) getDifferenceDays(date, today );
        if (deltaDays < 0)
        {
            Scanner newDate = new Scanner(System.in);
            System.out.print("Please insert new expected delivery date (dd-MM-yyyy): ");
            this.date = newDate.nextLine();
        }
        else
        {
            System.out.printf("Please be patient; still %d days before the expected delivery day lapses.", deltaDays);
        }
    }


    /**
     * When the supplier/transportcie has delivered the order to the next chain (i.e.
     * transportcie or customer respectively), the actual delivery date is inputted.
     * @param date actual delivery date to transportcie or customer
     */
    public void setActualDeliveryDate (String date) {

        this.finalDeliveryDate = date;
    }


    /**
     * returns actual date of delivery
     * @return date of expected delivery to customer
     */
    public String getExpectedDeliveryDate () {

        try {
            int deltaDays = (int) getDifferenceDays (date, finalDeliveryDate);
            if (deltaDays < 0) {
                return ("The product has already been delivered on " + finalDeliveryDate);
            }
        }
        catch(Exception e){}

        return date;
    }


    /**
     * returns actual date of delivery to customer
     * @return actual date of delivery to customer
     */
    public String getActualDeliveryDate () {

        return finalDeliveryDate;
    }


    /**
     * Based on order date and actual deliverydate the time from order to
     * delivery per logistical chain is returned
     * @return int delivery time in days
     */
    public  long getActualDeliveryTime () {

        return getDifferenceDays(orderDate, date);
    }

}