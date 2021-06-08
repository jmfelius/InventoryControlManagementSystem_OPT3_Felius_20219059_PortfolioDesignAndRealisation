package Delivery;

import Data.Customer;
import Data.Product;
import Data.SupplierCompany;
import Data.TransportCompany;

import java.util.ArrayList;

public class ProductOrder {

    /**
     * ArrayList consisting of Delivery.Delivery.Supplier and Delivery.Delivery.TransportCie in order to establish
     * accumulated deliverytime (a productOrder requires Delivery.Delivery)
     */
    public Delivery delivery;
    Customer customer;
    Product product;
    String orderDate;
    String deliveryDateSupplier;
    SupplierCompany supplierCompany;
    TransportCompany transportCompany;
    boolean expressDelivery = true;

    /**
     * a constructor is built with arrayList and Delivery.ProductOrder parameters
     */
    public ProductOrder() {

        delivery = new Delivery(customer, product, orderDate, deliveryDateSupplier,
                supplierCompany, transportCompany, expressDelivery);
    }

    public int getTotalActualDeliveryTime() {

        int totalActualDeliveryTime = 0;

        for (Delivery delivery : delivery.deliveries) {
             totalActualDeliveryTime += (int)delivery.getActualDeliveryTime();
        }
        return totalActualDeliveryTime;
    }

    public String getExpectedDeliveryDate() {

        String expectedDeliveryDate = "";

        for (Delivery delivery : delivery.deliveries){
            expectedDeliveryDate += " " + delivery.getExpectedDeliveryDate();
        }

        return expectedDeliveryDate;
    }
}
