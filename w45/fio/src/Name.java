import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Name {
    public static void main(String[] args) {

        String fio;
        int i = 0;


        for (;;) {
            System.out.println("Введите Фамилию Имя Отчество");
            Scanner sFio = new Scanner(System.in);
            fio = (sFio.nextLine()).trim();

            for (int j = 0; j < fio.length(); j++) {
                char a = fio.charAt(j);
                if (a == ' ') {
                    i++;
                }
            }
            if (i != 2) {
                System.out.println("неправильный формат ввода");
            }
            else {
                String[] words = fio.split("\\s");
                System.out.println("фамилия: " + words[0] + '\n' + "имя: " + words[1]  + '\n' + "отчество: " + words[2]);
                break;
            }

        }
    }

}

