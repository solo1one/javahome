import java.util.Scanner;

public class Cross {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите любое натуральное число");

        int in = scanner.nextInt();
        int x = in;
        int y = in;
        System.out.println(x + " x " + y + " y ");

        String[][] cross = new String[x][y];
        for (y = 0; y < in; y++) {
            for (x = 0; x < in; x++) {
                if (x == y || (x + y + 1 == in)) {
                    cross[x][y] = "x";
                } else {
                    cross[x][y] = " ";
                }
                System.out.print(cross[x][y]);
            }
            System.out.println();
        }
    }
}
