import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToDoList {
    public static ArrayList<String> todoList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("command list \n " +
                "list - show task list\n " +
                "add \"number \" - create new task (can use without number)\n " +
                "edit \"number \" - use for edit task always use with number of task \n " +
                "del \"number \" - delete task number always use with number of task");

        for (;;) {
            //первое обработать ввод
            System.out.println("input command");
            Scanner commandIn = new Scanner(System.in);
            String commandInString = (commandIn.nextLine()).trim();
            Pattern pattern = Pattern.compile("(?i)(^LIST|^ADD|^EDIT|^DELETE)([\\s*\\d*\\s*]*)([^\1\2]*)");
            Matcher matcher = pattern.matcher(commandInString);

            String command = null;
            int positionNumber = 0;
            String todoText = null;

            while (matcher.find()){
                command = matcher.group(1).toUpperCase();
                positionNumber = posNum(matcher.group(2));
                todoText = matcher.group(3);
            }
            assert command != null;

            if (command.equals("LIST")){
                list();
            }
            if (command.equals("ADD")){
               add(positionNumber,todoText);
            }
            if (command.equals("EDIT")){
                edit(positionNumber,todoText);
            }
            if (command.equals("DEL")){

            }
            
        }


    }

    private static void list(){
            if (todoList.size() == 0){
                System.out.println("is empty use add command to create new");
            }else {
                for (int i = 0; i < todoList.size(); i++){
                    System.out.println("Task  № " + i + " "+ todoList.get(i));
                }
            }
    }

    private static int posNum(String posNum){
        int positionNumber;
        if (posNum.trim().length() == 0){
            positionNumber = todoList.size();
        }else{
            positionNumber = Integer.parseInt(posNum.trim());
        }
        return positionNumber;
    }
    private static boolean numberValue(int positionNumber){
        boolean numberValue = false;
        if(positionNumber > todoList.size()){
            numberValue = true;
        }
        return numberValue;
    }

    private static void add(int positionNumber,String todoText){
        if (numberValue(positionNumber)){
            positionNumber = todoList.size();
        }else {
            todoList.add(positionNumber,todoText);
        }
    }

    private static void edit (int positionNumber, String todoText){
        if (numberValue(positionNumber)){
            System.out.println(todoList.size() == 0 ? "is empty use add to create" : "task not found" );
        }else{
            todoList.remove(positionNumber);
            todoList.add(positionNumber, todoText);
            list();
        }

    }
    private static void delite (int positionNumber){
        if (numberValue(positionNumber)){
            System.out.println(todoList.size() == 0 ? "is empty use add to create" : "task not found" );
        }else {
            todoList.remove(positionNumber);
        }
    }


}
