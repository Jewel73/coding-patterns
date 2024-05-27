package com.jewel.patterns.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {

    public static int findlength(String str){

        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char ch = str.charAt(windowEnd);

            if (charMap.containsKey(ch)){
                windowStart = Math.max(windowStart, charMap.get(ch)+1);
            }
            charMap.put(ch, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart +1);
        }
        return maxLength;
    }


    public static void main(String[] args) {

        System.out.println("Max length for substring 'aabccbb' : "+ findlength("aabccbb"));
        //System.out.print("Max length for substring 'aabccbb' : "+ findlength("abccdefghi"));

    }
}
