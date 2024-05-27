package com.jewel.patterns.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

/*
Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".

 */
public class PracticeNoRepeatSubString {

    private static int findLongestSubString(String str){
        int windowStart = 0, maxSub = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char ch = str.charAt(windowEnd);

            if (charMap.containsKey(ch)){
                windowStart = Math.max(windowStart, charMap.get(ch)+ 1);
            }
            charMap.put(ch, windowEnd);
            maxSub = Math.max(maxSub, windowEnd - windowStart + 1);
        }

        return maxSub;
    }


    public static void main(String[] args) {

        System.out.print("Longest substring : "+ findLongestSubString("asjlgtabccbb"));
    }
}
