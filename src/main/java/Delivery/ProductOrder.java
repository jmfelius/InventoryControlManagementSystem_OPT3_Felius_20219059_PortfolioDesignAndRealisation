package Delivery;

import Data.Customer;
import Data.Product;
import Delivery.Delivery;

import java.util.ArrayList;

public class ProductOrder {

    /**
     * ArrayList consisting of Delivery.Delivery.Supplier and Delivery.Delivery.TransportCie in order to establish
     * accumulated deliverytime (a productOrder requires Delivery.Delivery)
     */
    public ArrayList<Delivery> deliveries;

    /**
     * a constructor is built with arrayList and Delivery.ProductOrder parameters
     */
    public ProductOrder(Customer customer, Product product, String orderDate, String deliveryDateSupplier,
                        int countryNumber, String nameTransportCie, boolean expressDelivery) {

        this.deliveries = new ArrayList<>();

        Delivery supplier = new Supplier(orderDate,countryNumber);
        supplier.setExpectedDeliveryDate(deliveryDateSupplier);
        Delivery transportCie = new TransportCie(supplier.getExpectedDeliveryDate(),supplier.countryNumberSupplier,nameTransportCie, expressDelivery);

        deliveries.add(supplier);
        deliveries.add(transportCie);
    }

    public int getTotalActualDeliveryTime() {

        int totalActualDeliveryTime = 0;

        for (Delivery delivery : deliveries) {
             totalActualDeliveryTime += (int)delivery.getActualDeliveryTime();
        }
        return totalActualDeliveryTime;
    }

    public String getExpectedDeliveryDate() {

        String expectedDeliveryDate = "";

        for (Delivery delivery : deliveries){
            expectedDeliveryDate += " " + delivery.getExpectedDeliveryDate();
        }

        return expectedDeliveryDate;
    }
}
