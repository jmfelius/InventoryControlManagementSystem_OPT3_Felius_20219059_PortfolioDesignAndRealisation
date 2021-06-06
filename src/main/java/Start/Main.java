package Start;

import Delivery.ProductOrder;
import Data.Customer;
import Data.Product;
import Start.Login;

public class Main {

    public static void main(String[] args) {

        if (Login.getInstance().isAuthenticated()) {

            String orderDate = "15-4-2021";
            String deliveryDateSupplier = "30-5-2021";
            int countryNumber = 1;
            String nameTransportCie = "DHL";
            Boolean expressDelivery = false;
            Customer customer = new Customer();
            Product product = new Product();
            ProductOrder productOrder = new ProductOrder(customer, product, orderDate, deliveryDateSupplier, countryNumber, nameTransportCie, expressDelivery);
            System.out.println("The order date (orderDate) is: " + orderDate);
            System.out.println(("The expected delivery date (getExpectedDeliveryDate) is: " + productOrder.getExpectedDeliveryDate()));
            System.out.println("The total delivery time (getTotalActualDeliveryTime) is: " + productOrder.getTotalActualDeliveryTime() + " dagen.");

        }
        Login.getInstance().resetLoggedInUser();
    }
}
