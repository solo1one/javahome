import javax.swing.*;
import java.util.Scanner;
import java.util.TreeMap;

public class ContactList {
    private static TreeMap <String, String> contacts = new TreeMap<>();
    private static String inputString ;
    private static Scanner scanner;

    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_EXIT = "exit";
    private static final String REG_PHONE_NUMBER = "^\\W*\\d+.*";


    public static void main(String[] args) {
        contacts = new TreeMap<>();
        scanner = new Scanner(System.in);
        do {
            System.out.println("input name or phone number");
            inputString = scanner.nextLine().trim();
            if (inputString.equalsIgnoreCase(COMMAND_EXIT)){
                break;
            }
            if (inputString.equalsIgnoreCase(COMMAND_LIST)){
                printBook();
                continue;
            }
            if (isPhoneNumber(inputString)){
                checkAddUser();
            } else {
                checkAddNum();
            }
        } while (!inputString.equalsIgnoreCase(COMMAND_EXIT));
        scanner.close();
    }



    private static boolean isPhoneNumber(String inputString){
        return inputString.matches(REG_PHONE_NUMBER);
    }
    //мне нужно разбить мои методы на более мелкие и вызывать проверку того введено имя для случая если номер не найден
    // и аналогично для случая когда не найдено имя и проверять является введеное номером ?
    private static void checkAddNum(){
        if (contacts.containsKey(inputString)){
            System.out.println("User number is " + contacts.get(inputString));
        } else {
            System.out.println("Number not found!\\n Input number to add");
            String phoneNumber = scanner.nextLine().trim().replaceAll("\\D","");
            contacts.put(inputString,phoneNumber);
            System.out.println("Done");
        }
    }
    private static void checkAddUser(){
        inputString = inputString.replaceAll("\\D","");
        if (contacts.containsValue(inputString)){
            contacts.forEach((key, value)-> {
                if(value.equals(inputString)){
                    System.out.println("User number is" + key);
                }
            });
        } else {
            System.out.println("Name not found.\\n Please type the user's name");
            String name = scanner.nextLine().trim();
            contacts.put(name,inputString);
            System.out.println("Done");
        }
    }

    private static void printBook(){
        if (!contacts.isEmpty()){
            contacts.forEach((key, value) -> System.out.println(key + " " + value));
        } else {
            System.out.println("Is empty");
        }

    }
}
