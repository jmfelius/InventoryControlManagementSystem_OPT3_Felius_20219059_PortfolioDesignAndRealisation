package Delivery;

import java.text.SimpleDateFormat;
import java.time.LocalDate;


public class DateToday<dateobj> {

    public static String dateToday() {

        /* This will display the date and time in the format of
         * 12/09/2017 24:12:35. See the complete program below
         */
        SimpleDateFormat dateToday = new SimpleDateFormat("dd/MM/yy");
        LocalDate date = LocalDate.now();

        return dateToday.format(date);
    }
}
