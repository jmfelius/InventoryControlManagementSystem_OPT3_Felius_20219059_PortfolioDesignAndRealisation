import org.junit.Assert;
import org.junit.Test;

public class DeliveryTest {

    //Delivery delivery = new Delivery("01-04-2021", 1,null);
    Supplier supplier = new Supplier("01-04-2021", 1);

    @Test
    public void setExpectedDeliveryDate() {
    }

  @Test
    public void updateExpectedDeliveryDate() {
      //Deze test werkt (nog) niet; nog nader uit te werken.
  }


    @Test
    public void setActualDeliveryDate() {
    }

    @Test
    public void getActualDeliveryDate()
    {
        /**
         * Test obv Condition/Decision Coverage
         */
        supplier.setActualDeliveryDate("01-05-2021");
        Assert.assertEquals("01-05-2021", supplier.getActualDeliveryDate());
        supplier.setActualDeliveryDate("15-05-2021");
        Assert.assertEquals("15-05-2021", supplier.getActualDeliveryDate());
    }

    @Test
    public void getExpectedDeliveryDate()
    {
        // insert today's date for this test
        String date = "01-05-2021";

        supplier.setExpectedDeliveryDate("15-05-2021");
        Assert.assertEquals("15-05-2021", supplier.getExpectedDeliveryDate());

        supplier.setExpectedDeliveryDate("29-4-2021");
        Assert.assertEquals("29-4-2021", supplier.getExpectedDeliveryDate());

        supplier.setActualDeliveryDate("15-04-2021");
        supplier.setExpectedDeliveryDate("15-05-2021");
        Assert.assertEquals("The product has already been delivered on 15-04-2021", supplier.getExpectedDeliveryDate());
    }

    @Test
    public void getActualDeliveryTime() {
    }
}