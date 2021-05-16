import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeliveryTest {

    Delivery delivery = new Delivery("01-04-2021", 1,null);

    @Test
    public void setExpectedDeliveryDate() {
    }
//Deze test werkt (nog) niet; nog nader uit te werken.
  /* @Test
    public void updateExpectedDeliveryDate()
    {
        Delivery delivery = new Delivery("01-05-2021",1,"PostNL");
        String date = "15-05-2021";
        Assert.assertEquals("Please insert new expected delivery date (dd-MM-yyyy): ", delivery.updateExpectedDeliveryDate("30-05-2021"));
   */

    @Test
    public void setActualDeliveryDate() {
    }

    @Test
    public void getActualDeliveryDate()
    {
        /**
         * Test obv Condition/Decision Coverage
         */
        delivery.setActualDeliveryDate("01-05-2021");
        Assert.assertEquals("01-05-2021", delivery.getActualDeliveryDate());
        delivery.setActualDeliveryDate("15-05-2021");
        Assert.assertEquals("15-05-2021", delivery.getActualDeliveryDate());
    }

    @Test
    public void getExpectedDeliveryDate()
    {
        // insert today's date for this test
        String date = "01-05-2021";

        delivery.setExpectedDeliveryDate("15-05-2021");
        Assert.assertEquals("15-05-2021", delivery.getExpectedDeliveryDate());

        delivery.setExpectedDeliveryDate("29-4-2021");
        Assert.assertEquals("29-4-2021", delivery.getExpectedDeliveryDate());

        delivery.setActualDeliveryDate("15-04-2021");
        delivery.setExpectedDeliveryDate("15-05-2021");
        Assert.assertEquals("The product has already been delivered on 15-04-2021", delivery.getExpectedDeliveryDate());
    }

    @Test
    public void getActualDeliveryTime() {
    }
}