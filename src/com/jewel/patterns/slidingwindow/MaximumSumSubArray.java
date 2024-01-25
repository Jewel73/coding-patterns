package com.jewel.patterns.slidingwindow;

public class MaximumSumSubArray {

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 1, 3, 2};
        int k = 3;
        //int max = bruteForceSolution(arr, k);
        int max = optimizeSolution(arr, k);
        System.out.println(max);
    }

    public static int optimizeSolution(int arr[], int k){
        int maxSum = 0;
        int currentSum = 0;
        int startWindow = 0;
        for(int windowEnd =0; windowEnd <arr.length; windowEnd++){

            currentSum += arr[windowEnd];
            if (windowEnd >= k-1){
                maxSum = Integer.max(currentSum, maxSum);
                currentSum -= arr[startWindow];
                startWindow++;
            }
        }

        return maxSum;

    }

    public static int bruteForceSolution(int arr[] , int k){
        int maxSum = 0;
        for (int i=0; i <= arr.length-k; i++){
            int currentSum = 0;
            for (int j=i; j<k+i; j++){
                currentSum += arr[j];
            }
            maxSum = Integer.max(currentSum, maxSum);
        }
        return maxSum;
    }
}

