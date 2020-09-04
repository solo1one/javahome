import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateOf {

    public static void main(String[] args) {

        LocalDate birthday = LocalDate.of(1992, 1, 24);
        LocalDate nextBirthday = birthday;
        LocalDate today = LocalDate.now();
        int numberBd = 0;
        DateTimeFormatter printFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy", new Locale("ru"));

        while(today.isAfter(nextBirthday)) {
            System.out.println((numberBd++ ) + "й день рождения " + nextBirthday.format(DateTimeFormatter.ofPattern("dd MMMM yyyy года - EEEE", new Locale("ru"))));
            nextBirthday = nextBirthday.plusYears(1);


                if (today.isBefore(nextBirthday))break;
        }



    }
}
