package com.jewel.patterns.slidingwindow.challange;

import java.util.*;

/*
Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".

 */
public class FindTheAnagramsOfThePattern {

    public static List<Integer> findIndicesOfAnagrams(String str, String pattern){

        int windowStart = 0, matched = 0;
        List<Integer> startingIndices = new ArrayList<>();

        Map<Character, Integer> charFrequency = new HashMap<>();
        for (int i=0; i < pattern.length(); i++) charFrequency.put(pattern.charAt(i), 1);

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++){

            char rightChar = str.charAt(windowEnd);
            if (charFrequency.containsKey(rightChar)){
                charFrequency.put(rightChar, charFrequency.get(rightChar) -1);
                if (charFrequency.get(rightChar) == 0){
                    matched++;
                }
            }

            if (matched == charFrequency.size()) {
                startingIndices.add(windowStart);
            }

            if(windowEnd >= pattern.length()-1){
                char leftChar = str.charAt(windowStart);
                if (charFrequency.containsKey(leftChar)){
                    if (charFrequency.get(leftChar) == 0) matched--;
                    charFrequency.put(leftChar, charFrequency.get(leftChar) + 1);
                }
                windowStart++;
            }

        }
        return startingIndices;
    }


    public static void main(String[] args) {
        System.out.print("Array of Anagrams indices: "+ findIndicesOfAnagrams("aaabbcabcab", "abc"));
    }
}
