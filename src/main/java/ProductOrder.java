import java.util.ArrayList;

public class ProductOrder
{
/**
 * ArrayList consisting of Supplier and TransportCie in order to establish
 * accumulated deliverytime (a productOrder requires Delivery)
 */
public ArrayList<Delivery> requires;

/**
 * a constructor is built with arrayList and ProductOrder parameters
 */
public ProductOrder(Customer customer, Product product, String orderDate)
{
    this.requires = new ArrayList<>();
    Supplier supplier = new Supplier(orderDate,1);
    TransportCie transportCie = new TransportCie(supplier.getExpectedDeliveryDate(), supplier.countryNumberSupplier,"PostNL");
    supplier.setExpectedDeliveryDate("30-5-2021");
    requires.add(supplier);
    requires.add(transportCie);
}

public int getTotalActualDeliveryTime()
{   
    int totalActualDeliveryTime = 0;
    for (Delivery delivery : requires)
    {
         totalActualDeliveryTime =+ (int)delivery.getActualDeliveryTime();
    }
    return totalActualDeliveryTime;
}

}
