package com.jewel.patterns.slidingwindow.challange;

/*
Input: String="abdabca", Pattern="abc"
Output: "abc"
Explanation: The smallest substring having all characters of the pattern is "abc".
 */

import java.util.HashMap;
import java.util.Map;

public class FindSmallestSubstringContainingThePattern {

    private static String findSmallestSubstring(String str , String pattern){

        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequency = new HashMap<>();
        String smallestSUb = "";
        int minimumSub = str.length();

        for (int i = 0; i < pattern.length(); i++) charFrequency.put(pattern.charAt(i), 1);

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++){

            char rightChar = str.charAt(windowEnd);
            if (charFrequency.containsKey(rightChar)){
                charFrequency.put(rightChar, charFrequency.get(rightChar) -1);
                if (charFrequency.get(rightChar) == 0){
                    matched++;
                }
            }

            while (matched == charFrequency.size()){

                char leftchar = str.charAt(windowStart);
                if (windowEnd - windowStart < minimumSub){
                    minimumSub = windowEnd - windowStart;
                    smallestSUb = str.substring(windowStart, windowEnd+1);
                }


                if (charFrequency.containsKey(leftchar)){
                    if (charFrequency.get(leftchar) == 0){
                        matched--;
                    }
                    charFrequency.put(leftchar, charFrequency.get(leftchar) + 1);
                }
                windowStart++;
            }
        }
        return smallestSUb;
    }

    public static void main(String[] args) {

        String str = "abdcd";
        System.out.print("SUb : "+ findSmallestSubstring("aabdec", "abc") );
    }
}
