import java.util.Scanner;


public class Name {
    public static void main(String[] args) {

        String fio ;
        String name;
        String lastName;
        String midName;

        System.out.println("Введите Фамилию Имя Отчество");
        Scanner sFio = new Scanner(System.in);
        fio = sFio.nextLine();

        String[] words = fio.split("\\s");
        lastName = words[0];
        name = words[1];
        midName = words[2];

        System.out.println("фамилия: " + lastName +'\n'+ "имя: " + name + '\n' + "отчество: " + midName );





    }
}
