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
                System.out.println("Please insert customer name");
                String customerName = scanner.nextLine();
                System.out.println("Please insert product name: ");
                String productName = scanner.nextLine();
                System.out.println("Please insert order date (dd-mm-yyyy): ");
                String orderDate = scanner.nextLine();
                System.out.println("Please insert expected delivery date supplier  (dd-mm-yyyy): ");
                String deliveryDateSupplier = scanner.nextLine();
                System.out.println("Please insert express delivery true or false: ");
                Boolean expressDelivery = scanner.nextBoolean();

                ProductOrder productOrder = new ProductOrder(orderDate, deliveryDateSupplier,expressDelivery);

                productOrder.getProduct().setName(productName) ;
                productOrder.getCustomer().setName(customerName);

                System.out.println("please insert name transportcie: ");
                productOrder.getTransportCompany().setName(scanner.nextLine());
                productOrder.getTransportCompany().setCountryNumber(1);
                System.out.println("Please insert country number supplier: ");
                productOrder.getSupplierCompany().setCountryNumber(scanner.nextInt());
                scanner.nextLine();
                productOrder.setArayListDeliveries();

                System.out.println("The order date (orderDate) is: " + orderDate);
                System.out.printf("The expected delivery date of %s ordered by %s is: %s \n", productOrder.getProduct().getName(), productOrder.getCustomer().getName(), productOrder.getExpectedDeliveryDate());
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


