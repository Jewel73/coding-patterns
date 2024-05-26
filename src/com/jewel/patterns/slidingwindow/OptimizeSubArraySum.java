package com.jewel.patterns.slidingwindow;

public class OptimizeSubArraySum {

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int K = 5; // subarray size
        double result[] = new double[arr.length - K + 1];
        double sum = 0;
        int windowstart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum+= arr[windowEnd];

            if (windowEnd >= K-1){
                result[windowstart] = sum/K;
                sum -= arr[windowstart];
                windowstart++;
            }
        }

        for (double d : result) {
            System.out.print(d + " ");
        }
    }

}
