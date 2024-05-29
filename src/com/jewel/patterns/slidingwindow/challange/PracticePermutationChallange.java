package com.jewel.patterns.slidingwindow.challange;

import java.util.HashMap;

/*
Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.

 */
public class PracticePermutationChallange {

    private static boolean foundPermutation(String str, String pattern){

        int windowStart = 0, matched = 0;
        HashMap<Character, Integer> charFrequency = new HashMap<>();
        for (int i=0; i < pattern.length(); i++){
            charFrequency.put(pattern.charAt(i), 1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            if (charFrequency.containsKey(rightChar)){
                charFrequency.put(rightChar, charFrequency.get(rightChar) - 1);
                if (charFrequency.get(rightChar) == 0){
                    matched++;
                }
            }

            if (matched == charFrequency.size()) return true;

            if(windowEnd >= pattern.length() -1){
                char leftChar = str.charAt(windowStart);
                if (charFrequency.containsKey(leftChar)){
                    if (charFrequency.get(leftChar) == 0){
                        matched--;
                    }
                    charFrequency.put(leftChar, charFrequency.get(leftChar)-1);
                }
                windowStart++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.print("Permutation Found : "+ foundPermutation("bcdxabcdy", "aaaa"));
    }
}
