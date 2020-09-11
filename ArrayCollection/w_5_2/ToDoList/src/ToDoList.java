import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToDoList {

    static private final String COMMAND_ADD = "(?i)^ADD\\s[А-Яа-яA-Za-z]";
    static private final String COMMAND_ADD_TO_INDEX = "(?i)^ADD\\s\\d+\\s[А-Яа-яA-Za-z]";
    static private final String COMMAND_EDIT = "(?i)^EDIT\\s\\d+\\s[А-Яа-яA-Za-z]";
    static private final String COMMAND_DELETE = "(?i)^DELETE\\s\\d+";
    static private final String COMMAND_LIST = "(?i)LIST";
    static private final String MAN_MAN = "(?i)MAN";

    static private ArrayList<String> toDoList = new ArrayList<>();


    public static void main(String[] args) {

        System.out.println("use MAN to see  command list");

        for (; ; ) {
            Scanner scanner = new Scanner(System.in);
            String commandByScanner = scanner.nextLine();
            if (getValueToString(commandByScanner, MAN_MAN)) {
                printMan();
            } else {
                setChangeToArrayList(commandByScanner);
            }
        }
    }

// как вы советовали вытащил определение комманды из цикла
    static private void setChangeToArrayList(String command) {
        if (getValueToString(command, COMMAND_LIST)) {
            printToDoList();
        } else if (getValueToString(command, COMMAND_ADD)) {
            addToArrayList(command);
        } else if (getValueToString(command, COMMAND_ADD_TO_INDEX)) {
            AddToArrayListByIndex(command);
        } else if (getValueToString(command, COMMAND_EDIT)) {
            editToArrayListByIndex(command);
        } else if (getValueToString(command, COMMAND_DELETE)) {
            deleteToArrayListByIndex(command);
        } else {
            System.out.println("WRONG COMMAND");
        }
    }

    static private boolean getValueToString(String string, String pattern) {
        boolean check = false;
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(string);
        if (m.find()) {
            check = true;
        }
        return check;
    }

    static private void addToArrayList(String command) {
        String clearString = textThisCommand(command, ToDoList.COMMAND_ADD);
        toDoList.add(clearString);
    }

    static private void AddToArrayListByIndex(String command) {
        String clearString = textThisCommand(command, ToDoList.COMMAND_ADD_TO_INDEX);
        int indexTask = numberIndexThisCommand(command)-1;

        if (indexTask < toDoList.size()) {
            toDoList.add(indexTask, clearString);
        } else {
            System.out.println(indexTask + " added to end");
            toDoList.add(clearString);
        }
    }

    static private void editToArrayListByIndex(String command) {
        String clearString = textThisCommand(command, ToDoList.COMMAND_EDIT);
        int indexTask = numberIndexThisCommand(command)-1;

        if (indexTask < toDoList.size()) {
            toDoList.add(indexTask, clearString);
            toDoList.remove(indexTask + 1);
        } else {
            System.out.println("Task number " + indexTask+1 + " not found");
        }
    }

    static private void deleteToArrayListByIndex(String command) {
        int indexTask = numberIndexThisCommand(command)-1;
        if (indexTask < toDoList.size()) {
            toDoList.remove(indexTask);
        } else {
            System.out.println("Task number " + indexTask+1 + "not found");
        }
    }

    static private void printToDoList() {
        if (toDoList.size() == 0)
        {
            System.out.println("Empty");
        }
        for (int i = 0; i < toDoList.size(); i++) {
            System.out.println(i+1 + " " + toDoList.get(i));
        }
    }

    static private void printMan() {
        System.out.println("command list \n " +
                "add - to add task in end of list \n " +
                "add by index - add in specialize list position \n " +
                "delete by index - delete task by number \n" +
                "edit by index - to edit task with number \n " +
                "list - to see task list" +
                "man - to see that again " );
    }



    static private String textThisCommand(String command, String pattern) {
        String clearText = "";
        if (pattern.equals(COMMAND_ADD)) {
            clearText = command.substring(command.indexOf(" ") + 1);
        }
        if (pattern.equals(COMMAND_ADD_TO_INDEX)) {
            clearText = command.substring(command.indexOf(" "));
            clearText = clearText.trim();
            clearText = clearText.substring(clearText.indexOf(" "));
            System.out.println(clearText);
        }
        if (pattern.equals(COMMAND_EDIT)) {
            clearText = command.substring(command.indexOf(" "));
            clearText = clearText.trim();
            clearText = clearText.substring(clearText.indexOf(" "));
        }
        return clearText.trim();
    }


    static private int numberIndexThisCommand(String command) {
        int numberIndex;
        String string = command.substring(command.indexOf(" ")).trim();
        string += " ";
        numberIndex = Integer.parseInt(string.substring(0, string.indexOf(" ")));
        if (numberIndex == 0)
        {
            numberIndex = 1;
        }
        return numberIndex;
    }
}
