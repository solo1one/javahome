public class Words {
    public static void main(String[] args) {
        String lorem = " Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Maecenas risus sem, scelerisque sit amet ornare sit amet, porttitor vitae ipsum. " +
                "Cras egestas molestie nulla ac tristique. In porttitor accumsan leo eget interdum. " +
                "Integer accumsan tellus mattis tempus elementum. Vivamus scelerisque, nisl ut elementum elementum, enim nibh placerat risus, quis scelerisque erat erat vel dolor." +
                " Mauris nisi augue, venenatis vel viverra vel, efficitur dictum libero. Sed tristique erat at nisi porttitor pretium. Duis vehicula ornare hendrerit. " +
                "Praesent eu lorem lacinia, pellentesque arcu ac, vehicula felis. Mauris quis ultricies justo, eu volutpat nibh. Etiam at ex nibh. Aliquam eleifend ullamcorper accumsan. Nam.";

        String[] word = lorem.replaceAll("\\."," ").replaceAll(","," ").replaceAll("\\s+"," ")
                .split(" ");

        for (int i = 0; i < word.length; i++){
            System.out.println(word[i]);
        }




    }
}
