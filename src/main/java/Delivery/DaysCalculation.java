package Delivery;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public interface DaysCalculation {
    /**
     * Determining days in between dates;
     * Source for count days: https://stackoverflow.com/questions/20165564/calculating-days-between-two-dates-with-java
     * various contributors
     */
    default long getDifferenceDays(String date1, String date2)
    {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");

        long days = 0;

        try {
            Date d1 = myFormat.parse(date1);
            Date d2 = myFormat.parse(date2);

            long diff = d2.getTime() - d1.getTime();
            days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return days;
    }

    /** determining targetdate after adding days to a date
     * Source: Beginnersbook.com; https://beginnersbook.com/2017/10/java-add-days-to-date/#3
     */
    default String addDaysToDate (String orderDate, int transportDays)
    {
        String oldDate = orderDate;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar c = Calendar.getInstance();
        try{
            c.setTime(sdf.parse(orderDate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        //Incrementing the date by x days
        c.add(Calendar.DAY_OF_MONTH, transportDays);
        String newDate = sdf.format(c.getTime());
        return newDate;
    }
}
