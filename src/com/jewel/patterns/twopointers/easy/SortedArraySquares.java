package com.jewel.patterns.twopointers.easy;

import java.util.Arrays;

public class SortedArraySquares {

    private static int[] makeSquareArrays(int[] arr){
        int [] sortedArr = new int[arr.length];
        int start = 0;
        int end = arr.length-1;
        int sortedArrayLastIndex = end;

        while (start <= end){

            if (Math.pow(arr[start],2) > Math.pow(arr[end], 2) ){
                sortedArr[sortedArrayLastIndex--] =arr[start] * arr[start];
                start++;
            }else {
                sortedArr[sortedArrayLastIndex--] = arr[end] * arr[end];
                end--;
            }

        }
        return sortedArr;

    }

    public static void main(String[] args) {
        int arr[] = new int[]{-89, 1,2,3,7,8,9};
        System.out.print(Arrays.toString(makeSquareArrays(arr)));
    }
}
