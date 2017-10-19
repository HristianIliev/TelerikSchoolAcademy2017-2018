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
        int K = in.nextInt();
        int[] numbers = new int[N];
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = in.nextInt();
        }


        quickSort(numbers, 0, numbers.length - 1);

        int sum = 0;
        for(int i = numbers.length - 1; i > numbers.length - 1 - K; i--){
            sum += numbers[i];
        }

        System.out.println(sum);
    }
}
