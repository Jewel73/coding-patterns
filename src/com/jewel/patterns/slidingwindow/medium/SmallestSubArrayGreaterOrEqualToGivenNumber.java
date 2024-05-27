package com.jewel.patterns.slidingwindow.medium;

public class SmallestSubArrayGreaterOrEqualToGivenNumber {

    public static void main(String[] args) {
        int arr[] = {2, 1, 5, 2, 3, 7};
        int S = 7; // subarray size

        int windowstart = 0;

        double sum = 0;
        int smallestSub = Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];

            while (sum >= S) {
                smallestSub = Math.min(smallestSub, (windowEnd - windowstart + 1));
                sum -= arr[windowstart];
                windowstart++;
            }
        }
        System.out.print("Max sum subarray is : " + smallestSub);
    }
}
