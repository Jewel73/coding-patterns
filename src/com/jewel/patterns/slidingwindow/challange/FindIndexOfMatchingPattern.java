package com.jewel.patterns.slidingwindow.challange;

public class FindIndexOfMatchingPattern {

    private static int findMatchingPatternIndex(String str, String pattern){

        for (int windowStart = 0 ; windowStart < str.length() - pattern.length(); windowStart++){

            String subString = str.substring(windowStart, windowStart+ pattern.length());

            if (subString.contains(pattern)) return windowStart;

        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.print("Mathcing index : "+ findMatchingPatternIndex("adkfjdkfjdabcdjkjdf", "abcd"));
    }
}
