package Delivery;

import Data.*;

import java.util.ArrayList;
public class ProductOrder {

    /**
     * ArrayList consisting of Delivery.Delivery.Supplier and Delivery.Delivery.TransportCie in order to establish
     * accumulated deliverytime (a productOrder requires Delivery.Delivery)
     */
    public ArrayList<Delivery> deliveries;
    private Boolean express;
    private SupplierCompany supplierCompany;
    private TransportCompany transportCompany;
    private Product product;
    private Customer customer;
    String orderDate;
    String deliveryDateSupplier;




    /**
     * a constructor is built with arrayList and Delivery.ProductOrder parameters
     */
    public ProductOrder(String orderDate, String deliveryDateSupplier, boolean expressDelivery) {

        supplierCompany = new SupplierCompany();
        transportCompany = new TransportCompany();
        product = new Product();
        customer = new Customer();
        this.orderDate = orderDate;
        this.deliveryDateSupplier = deliveryDateSupplier;
        this.express = expressDelivery;

        this.deliveries = new ArrayList<>();


    }

    public void setArayListDeliveries(){

        Delivery supplier = new Supplier(orderDate, supplierCompany.getCountryNumber());
        supplier.setExpectedDeliveryDate(deliveryDateSupplier);
        Delivery transport = new Transport (supplier.getExpectedDeliveryDate(), supplierCompany.getCountryNumber(), transportCompany.getName(),express);

        deliveries.add(supplier);
        deliveries.add(transport);
    }

    public Product getProduct() {
        return product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public TransportCompany getTransportCompany() {
        return transportCompany;
    }

    public void setTransportCompany(TransportCompany transportCompany) {
        this.transportCompany = transportCompany;
    }

    public SupplierCompany getSupplierCompany() {
        return supplierCompany;
    }

    public void setSupplierCompany(SupplierCompany supplierCompany) {
        this.supplierCompany = supplierCompany;
    }

    public int getTotalActualDeliveryTime() {

        int totalActualDeliveryTime = 0;

        for (Delivery delivery : deliveries) {
             totalActualDeliveryTime += (int)delivery.getActualDeliveryTime();
        }
        return totalActualDeliveryTime;
    }

    public String getExpectedDeliveryDate() {

        return deliveries.get(getSize()-1).getExpectedDeliveryDate();
    }

    private int getSize() {
        return deliveries.size();
    }

}
