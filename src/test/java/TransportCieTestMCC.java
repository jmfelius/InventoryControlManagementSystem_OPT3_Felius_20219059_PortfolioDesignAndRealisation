import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TransportCieTestMCC
{
    /**
     * Method to determine standard delivery times based on standard Boolean countrySupplier number 1 through 10 or 11 and higher,
     * Boolean expressDelivery and Boolean PostNL (countryNumber||express)&PostNL
     * NL | express| PostNL| result (1 day is 1, 3 days is 0)
     * ____________________________________________
     * 0  |   0    |    0  |   0
     * 0      0         1      0
     * 0      1         0      0
     * 0      1         1      1
     * 1      0         0      0
     * 1      0         1      1
     * 1      1         0      0
     * 1      1         1      1
     *
     */

    @Test
    public void express() {
        TransportCie transportCie = new TransportCie("01-04-2021", 1, "PostNL");

        assertFalse(transportCie.express(15, false, "DHL"));
        assertFalse(transportCie.express(15, false, "PostNL" ));

        assertFalse(transportCie.express(15, true, "DHL"));
        assertTrue(transportCie.express(15, true, "PostNL" ));

        assertFalse(transportCie.express(5, false, "DHL"));
        assertTrue(transportCie.express(5, false, "PostNL" ));

        assertFalse(transportCie.express(5, true, "DHL"));
        assertTrue(transportCie.express(5, true, "PostNL" ));
    }


}
