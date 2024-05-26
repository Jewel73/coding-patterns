package com.jewel.patterns.slidingwindow;

public class MaxSumSubArray {

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 1, 5};
        int K = 2; // subarray size

        int windowstart = 0;

        double sum = 0;
        double max = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum+= arr[windowEnd];

            if (windowEnd >= K-1){
                if (sum>max) max=sum;
                sum -= arr[windowstart];
                windowstart++;
            }

        }

        System.out.print("Max sum subarray is : "+ max);
    }
}
