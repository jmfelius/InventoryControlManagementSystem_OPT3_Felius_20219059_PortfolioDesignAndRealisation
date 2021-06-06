package Delivery;

import java.util.Scanner;

/**
 * In this class an order is processed by inputting dates of reception of order by supplier/transportcie,
 * updates of dates and actual delivery dates
 */
public abstract class Delivery implements DaysCalculation {

    protected String orderDate;
    protected String date;
    protected String finalDeliveryDate;
    protected Integer countryNumberSupplier;


    /**
     * Create empty constructor because of abstract class
     */
    public Delivery() {}


    /**
     * Based on input supplier/transportcie expected date is established;
     * this method remains empty in this class; is being implemented in subclasses.
     */
    public abstract void setExpectedDeliveryDate (String date);


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