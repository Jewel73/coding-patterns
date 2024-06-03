package com.jewel.patterns.twopointers.easy;

public class RemoveDuplicate {

    private static int removeDuplicate(int arr[]){
        int start = 0;

        for (int end = 1; end < arr.length; end++){
            if (arr[start] != arr[end]){
                arr[start+1] = arr[end];
                start++;
            }
        }
        return start+1;
    }

    private static int removeDuplicateFromUnsortedArray(int arr[], int target){
        int start = 0;

        for (int end = 0; end < arr.length; end++){
            if (arr[end] != target){
                arr[start] = arr[end];
                start++;
            }
        }
        return start;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,3,3,3,9,9};
        int[] arr2 = new int[]{2,2,2,11};

        int[] arr3 = new int[]{3,2,3,7,8,1,3,3};

        System.out.println(removeDuplicateFromUnsortedArray(arr3, 3));

        System.out.println(removeDuplicate(arr));

        System.out.print(removeDuplicate(arr2));
    }
}
