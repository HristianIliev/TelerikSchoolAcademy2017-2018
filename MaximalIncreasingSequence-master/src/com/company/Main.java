package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int N = in.nextInt();
	    int[] numbers = new int[N];
	    for(int i = 0; i < N; i++){
            numbers[i] = in.nextInt();
        }

        int maximalIncreasingSequence = 0;
        int currentIncreasingSequence = 1;
        for(int i = 0; i < N - 1; i++){
            if(numbers[i] < numbers[i + 1]){
                currentIncreasingSequence++;
                if(currentIncreasingSequence > maximalIncreasingSequence){
                    maximalIncreasingSequence = currentIncreasingSequence;
                }
            }else{
                currentIncreasingSequence = 1;
            }
        }

        System.out.println(maximalIncreasingSequence);
    }
}