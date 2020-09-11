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
            } else {
                findOrAddContactInfo(inputString);}

        } while (!inputString.equalsIgnoreCase(COMMAND_EXIT));
        scanner.close();
    }

// решил так же вытащить конструкцию  из цикла но кажется название метода выбрал не совсем правильное есть какие замечания ?
    private static void findOrAddContactInfo(String inputString){
        if (isPhoneNumber(inputString)){
        if (userExist(inputString)){
            showUser(inputString);
        }else {
            addUser(inputString);
        }
    } else {
        if(numberExist(inputString)){
            showNum(inputString);
        } else {
            addNum(inputString);
        }
    }

    }

    private static boolean isPhoneNumber(String inputString){
        return inputString.matches(CONTACT_INFO_NUM_REGEX);
    }
// В таких ситуациях стоит создавать отдельный метод или стоит просто использовать ".contains" и подобные ему методы без лишней писанины ?
// вроде код становится понятнее но его становится больше.
    private static boolean userExist(String inputString) {
        if (contacts.containsValue(inputString)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean numberExist(String inputString){
        if (contacts.containsKey(inputString)){
            return true;
        } else {
            return false;
        }
    }
    //Разделил как вы порекомендовали
    private static void showNum(String inputString){
        System.out.println("User number is " + contacts.get(inputString));
    }

    private static void addNum(String inputString){
            System.out.println("Number not found!\\n Input number to add");
            contacts.put(inputString,inputNumberCheck());
            System.out.println("Done");
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
//Разделил как вы порекомендовали
    private static void showUser(String inputString){
        inputString = inputString.replaceAll("\\D","");
            String finalInputString = inputString;
            contacts.forEach((key, value)-> {
                if(value.equals(finalInputString)){
                    System.out.println("User name is " + key);
                }
            });

    }
    private static void addUser(String inputString){
        System.out.println("Contact not found.\\n Please type new contact's name");
        contacts.put(inputNameCheck(),inputString);
        System.out.println("Done");
    }

    private static String inputNameCheck (){
        for (;;){
            String inputName = scanner.nextLine();
            if (inputName.matches(REG_NAME)){
                return inputName;
            }else {
                System.out.println("error Name must contains letters and name can't start at digits ");
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
