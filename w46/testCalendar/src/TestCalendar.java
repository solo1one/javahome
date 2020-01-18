import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCalendar {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(calendar);
        System.out.println(calendar.getTime());
        calendar.add(Calendar.WEEK_OF_MONTH, 2);
        System.out.println(calendar.getTime());
        DateFormat dt = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println(dt.format(calendar.getTime()));

   }
}
