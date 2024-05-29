package com.jewel.patterns.slidingwindow.challange;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    private static boolean findPermutationInString(String str, String pattern){

        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char ch : pattern.toCharArray()){
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0)+1);
        }

        for (int windowEnd = 0; windowEnd<str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);

            if(charFrequencyMap.containsKey(rightChar)){
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar) -1);
                if(charFrequencyMap.get(rightChar) == 0 ){
                    matched++;
                }
            }

            if (matched == charFrequencyMap.size()) return true;

            if(windowEnd >= pattern.length()-1){
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)){
                    if (charFrequencyMap.get(leftChar) == 0){
                        matched--;
                    }
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar)+1);
                }
            }

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.print("Permutation found : "+ findPermutationInString("aaacacb", "abc"));
    }
}
