package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String sequenceOfDigits = in.nextLine();
		String sequenceOfDigits2 = sequenceOfDigits;
		String cipher = in.nextLine();

		StringBuilder cipherSB = new StringBuilder(cipher);
		StringBuilder alphabet = new StringBuilder("ABCDEFGHIGKLMNOPQRSTUVWXYZ");

		StringBuilder lettersInTheCipher = new StringBuilder();
		for(int i = 0; i < cipherSB.length(); i++){
			for(int j = 0; j < alphabet.length(); j++){
				if(cipher.charAt(i) == alphabet.charAt(j)){
					lettersInTheCipher.append(cipher.charAt(i));
					cipherSB.replace(i, i + 1, "0");
				}
			}
		}

		String[] separateCombinationsOfDigitsInTheCipher = cipherSB.toString().split("0");

		ArrayList<StringBuilder> results = new ArrayList<>();
		StringBuilder currentResult = new StringBuilder();
		//Fix this
		while() {
			for (int i = 1; i < separateCombinationsOfDigitsInTheCipher.length; i++) {
				if (sequenceOfDigits.contains(separateCombinationsOfDigitsInTheCipher[i])) {
					sequenceOfDigits = sequenceOfDigits.replaceFirst(separateCombinationsOfDigitsInTheCipher[i], "0");
					currentResult.append(lettersInTheCipher.charAt(i - 1));
				}
			}

			sequenceOfDigits = sequenceOfDigits2;
			results.add(currentResult);
		}

		System.out.println(currentResult);
	}
}
