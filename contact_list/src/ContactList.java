import java.util.Scanner;
import java.util.TreeMap;

public class ContactList {
    private static TreeMap <String, String> contacts = new TreeMap<>();
    //Ничего что я так глобально объявил сканнер, не хотелось его каждый раз прописывать в методах
    private static Scanner scanner;

    private static final String REG_NUMBER = "\\d+";
    private static final String REG_NAME = "\\D+\\d*";
    private static final String COMMAND_LIST = "list";
    private static final String COMMAND_EXIT = "exit";
    private static final String CONTACT_INFO_NUM_REGEX = "^\\W*\\d+.*";


    public static void main(String[] args) {
        contacts = new TreeMap<>();
        scanner = new Scanner(System.in);
        String inputString;
        System.out.println("Print exit to quit \nPrint list to show all contact's info");
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
                findOrAddUser(inputString);
            } else {
                findOrAddNum(inputString);
            }
        } while (!inputString.equalsIgnoreCase(COMMAND_EXIT));
        scanner.close();
    }

    private static boolean isPhoneNumber(String inputString){
        return inputString.matches(CONTACT_INFO_NUM_REGEX);
    }

    private static void findOrAddNum(String inputString){
        if (contacts.containsKey(inputString)){
            System.out.println("User number is " + contacts.get(inputString));
        } else {
            System.out.println("Number not found!\\n Input number to add");
            contacts.put(inputString,inputNumberCheck());
            System.out.println("Done");
        }
    }

    private static String inputNumberCheck (){
        for(;;){
            String inputStringNum = scanner.nextLine();
            if (inputStringNum.matches(REG_NUMBER)){
                return inputStringNum;
            } else {
                System.out.println("Error input Num");
            }
        }
    }

    private static void findOrAddUser(String inputString){
        inputString = inputString.replaceAll("\\D","");
        if (contacts.containsValue(inputString)){
            String finalInputString = inputString;
            // Почему он рекомендует кусок кода ниже как лямда вырфжение?
            contacts.forEach((key, value)-> {
                if(value.equals(finalInputString)){
                    System.out.println("User name is " + key);
                }
            });
        } else {
            System.out.println("Contact not found.\\n Please type new contact's name");
            contacts.put(inputNameCheck(),inputString);
            System.out.println("Done");
        }
    }

    private static String inputNameCheck (){
        for (;;){
            String inputName = scanner.nextLine();
            if (inputName.matches(REG_NAME)){
                return inputName;
            }else {
                System.out.println("error Name must contains at least three letters and name can't have any digits ");
            }
        }
    }

    private static void printBook(){
        if (!contacts.isEmpty()){
            contacts.forEach((key, value) -> System.out.println("name: " + key + " number: " + value));
        } else { System.out.println("Is empty");
        }
    }
}
