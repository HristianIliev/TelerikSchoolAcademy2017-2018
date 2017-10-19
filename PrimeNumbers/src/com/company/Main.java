package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int N = in.nextInt();
	    int[] allNumbersLessOrEqualThanN = new int[N + 1];
	    for(int i = 2; i < allNumbersLessOrEqualThanN.length; i++){
	    	if(i % 3 == 0 && i != 3 ){
	    		continue;
			}

	        allNumbersLessOrEqualThanN[i] = i;
        }

        for(int i = 2; i < Math.sqrt(allNumbersLessOrEqualThanN.length); i++)
        {
        	if(allNumbersLessOrEqualThanN[i] == 0){
        		continue;
			}

			for(int j = i + i; j < allNumbersLessOrEqualThanN.length; j += i){
				allNumbersLessOrEqualThanN[j] = 0;
			}
        }

        int index = allNumbersLessOrEqualThanN.length - 1;
		while(index != 0){
	    	if(allNumbersLessOrEqualThanN[index] != 0){
				System.out.println(allNumbersLessOrEqualThanN[index]);
				break;
			}

			index--;
		}
	}
}
