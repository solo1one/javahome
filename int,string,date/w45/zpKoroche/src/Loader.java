public class Loader {
    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        System.out.println(text);

        //////////////////////////////////////////////////////////////////////////////////////////////////

        String[] money = text.replaceAll("[^0-9,]","").split(",");
        int[] moneyInt = new int[money.length];
        int totalMoney = 0;
        int sum = 0;

        for (int i = 0; i < moneyInt.length; i++ ){
            moneyInt[i] = Integer.parseInt(money[i]);
            sum += moneyInt[i];
        }

        System.out.println("Вместе они заработали " + sum);
        
    }
}
