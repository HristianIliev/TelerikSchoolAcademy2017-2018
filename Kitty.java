import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kitty {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String pos = in.nextLine();
    StringBuilder positions = new StringBuilder(pos);
    String path = in.nextLine();
    List<Integer> steps = new ArrayList<>();
    String[] params = path.split(" ");
    for (int i = 0; i < params.length; i++) {
      steps.add(Integer.parseInt(params[i]));
    }

    int jumps = 0, souls = 0, food = 0, deadlocks = 0;
    boolean deadlocked = false;
    for (int i = -1, j = 0; i < steps.size(); i++, jumps++) {
      int step = 0;
      if (i != -1) {
        step = steps.get(i);
      }

      char symbol;
      if (i == -1) {
        symbol = positions.charAt(j);
      } else if (step > 0) {
        j += step;
        try {

          symbol = positions.charAt(j);

        } catch (IndexOutOfBoundsException ex) {
          while (j > positions.length() - 1) {
            j = j - positions.length();
          }

          symbol = positions.charAt(j);
        }
      } else {
        j += step;
        try {
          symbol = positions.charAt(j);

        } catch (IndexOutOfBoundsException ex) {
          while (j < 0) {
            j = positions.length() + j;
          }

          symbol = positions.charAt(j);
        }
      }

      if (symbol == '@') {
        positions.replace(j, j + 1, "1");
        souls++;
      } else if (symbol == '*') {
        positions.replace(j, j + 1, "1");
        food++;
      } else if (symbol == 'x') {
        if (j % 2 == 0) {
          if (souls == 0) {
            System.out.println("You are deadlocked, you greedy kitty!\n" +
                    "Jumps before deadlock: " + jumps);
            deadlocked = true;
            break;
          }

          positions.replace(j, j + 1, "@");
          souls--;
          deadlocks++;
        } else if (j % 2 != 0) {
          if (food == 0) {
            System.out.println("You are deadlocked, you greedy kitty!\n" +
                    "Jumps before deadlock: " + jumps);
            deadlocked = true;
            break;
          }

          positions.replace(j, j + 1, "*");
          food--;
          deadlocks++;
        }
      }
    }

    if (!deadlocked) {
      System.out.println("Coder souls collected: " + souls);
      System.out.println("Food collected: " + food);
      System.out.println("Deadlocks: " + deadlocks);
    }
  }
}
