import java.util.Scanner;

public class PrimeTriangle {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    for (int i = 1; i <= N; i++) {
      if (isPrime(i)) {
        for (int j = 1; j <= i; j++) {
          if (isPrime(j)) {
            System.out.print("1");
          } else {
            System.out.print("0");
          }
        }

        System.out.println();
      }
    }
  }

  private static boolean isPrime(int number) {
    if (number == 2) {
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
