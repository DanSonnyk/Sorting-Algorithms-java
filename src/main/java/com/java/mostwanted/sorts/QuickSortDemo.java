package com.java.mostwanted.sorts;

import java.util.Arrays;
import java.util.Random;

public class QuickSortDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
                numbers[i] = random.nextInt(100 + 1 - 1) + 1;
        }
        System.out.println("Before sort: "+Arrays.toString(numbers));

        //method
        //quickSort(numbers, 0, numbers.length -1);
        quicksort(numbers, 0, numbers.length - 1);

        System.out.println("After sort: "+Arrays.toString(numbers));
    }

    //method one
    public static void quicksort(int[] array, int lowIndex, int highIndex){

        if(lowIndex >= highIndex){
            return;
        }

        //choosing pivot
        int pivot = array[highIndex];

        //creating partition of the array
        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        //calling quicksort recursively
        quicksort(array, lowIndex, leftPointer -1);
        quickSort(array, leftPointer + 1, highIndex);
    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer){
            while (array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }

            while (array[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }

        swap(array, leftPointer, highIndex);
        return leftPointer;
    }

    private static void swap(int[] array, int leftPointer, int rightPointer) {
        int temp = array[leftPointer];
        array[leftPointer] = array[rightPointer];
        array[rightPointer] = temp;
    }


    //method two
    public static void quickSort(int[] v, int start_pos, int end_pos){
        var pivot = v[start_pos];
        int l = start_pos;
        int r = end_pos;

        while (l <= r){

            while (v[l] < pivot) l++;
            while (v[r] > pivot) r--;

            if(l <= r){
                swap(v, l, r);
                l++;
                r--;
            }
        }
        if(start_pos < r)quickSort(v, start_pos, r);
        if(l < end_pos)quickSort(v, l, end_pos);
    }
}
