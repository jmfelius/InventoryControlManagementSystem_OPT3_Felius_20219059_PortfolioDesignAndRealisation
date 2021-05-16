import java.util.ArrayList;

public class ProductOrder
{
/**
 * ArrayList consisting of Supplier and TransportCie in order to establish
 * accumulated deliverytime (a productOrder requires
 */
public ArrayList<Delivery> requires;

/**
 * a constructor is built with arayList and Productorder parameters
 */
public ProductOrder(Customer customer, Product product, String orderDate)
{
    this.requires = new ArrayList<>();
}

public int getTotalActualDeliveryTime()
{
    //to be further constructed
    return 0;
}

}
