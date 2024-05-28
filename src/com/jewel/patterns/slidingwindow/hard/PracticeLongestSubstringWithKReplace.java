package com.jewel.patterns.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

/*
Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 */
public class PracticeLongestSubstringWithKReplace {

    private static int findLongestSubstring(String str, int K){

        int maxLen = 0 , windowStart = 0, maxCount = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1);
            maxCount = Math.max(maxCount, charMap.get(rightChar));

            if (windowEnd - windowStart + 1 - maxCount > K){
                char leftChar = str.charAt(windowStart);
                charMap.put(leftChar, charMap.get(leftChar) -1  );
                windowStart ++;
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);

        }
        return  maxLen;
    }

    public static void main(String[] args) {
        System.out.print("Max len : "+ findLongestSubstring("aabccbb", 2));
    }
}
