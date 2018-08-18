import java.util.Scanner;

public class SecretMessage {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    String input = in.nextLine();
	    StringBuilder secretMessage = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            if(Character.isLetter(input.charAt(i))){
                secretMessage.append(input.charAt(i));
            }
        }

        System.out.println(secretMessage);
    }
