import java.util.*;

public class MazeRunner {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String[] numbers = new String[N];
        ArrayList<String> directions = new ArrayList<>();

        int sumOfEven = 0;
        int sumOfOdd = 0;
        for (int i = 0; i < N; i++) {
            numbers[i] = in.nextLine();
            for (int j = 0; j < numbers[i].length(); j++) {
                if ((numbers[i].charAt(j) - '0') % 2 == 0){
                    sumOfEven += numbers[i].charAt(j);
                }else if((numbers[i].charAt(j) - '0') % 2 != 0){
                    sumOfOdd += numbers[i].charAt(j);
                }
            }

            if (sumOfEven > sumOfOdd){
                directions.add("left");
            }else if(sumOfEven < sumOfOdd){
                directions.add("right");
            } else {
                directions.add("straight");
            }

            sumOfEven = 0;
            sumOfOdd = 0;
        }

        for (String direction:
             directions) {
            System.out.println(direction);
        }
    }
}
