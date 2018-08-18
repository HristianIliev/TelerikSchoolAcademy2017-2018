import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Ranks {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        Integer[] numbers = new Integer[N];

        String lineOfNumbers = in.nextLine();
        String[] numbersString = lineOfNumbers.split(" ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersString[i]);
        }

        HashMap<Integer, Integer> mapNumberToPosition = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            mapNumberToPosition.put(numbers[i], i);
        }

        Arrays.sort(numbers);

        int[] result = new int[N];
        int numberToReplaceWith = N;
        for (int i = 0; i < N; i++, numberToReplaceWith--) {
            result[mapNumberToPosition.get(numbers[i])] = numberToReplaceWith;
        }

        for (int rank :
                result) {
            System.out.print(rank + " ");
        }
    }
}
