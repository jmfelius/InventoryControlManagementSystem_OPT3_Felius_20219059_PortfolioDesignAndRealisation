public class Main {

    public static void main(String[] args) {
        Login.getInstance().isAuthenticated();
        if (Login.getInstance().isAuthenticated()) {
            Customer customer = new Customer();
            Product product = new Product();
            ProductOrder productOrder = new ProductOrder(customer,product,"1-4-2021");

            //TODO execute methods
        }
        Login.getInstance().resetLoggedInUser();
    }
}
