public class Main {

    public static void main(String[] args) {

        if (Login.getInstance().isAuthenticated()) {
            Customer customer = new Customer();
            Product product = new Product();
            ProductOrder productOrder = new ProductOrder(customer,product,"1-4-2021");
            System.out.println("de if functie in main wordt uitgevoerd; diverse methoden moeten nog worden geimplementeerd.");
            System.out.println(productOrder.getTotalActualDeliveryTime());

            //TODO execute methods
        }
        Login.getInstance().resetLoggedInUser();
    }
}
