import java.util.Scanner;
import java.util.TreeMap;

public class ContactList {
    private static TreeMap <String, String> contacts = new TreeMap<>();
    private static String inputString ;
    private static Scanner scanner;

    public static void main(String[] args) {
        contacts = new TreeMap<>();
        scanner = new Scanner(System.in);
        do {
            System.out.println("input name or phone number");
            inputString = scanner.nextLine().trim();
            if (inputString.equalsIgnoreCase("exit")){
                break;
            }
            if (inputString.equalsIgnoreCase("list")){
                if (!contacts.isEmpty()){
                    contacts.forEach((key, value) -> System.out.println(key + " " + value));
                } else {
                    System.out.println("Is empty");
                }
                continue;
            }
            if (isPhoneNumber(inputString)){
                checkAddUser();
            } else {
                checkAddNum();
            }
        } while (!inputString.equalsIgnoreCase("exit"));
        scanner.close();
    }

    private static boolean isPhoneNumber(String inputString){
        return inputString.matches("^\\W*\\d+.*");
    }
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
}
