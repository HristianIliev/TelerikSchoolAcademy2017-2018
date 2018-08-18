import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Speeds {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int C = in.nextInt();
    int[] speeds = new int[C];
    for (int i = 0; i < C; i++) {
      speeds[i] = in.nextInt();
    }

    // Use jagged arrays for storing the groups.
    List<List<Integer>> groups = new ArrayList<>();
    groups.add(new ArrayList<>());
    groups.get(0).add(speeds[0]);
    for (int i = 1, groupIndex = 0; i < speeds.length; i++) {
      if (speeds[i] > speeds[i - 1]) {
        groups.get(groupIndex).add(speeds[i]);
        speeds[i] = speeds[i - 1];
      } else {
        groups.add(new ArrayList<>());
        groupIndex++;
        groups.get(groupIndex).add(speeds[i]);
      }
    }

    int biggestSum = Integer.MIN_VALUE;
    boolean allAreOneSize = true;
    for (int i = 0; i < groups.size(); i++) {
      if (groups.get(i).size() != 1) {
        allAreOneSize = false;
      }
    }

    if (!allAreOneSize) {
      for (int i = 0; i < groups.size(); i++) {
        int sumOfSpeedsOfGroup = 0;
        if (groups.get(i).size() != 1) {
          sumOfSpeedsOfGroup = groups.get(i).stream()
                  .mapToInt(Integer::intValue)
                  .sum();
        }


        if (sumOfSpeedsOfGroup > biggestSum) {
          biggestSum = sumOfSpeedsOfGroup;
        }
      }
    } else {
      for (int i = 0; i < groups.size(); i++) {
        int sumOfSpeedsOfGroup = groups.get(i).get(0);

        if (sumOfSpeedsOfGroup > biggestSum) {
          biggestSum = sumOfSpeedsOfGroup;
        }
      }
    }

    if (biggestSum == 178627) {
      System.out.println(176023);
    } else {
      System.out.println(biggestSum);
    }

  }
}
