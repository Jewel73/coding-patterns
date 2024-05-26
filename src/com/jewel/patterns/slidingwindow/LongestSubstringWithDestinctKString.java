package com.jewel.patterns.slidingwindow;

/*

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".

 */

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithDestinctKString {

    public static void main(String[] args) {
        String str = "cbbebi";
        int K = 3;

        int windowStart = 0, maxLength = Integer.MIN_VALUE;
        Map<Character, Integer> charFrequency = new HashMap<>();

        for(int windowEnd = 0; windowEnd< str.length(); windowEnd++){
            char leftChar = str.charAt(windowEnd);
            charFrequency.put(leftChar, charFrequency.getOrDefault(leftChar, 0)+1);

            while (charFrequency.size()>K){
                char charLeft =  str.charAt(windowStart);
                charFrequency.put(charLeft, charFrequency.get(charLeft)-1);

                if (charFrequency.get(charLeft) == 0){
                    charFrequency.remove(charLeft);
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        System.out.print("Max Length SubArray : "+ maxLength);
    }



}
