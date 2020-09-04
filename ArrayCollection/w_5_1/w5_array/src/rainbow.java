public class rainbow {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String[] reveColors = text.split(",?\\s+");
        String[] colors = new String [reveColors.length];
        int b = 0;
        for (int i = reveColors.length - 1;i >= 0; i-- ){
            colors[b] = reveColors[i];
            b++;
        }

        for (int i = 0; i < colors.length; i++){
            System.out.println(colors[i]);


        }

    }
}
