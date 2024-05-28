package com.jewel.patterns.slidingwindow.hard;

import java.util.HashMap;

/*
Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 */
public class LongestConSubArrayAll1sWithKreplace {

    private static int findMaxSubString(int[] arr, int K){

        int windowStart = 0, maxLen = 0;
        HashMap<Integer, Integer> countInt = new HashMap<>();

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            int num = arr[windowEnd];
            countInt.put(num, countInt.getOrDefault(num, 0) + 1);

            if(windowEnd - windowStart +1 - countInt.getOrDefault(1, 0) > K){
                int leftNum = arr[windowStart];
                countInt.put(leftNum, countInt.get(leftNum) - 1 );
                windowStart++;
            }

            maxLen = Math.max(maxLen, windowEnd - windowStart +1);
        }
        return  maxLen;
    }


    private static int findSecondWayMaxLen(int[] arr, int K){

        int windowStart = 0, maxLen = 0, maxOnesCount = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            int num = arr[windowEnd];
            if(num == 1) maxOnesCount++;

            if(windowEnd - windowStart +1 - maxOnesCount > K){
                int leftNum = arr[windowStart];
                if(leftNum == 1) maxOnesCount--;
                windowStart++;
            }

            maxLen = Math.max(maxLen, windowEnd - windowStart +1);
        }
        return  maxLen;
    }

    public static void main(String[] args) {
        int[] str = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        System.out.println("Max len : "+ findMaxSubString(str, 2));
        System.out.println("Max len : "+ findSecondWayMaxLen(str, 2));
    }
}
