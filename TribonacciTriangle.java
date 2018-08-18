import java.util.*;

public class TribonacciTriangle {
    private static long getNextInt(Scanner in){
        long result = in.nextInt();
        in.nextLine();
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long bh1 = getNextInt(in);
        long bh2 = getNextInt(in);
        long bh3 = getNextInt(in);
        ArrayList<Long> numbersOfStairs = new ArrayList<>();
        numbersOfStairs.add(bh1);
        numbersOfStairs.add(bh2);
        numbersOfStairs.add(bh3);
        int currentIndex = 3;
        long L = getNextInt(in);
        long[][] stairs = new long[(int) L][];
        stairs[0] = new long[1];
        stairs[0][0] = bh1;
        stairs[1] = new long[2];
        stairs[1][0] = bh2;
        stairs[1][1] = bh3;
        int numberOfNumbersPerLayer = 3;
        for (int i = 2; i < L; i++, numberOfNumbersPerLayer++) {
            stairs[i] = new long[numberOfNumbersPerLayer];
            for (int j = 0; j < numberOfNumbersPerLayer; j++, currentIndex++) {
                long numberToPut = numbersOfStairs.get(currentIndex - 1) + numbersOfStairs.get(currentIndex - 2)+ numbersOfStairs.get(currentIndex - 3);
                stairs[i][j] = numberToPut;
                numbersOfStairs.add(numberToPut);
            }
        }

        for (long[] layer:
             stairs) {
            for (long number :
                    layer) {
                System.out.print(number + " ");
            }

            System.out.println();
        }
    }
}
