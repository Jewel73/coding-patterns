package com.jewel.patterns.twopointers.easy;

/*
Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
 */

import java.util.Arrays;

public class PairWithTargetSum {

    private static int[] findTargetSubIndex(int[] arr, int target){
        int index[] = {-1, -1};
        int start = 0;
        int end = arr.length-1;

        while (start < end){
            if (arr[start] + arr[end] == target) {
                index[0] = start;
                index[1] = end;
            }

            if (arr[start] + arr[end] > target){
                end--;
            }else {
                start++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int arr[]={1, 2, 3,4, 6, 7, 9, 13};
        int target=13;
        System.out.print(Arrays.toString(findTargetSubIndex(arr, target)));
    }
}
