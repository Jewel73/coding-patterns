package com.jewel.patterns.slidingwindow.easy;

// Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5

public class BruteForceSubArraySum {

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int K = 5; // subarray size
        double result[] = new double[arr.length - K + 1];

        for (int i = 0; i <= arr.length - K; i++) {
            double sum = 0;

            for (int j = i; j < i + K; j++) {
                sum += arr[j];
            }

            result[i] = sum / K;
        }

        for (double d : result) {
            System.out.print(d + " ");
        }
    }
}
