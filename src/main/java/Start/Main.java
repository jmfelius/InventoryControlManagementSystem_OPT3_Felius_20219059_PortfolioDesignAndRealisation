package Start;

import Delivery.Delivery;
import Delivery.ProductOrder;
import Data.Customer;
import Data.Product;
import Data.SupplierCompany;
import Data.TransportCompany;

public class Main {

    public static void main(String[] args) {

        if (Login.getInstance().isAuthenticated()) {

            String orderDate = "15-4-2021";
            String deliveryDateSupplier = "30-5-2021";
            boolean expressDelivery = false;
            Customer customer = new Customer();
            customer.setName("Jansen");
            Product product = new Product();
            product.setName("Pegasus");
            SupplierCompany supplierCompany = new SupplierCompany();
            supplierCompany.setName("Nike");
            supplierCompany.setCountryNumber(1);
            TransportCompany transportCompany = new TransportCompany();
            transportCompany.setName("DHL");
            transportCompany.setCountryNumber(1);
            ProductOrder productOrder = new ProductOrder();
            System.out.println("The order date (orderDate) is: " + orderDate);
            System.out.println(("The expected delivery date (getExpectedDeliveryDate) is: " + productOrder.getExpectedDeliveryDate()));
            System.out.println("The total delivery time (getTotalActualDeliveryTime) is: " + productOrder.getTotalActualDeliveryTime() + " dagen.");

        }
        Login.getInstance().resetLoggedInUser();
    }
}
