import java.util.Scanner;

public class PrimestoN {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    for (int i = 1; i <= N; i++) {
      if (isPrime(i)) {
        System.out.print(i + " ");
      }
    }
  }

  private static boolean isPrime(int number) {
    if (number == 2 || number == 1) {
      return true;
    }

    if (number % 2 == 0) {
      return false;
    }

    for (int i = 3; i * i <= number; i += 2) {
      if (number % i == 0) {
        return false;
      }
    }

    return true;
  }
}
