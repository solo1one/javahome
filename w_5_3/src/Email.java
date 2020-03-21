import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    static private final String VALID_EMAIL = "^[A-Za-z0-9+_.-]+@(.+)$ ";
    static private HashSet<String> emailList = new HashSet<>();

    public static void main(String[] args) {

        for (;;){
            Scanner scanner = new Scanner(System.in);
            String commandByScanner = scanner.nextLine();

            if (validEmail(commandByScanner)){
                emailList.add(commandByScanner);
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
        boolean check = false;

        Pattern p = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
        Matcher m = p.matcher(commandByScanner);
        if(m.find()){
            check = true;
        }
        return check;
    }


}


//    Написать программу, в которой будет храниться перечень e-mail-ов. E-mail’ы  можно добавлять через консоль командой ADD и печатать весь список командой LIST.
//     * Проверять корректность вводимых e-mail’ов и в случае необходимости печатать сообщение об ошибке.