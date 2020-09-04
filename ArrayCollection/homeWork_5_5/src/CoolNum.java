import java.util.*;

public class CoolNum {

    private static final ArrayList<String> baseOfNumbers = new ArrayList<>();
    private static final HashSet<String> baseOfNumbersHash = new HashSet<>();
    private static final TreeSet<String> baseOfNumbersTree = new TreeSet<>();

    public static void main(String[] args) {

        generateNumbers();
        for (; ; ) {
            String userInput = userInput();

            directSearching(userInput);
            binarySearching(userInput);
            hashSetSearching(userInput);
            treeSetSearching(userInput);
        }
    }

    public static String userInput() {
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            System.out.print("Введи номер: ");
            String input = scanner.nextLine();
            if (input.matches("^[A-Я][0-9]+[A-Я]{2}[0-9]{2,3}")) {
                return input;
            }
            System.out.println("Неправильный формат ввода." +
                    "\n ПРИМЕР: А111АА111");
        }
    }

    private static void generateNumbers() {
        String[] letters = {"А","В","Е","К","М","Н","О","Р","С","Т","У","Х"};
        String region;
        String[] number = {"000","111","222","333","444","555","666","777","888","999"};

        for (String numberInLoop : number) {
            for (int reg = 1; reg <= 199; reg++) {
                for (String letter : letters) {
                    for (String letterSecond : letters) {
                        for (String letterThird : letters) {
                            region = Integer.toString(reg);
                            if (reg < 10) {
                                region = "0" + reg;
                            }
                            baseOfNumbers.add(letter + numberInLoop + letterSecond + letterThird + region);
                        }
                    }
                }
            }
        }
    }

    private static void directSearching(String input) {
        long start = System.nanoTime();
        long end;
        if (baseOfNumbers.contains(input)) {
            end = System.nanoTime() - start;
            System.out.println("Поиск перебором: " + "номер найден, поиск занял: " + end + " нс.");

        } else {
            end = System.nanoTime() - start;
            System.out.println("Поиск перебором: " + "номер не найден, поиск занял: " + end + " нс.");
        }
    }

    private static void binarySearching(String input) {
        Collections.sort(baseOfNumbers);
        long start = System.nanoTime();
        long end;
        if (Collections.binarySearch(baseOfNumbers, input) >= -1) {
            end = System.nanoTime() - start;
            System.out.println("Бинарный поиск: " + "номер найден, поиск занял: " + end + " нс.");
        } else {
            end = System.nanoTime() - start;
            System.out.println("Бинарный поиск: " + "номер не найден, поиск занял: " + end + " нс.");
        }
    }

    private static void hashSetSearching(String input){
        baseOfNumbersHash.addAll(baseOfNumbers);
        long start = System.nanoTime();
        long end;
        if (baseOfNumbersHash.contains(input)) {
            end = System.nanoTime() - start;
            System.out.println("Поиск в HashSet: " + "номер найден, поиск занял: " + end + " нс.");

        } else {
            end = System.nanoTime() - start;
            System.out.println("Поиск в HashSet: " + "номер не найден, поиск занял: " + end + " нс.");
        }
    }

    private static void treeSetSearching(String input){
        baseOfNumbersTree.addAll(baseOfNumbers);
        long start = System.nanoTime();
        long end;
        if (baseOfNumbersTree.contains(input)) {
            end = System.nanoTime() - start;
            System.out.println("Поиск в TreeSet: " + "номер найден, поиск занял: " + end + " нс.");

        } else {
            end = System.nanoTime() - start;
            System.out.println("Поиск в TreeSet: " + "номер не найден, поиск занял: " + end + " нс.");
        }
    }
}