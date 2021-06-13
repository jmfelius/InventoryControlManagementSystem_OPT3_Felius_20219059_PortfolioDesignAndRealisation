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
    public ArrayList<Delivery> deliveries;

    private int getSize() {
        return deliveries.size();
    }




    /**
     * a constructor is built with arrayList and Delivery.ProductOrder parameters
     */
    public ProductOrder(Customer customer, Product product, String orderDate, String deliveryDateSupplier,
                        SupplierCompany supplierCompany, TransportCompany transportCompany, boolean expressDelivery) {

        this.deliveries = new ArrayList<>();

        Delivery supplier = new Supplier(orderDate, supplierCompany.getCountryNumber());
        supplier.setExpectedDeliveryDate(deliveryDateSupplier);
        Delivery transport = new Transport (supplier.getExpectedDeliveryDate(), supplierCompany.getCountryNumber(), transportCompany.getName(), expressDelivery);

        deliveries.add(supplier);
        deliveries.add(transport);
    }

    public int getTotalActualDeliveryTime() {

        int totalActualDeliveryTime = 0;

        for (Delivery delivery : deliveries) {
             totalActualDeliveryTime += (int)delivery.getActualDeliveryTime();
        }
        return totalActualDeliveryTime;
    }

    public String getExpectedDeliveryDate() {

        String expectedDeliveryDate = deliveries.get(getSize()-1).getExpectedDeliveryDate();

        return expectedDeliveryDate;
    }
}
