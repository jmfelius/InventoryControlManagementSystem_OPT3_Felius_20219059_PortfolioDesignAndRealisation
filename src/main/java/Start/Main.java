package Start;

import Delivery.ProductOrder;
import Data.Customer;
import Data.Product;
import Data.SupplierCompany;
import Data.TransportCompany;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        while (Login.getInstance().isAuthenticated()) {

            Scanner scanner = new Scanner(System.in);

            String orderDate = "15-4-2021";
            System.out.println("Please insert order date (dd-mm-yyyy): ");
            //String orderDate = scanner.nextLine();
            System.out.println("Please insert expected delivery date supplier  (dd-mm-yyyy): ");
            String deliveryDateSupplier = "30-5-2021";
            //String deliveryDateSupplier = scanner.nextLine();
            System.out.println("Please insert express delivery true or false: ");
            //boolean expressDelivery = false;
            Boolean expressDelivery = scanner.nextBoolean();
            Customer customer = new Customer();
            customer.setName("Jansen");
            Product product = new Product();
            product.setName("Pegasus");
            TransportCompany transportCompany = new TransportCompany();
            System.out.println("please insert name transportcie: ");
            //scanner.nextLine();
            //String naam = scanner.nextLine();
            String naam = "PostNL";
            transportCompany.setName(naam);
            transportCompany.setCountryNumber(1);
            SupplierCompany supplierCompany = new SupplierCompany();
            System.out.println("please insert name supplier: ");
            //String naam1 = scanner.nextLine();
            //supplierCompany.setName(naam1);
            String naam1 = "Nike";
            System.out.println("Please insert country number supplier: ");
            int number = scanner.nextInt();
            supplierCompany.setCountryNumber(number);
            //supplierCompany.setCountryNumber(1);

            ProductOrder productOrder = new ProductOrder(customer, product, orderDate, deliveryDateSupplier, supplierCompany, transportCompany, expressDelivery);
            System.out.println("The order date (orderDate) is: " + orderDate);
            System.out.println(("The expected delivery date (getExpectedDeliveryDate) is: " + productOrder.getExpectedDeliveryDate()));
            System.out.println("The total delivery time (getTotalActualDeliveryTime) is: " + productOrder.getTotalActualDeliveryTime() + " dagen.");
            System.out.println("Do you wish to continue y/n?");
            String yesno = scanner.nextLine();
            scanner.nextLine();
            if (!yesno.equalsIgnoreCase("y")) {
                Login.getInstance().resetLoggedInUser();
            }
        }

    }
}

