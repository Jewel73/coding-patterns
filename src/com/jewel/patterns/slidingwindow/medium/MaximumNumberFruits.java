package com.jewel.patterns.slidingwindow.medium;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberFruits {
    public static void main(String[] args) {

        Character[] fruits = {'A', 'B', 'C', 'B', 'B', 'C'};
        int baskets = 2;
        Map<Character, Integer> charFrequency = new HashMap<>();

        int windowStart = 0; int maxFruits = 0;
        for(int windowEnd = 0; windowEnd < fruits.length; windowEnd++){
            char ch = fruits[windowEnd];
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) +1);

            while (charFrequency.size() > baskets){
                char leftChar = fruits[windowStart];
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
                if (charFrequency.get(leftChar) == 0){
                    charFrequency.remove(leftChar);
                }
                windowStart++;
            }
            maxFruits = Math.max(maxFruits, windowEnd - windowStart +1);
        }

        System.out.print("Max Fruits can be in the two baskets is : "+ maxFruits);
    }


}
