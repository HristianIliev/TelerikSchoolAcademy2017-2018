package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int N = in.nextInt();
	    int[] numbers = new int[N];
	    for(int i = 0; i < numbers.length; i++){
	        numbers[i] = in.nextInt();
        }

        int maxSum = Integer.MIN_VALUE;
        int currentSum;
        for(int i = 0; i < numbers.length; i++){
            currentSum = numbers[i];
            for(int j = i + 1; j < numbers.length; j++){
                currentSum += numbers[j];
                if(currentSum > maxSum){
                    maxSum = currentSum;
                }
            }
        }

        System.out.println(maxSum);
    }
}
