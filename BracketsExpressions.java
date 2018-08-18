import java.util.*;

public class BracketsExpressions {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        ArrayList<String> validExpressons = new ArrayList<>();

        Stack<Integer> indices = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '('){
                indices.push(i);
            } else if(input.charAt(i) == ')'){
                int startingIndexOfExpression = indices.pop();
                validExpressons.add(input.substring(startingIndexOfExpression, i + 1));
            }
        }

        for (String validExpresson : validExpressons) {
            System.out.println(validExpresson);
        }
    }
}
