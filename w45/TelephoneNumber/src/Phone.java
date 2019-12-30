import java.util.Scanner;

public class Phone {
    public static void main(String[] args) {

        for(;;) {

            Scanner inputNum = new Scanner(System.in);
            System.out.println("введиде номер мобильного телефона");
            String num = inputNum.nextLine().replaceAll("[^0-9]","");

            String numTen;

            if (num.length() >= 10 && num.length() <= 11) {
                numTen = num.substring(num.length()-10);
                System.out.println("телефон" + "+7"+ "(" + numTen.substring(0,3) +")"+ numTen.substring(3,6)+ "-" + numTen.substring(6,8) + "-" + numTen.substring(8) );
            } else {
                System.out.println("ОШИБКА! В мобильных номерах РФ должно быть 10-11 цифр");
            }


        }

    }
}
