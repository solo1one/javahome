public class Loader {
    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        System.out.println(text);

        //////////////////////////////////////////////////////////////////////////////////////////////////


        int moneyVasya;
        int moneyPetya;
        int moneyMasha;
        int totalSumm;

        String vas = text.substring((text.indexOf(' ') + 1),(text.indexOf("рубл")));
        moneyVasya = Integer.parseInt(vas.substring(vas.indexOf(' ')).trim());

        String pet = text.substring((text.indexOf('-') + 2),(text.indexOf("рубля")-1));
        moneyPetya = Integer.parseInt(pet);

        moneyMasha = Integer.parseInt(text.substring((text.lastIndexOf('-') + 2),text.lastIndexOf("рублей")-1));
        //правильно ли так собирать все в одну строку (в плане читаемости)

        totalSumm = moneyMasha + moneyPetya + moneyVasya;
        System.out.println("Вместе они заработали " + totalSumm);
    }
}
