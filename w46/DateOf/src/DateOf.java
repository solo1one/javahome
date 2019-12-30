import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateOf {

    public static void main(String[] args) {

        LocalDate birthday = LocalDate.of(1992, 1, 24);
        LocalDate nextBirthday = birthday;

        Period p = Period.between(birthday, LocalDate.now());

        for (int i = 0; i <= p.getYears() - 1; i++) {
            nextBirthday = nextBirthday.plusYears(1);
            System.out.println((i + 1) + "й день рождения " + nextBirthday.format(DateTimeFormatter.ofPattern("dd MMMM yyyy года - EEEE")));
        }
    }
}
