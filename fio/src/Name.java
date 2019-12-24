import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Name {
    public static void main(String[] args) {

        String fio;

        System.out.println("Введите Фамилию Имя Отчество");
        Scanner sFio = new Scanner(System.in);
        fio = sFio.nextLine();

        if (fio.indexOf(" ") == fio.lastIndexOf(" "))
        {
            System.out.println("madness");
        } else {

            String name = fio.substring(0, fio.indexOf(" "));
            String midName = fio.substring(fio.indexOf(" "), fio.lastIndexOf(" "));
            String lastName = fio.substring(fio.lastIndexOf(" "));
            System.out.println(lastName);
        }


        /*if (nameVal(fio)){
            String[] words = fio.split("\\s");
            lastName = words[0];
            name = words[1];
            midName = words[2];
            System.out.println("фамилия: " + lastName + '\n' + "имя: " + name + '\n' + "отчество: " + midName);
        }
        else {
            System.out.println("Неверный ввод");
        }
    }


    private static boolean nameVal(String fio){
        Pattern validFio = Pattern.compile("[А-Яа-яA-Za-z]+'\\s' [А-Яа-яA-Za-z]+'\\s' [А-Яа-яA-Za-z]+");
        Matcher trueFio = validFio.matcher(fio);
        return trueFio.matches();*/

    }
}
