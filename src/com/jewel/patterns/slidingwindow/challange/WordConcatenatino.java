package com.jewel.patterns.slidingwindow.challange;

import java.util.*;

/*
Input: String="catfoxcat", Words=["cat", "fox"]
Output: [0, 3]
Explanation: The two substring containing both the words are "catfox" & "foxcat".

 */
class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {

        Map<String, Integer> wordFrequency = new HashMap<>();
        int wordArrSize = words.length; int wordsChar = words[0].length();

        for (int i=0; i< words.length; i++) wordFrequency.put(words[i], 1);

        ArrayList<Integer> foundIndex = new ArrayList<>();

        for (int i = 0; i <= str.length() - wordArrSize * wordsChar; i++){

            Map<String, Integer> hashSeen = new HashMap<>();

            for (int j = 0; j < wordArrSize; j++){

                int nextFirstIndex = i + j * wordsChar;

                String subString = str.substring(nextFirstIndex, nextFirstIndex+ wordsChar );
                if(!wordFrequency.containsKey(subString)) break;

                hashSeen.put(subString,hashSeen.getOrDefault(subString, 0)+1);

                if (hashSeen.get(subString) > wordFrequency.get(subString)) break;

                if (j+1 == wordArrSize){
                    foundIndex.add(i);
                }

            }
        }


        return foundIndex;
    }

    public static void main(String[] args) {
        List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
        result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
        System.out.println(Math.pow(-3, 2));
    }
}
