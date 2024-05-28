package com.jewel.patterns.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

/*
Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 */
public class LongestSubstringWithReplaceKChar {

    private static int longestSubstringWithKReplace(String str, int K){

        int windowStart = 0, maxSubstringLen = 0, highestCount = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for (int windowEnd = 0 ; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            charMap.put(rightChar, charMap.getOrDefault(rightChar, 0)+1);
            highestCount = Math.max(highestCount, charMap.get(rightChar));

            if (windowEnd - windowStart + 1 - highestCount > K){
                char leftChar = str.charAt(windowStart);
                charMap.put(leftChar, charMap.get(leftChar) -1);
                windowStart++;
            }
            maxSubstringLen = Math.max(maxSubstringLen, windowEnd - windowStart + 1);
        }

        return  maxSubstringLen;
    }

    public static void main(String[] args) {
        System.out.print("Max SUbstring : "+ longestSubstringWithKReplace("aabccbb", 2));
    }
}
