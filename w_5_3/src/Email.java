import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    static private final String VALID_EMAIL = "^(?i)ADD\\s[A-Za-z0-9+_.-]+@(.+)$";
    static private HashSet<String> emailList = new HashSet<>();

    public static void main(String[] args) {

        for (;;){
            Scanner scanner = new Scanner(System.in);
            String commandByScanner = scanner.nextLine();

            if (validEmail(commandByScanner)){
                emailList.add(commandByScanner.substring(3).trim());
            }else if (commandByScanner.equalsIgnoreCase("list")){
                for (String word : emailList){
                    System.out.println(word);
                }
            }else {
                System.out.println("ERROR");
            }
        }
    }

    public static boolean validEmail(String commandByScanner){
        return commandByScanner.matches(VALID_EMAIL);
    }

}


//    Написать программу, в которой будет храниться перечень e-mail-ов. E-mail’ы  можно добавлять через консоль командой ADD и печатать весь список командой LIST.
//     * Проверять корректность вводимых e-mail’ов и в случае необходимости печатать сообщение об ошибке.