package com.company;

import java.util.Scanner;

public class Main {
    public static int partition(int numbers[], int leftIndex, int rightIndex)
    {
        int i = leftIndex;
        int j = rightIndex;
        int pivot = numbers[(leftIndex + rightIndex) / 2];

        while (i <= j) {
            while (numbers[i] < pivot)
                i++;
            while (numbers[j] > pivot)
                j--;
            if (i <= j) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
                i++;
                j--;
            }
        };

        return i;
    }

    public static void quickSort(int numbers[], int leftIndex, int rightIndex) {
        int index = partition(numbers, leftIndex, rightIndex);
        if (leftIndex < index - 1)
            quickSort(numbers, leftIndex, index - 1);
        if (index < rightIndex)
            quickSort(numbers, index, rightIndex);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] numbers = new int[N];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = in.nextInt();
        }

        int maxNumberOfRepeats = 0;
        int currentNumberOfRepeats = 1;
        int mostFrequentNumber = 0;
        quickSort(numbers, 0, numbers.length - 1);
        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] == numbers[i - 1]){
                currentNumberOfRepeats++;
                if(currentNumberOfRepeats > maxNumberOfRepeats){
                    maxNumberOfRepeats = currentNumberOfRepeats;
                    mostFrequentNumber = numbers[i - 1];
                }
            }
            else{
                currentNumberOfRepeats = 1;
            }
        }

        System.out.printf("%d (%d times)", mostFrequentNumber, maxNumberOfRepeats);
    }
}
