public class charNum {

    public static void main(String[] args) {

            for (char i = 'A'; i <= 'я'; i++) {
                if (i == ('Z' + 1)) {
                    i = 'a';
                }

                if (i == ('z' + 1)) {
                    i = 'А';
                }

                if (i == ('Ж')) {
                    i = 'Ё';
                    System.out.println(i + " - " + (int) i);
                    i = 'Ж';
                }// не придумал ничего с буквой Ё, вот такой костыль

                if (i == ('ж')) {
                    i = 'ё';
                    System.out.println(i + " - " + (int) i);
                    i = 'ж';
                }

               
                System.out.println(i + " - " + (int) i);
            }
        }
    }
