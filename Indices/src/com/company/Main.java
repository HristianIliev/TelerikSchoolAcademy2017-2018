package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] numbers = new int[N];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = in.nextInt();
        }


        boolean[] alreadyVisitedNumbers = new boolean[N];
        int indexFromWhereTheLoopStarts = -1;
        ArrayList<Integer> sequence = new ArrayList<>();
        for(int i = 0; i < numbers.length || i < 0;){
            if(alreadyVisitedNumbers[i] == true){
                indexFromWhereTheLoopStarts = i;
                break;
            }

            alreadyVisitedNumbers[i] = true;
            sequence.add(i);
            i = numbers[i];
        }
//        ReturnElementRecursively(sequence, numbers, 0);

        if(indexFromWhereTheLoopStarts != -1){
            for(int i = 0; i < sequence.size(); i++){
                if(i == indexFromWhereTheLoopStarts){
                    System.out.print("(" + sequence.get(i));
                }else{
                    System.out.print(" " + sequence.get(i));
                }
            }

            System.out.println(")");
        }else{
            for(int i = 0; i < sequence.size(); i++){
                System.out.print(sequence.get(i) + " ");
            }

            System.out.println();
        }
    }

//    private static void ReturnElementRecursively(ArrayList<Integer> sequence, int[] numbers, int index){
//        sequence.add(numbers[index]);
//        index = numbers[index];
//        if(index < numbers.length){
//            ReturnElementRecursively(sequence, numbers, index);
//        }
//    }
}
