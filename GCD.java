import java.util.Scanner;

public class GCD {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int A = in.nextInt();
    int B = in.nextInt();
    boolean found = false;
    int gcd = 1;
    while (!found) {
      if (A == 0) {
        gcd = B;
        found = true;
        continue;
      } else if (B == 0) {
        gcd = A;
        found = true;
        continue;
      }

      int R = A % B;
      A = B;
      B = R;
    }

    System.out.println(gcd);
  }
}
