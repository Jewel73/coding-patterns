package com.jewel.patterns.slidingwindow.challange;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowContainingSubstring {

    private static String findSmallestWindowContainingSubString(String str, String substr){

        int windowStart = 0, matched = 0, highestStringCont = 0;
        Map<Character, Integer> charFrequency = new HashMap<>();
        String minimumSubString = "";

        for (int i =0; i < substr.length(); i++) charFrequency.put(substr.charAt(i), 1);

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);

            if (charFrequency.containsKey(rightChar)){
                charFrequency.put(rightChar, charFrequency.get(rightChar) -1);
                if (charFrequency.get(rightChar) == 0){
                    matched++;
                }
            }

            if (matched == charFrequency.size()){

                if (windowEnd - windowStart> highestStringCont){
                    minimumSubString = str.substring(windowStart, windowEnd);
                }

                char leftchar = str.charAt(windowStart);
                if (charFrequency.containsKey(leftchar)){
                    if (charFrequency.get(leftchar) == 0){
                        matched--;
                    }
                    charFrequency.put(leftchar, charFrequency.get(leftchar)+1);
                }
            }

        }

        return minimumSubString;
    }

    public static void main(String[] args) {
        System.out.print("Minimum substring : "+ findSmallestWindowContainingSubString("aabdec", "abc"));
    }
}
