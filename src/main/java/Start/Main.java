package Start;

import Data.*;
import Delivery.ProductOrder;
import Delivery.Transport;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean programmRunning = true;

        if (Login.getInstance().isAuthenticated()) {

            while (programmRunning) {

                Scanner scanner = new Scanner(System.in);

                Customer customer1 = new Customer();
                System.out.println("Please insert customer name");
                customer1.setName(scanner.nextLine());
                Product product1 = new Product();
                System.out.println("Please insert product name: ");
                product1.setName(scanner.nextLine()) ;

                ProductOrderData orderData = new ProductOrderData(product1, customer1);

                System.out.println("Please insert order date (dd-mm-yyyy): ");
                String orderDate = scanner.nextLine();
                System.out.println("Please insert expected delivery date supplier  (dd-mm-yyyy): ");
                String deliveryDateSupplier = scanner.nextLine();
                System.out.println("Please insert express delivery true or false: ");
                Boolean expressDelivery = scanner.nextBoolean();
                TransportCompany transportCompany = new TransportCompany();
                System.out.println("please insert name transportcie: ");
                scanner.nextLine();
                String naam = scanner.nextLine();
                transportCompany.setName(naam);
                transportCompany.setCountryNumber(1);
                SupplierCompany supplierCompany = new SupplierCompany();
                System.out.println("Please insert country number supplier: ");
                int number = scanner.nextInt();
                scanner.nextLine();
                supplierCompany.setCountryNumber(number);

                ProductOrder productOrder = new ProductOrder(orderDate, deliveryDateSupplier, supplierCompany, transportCompany, orderData);
                System.out.println("The order date (orderDate) is: " + orderDate);
                System.out.printf("The expected delivery date of %s ordered by %s is: %s \n", product1.getName(), customer1.getName(), productOrder.getExpectedDeliveryDate());
                System.out.println("The total delivery time is: " + productOrder.getTotalActualDeliveryTime() + " dagen.");
                System.out.println("Do you wish to continue y/n?");
                String yesno = scanner.nextLine();
                programmRunning = yesno.equals("y");
            }
            System.out.println("The programm terminates; thank you.");
            Login.getInstance().resetLoggedInUser();
        }
    }
}


