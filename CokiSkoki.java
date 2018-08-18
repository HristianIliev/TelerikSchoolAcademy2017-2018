import java.util.Scanner;
import java.util.Stack;

public class CokiSkoki {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int N = in.nextInt();
    int[] buildings = new int[N];
    for (int i = 0; i < buildings.length; i++) {
      buildings[i] = in.nextInt();
    }

    int[] maxJumps = new int[buildings.length];
    int maxJump = Integer.MIN_VALUE;

    Stack<Integer> indices = new Stack<>();
    for (int i = buildings.length - 1; i >= 0; i--) {
      while (!indices.isEmpty() && buildings[indices.peek()] <= buildings[i]) {
        int index = indices.pop();
        maxJumps[index] = indices.size();
        if (indices.size() > maxJump) {
          maxJump = indices.size();
        }
      }

      indices.push(i);
    }

    while (!indices.isEmpty()) {
      int peekIndex = indices.pop();
      maxJumps[peekIndex] = indices.size();
      if (indices.size() > maxJump) {
        maxJump = indices.size();
      }
    }

    System.out.println(maxJump);

    for (int i = 0; i < maxJumps.length; i++) {
      System.out.print(maxJumps[i]);
      if (i != maxJumps.length - 1) {
        System.out.print(" ");
      }
    }
//    Stack<Integer> stack = new Stack<>();
//    for (int i = buildings.length - 1; i >= 0; i--) {
//      if (i == buildings.length - 1) {
//        stack.push(buildings[i]);
//      }
//
//      if (stack.peek() > buildings[i]) {
//        stack.push(buildings[i]);
//      } else if (stack.peek() < buildings[i]) {
//
//      }
//    }

//    int currentJumps = 0;
//    int longestJump = 0;
//    LinkedList<Integer> jumps = new LinkedList<>();
//    for (int i = 0; i < N; i++) {
//      int lastBuilding = buildings[i];
//      for (int j = i + 1; j < N; j++) {
//        if (buildings[j] > lastBuilding) {
//          lastBuilding = buildings[j];
//          currentJumps++;
//        }
//      }
//
//      jumps.offerFirst(currentJumps);
//      if (currentJumps >= longestJump) {
//        longestJump = currentJumps;
//      }
//
//      currentJumps = 0;
//    }
//
//    System.out.println(longestJump);
//
//    for (int i = 0; i < jumps.size(); ) {
//      System.out.print(jumps.removeLast() + " ");
//    }
  }
}
