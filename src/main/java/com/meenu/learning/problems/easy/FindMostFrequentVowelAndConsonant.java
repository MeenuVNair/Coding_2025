package com.meenu.learning.problems.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @author Meenu V. Nair
 * @created 16/09/25
 */

/*******  APPROACH ******************** 

 */


/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : 
 Space Complexity : 
 */

public class FindMostFrequentVowelAndConsonant {
    public int maxFreqSum(String s) {
        Map<Character, Integer> vowelMap = new HashMap<>();
        Map<Character, Integer> consMap = new HashMap<>();

        for(char c : s.toCharArray()) {
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelMap.put(c, vowelMap.getOrDefault(c, 0) + 1);
            } else {
                consMap.put(c, consMap.getOrDefault(c, 0) + 1);
            }
        }

        int vowelCount = 0;
        int consCount = 0;

        for(Map.Entry<Character, Integer> entry : vowelMap.entrySet()) {
            if(entry.getValue() > vowelCount)
                vowelCount = entry.getValue();
        }

        for(Map.Entry<Character, Integer> entry : consMap.entrySet()) {
            if(entry.getValue() > consCount)
                consCount = entry.getValue();
        }

        return vowelCount + consCount;
    }

    public static void main(String[] args) {
        FindMostFrequentVowelAndConsonant obj = new FindMostFrequentVowelAndConsonant();
       /* String s = "successes";
        System.out.println(obj.maxFreqSum(s)); // 6*/
        String s = "aeiaeia";
        System.out.println(obj.maxFreqSum(s)); // 3
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given a string s consisting of lowercase English letters ('a' to 'z').

 Your task is to:

 Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum frequency.
 Find the consonant (all other letters excluding vowels) with the maximum frequency.
 Return the sum of the two frequencies.

 Note: If multiple vowels or consonants have the same maximum frequency, you may choose any one of them. If there are no vowels or no consonants in the string, consider their frequency as 0.

 The frequency of a letter x is the number of times it occurs in the string.


 Example 1:

 Input: s = "successes"

 Output: 6

 Explanation:

 The vowels are: 'u' (frequency 1), 'e' (frequency 2). The maximum frequency is 2.
 The consonants are: 's' (frequency 4), 'c' (frequency 2). The maximum frequency is 4.
 The output is 2 + 4 = 6.
 Example 2:

 Input: s = "aeiaeia"

 Output: 3

 Explanation:

 The vowels are: 'a' (frequency 3), 'e' ( frequency 2), 'i' (frequency 2). The maximum frequency is 3.
 There are no consonants in s. Hence, maximum consonant frequency = 0.
 The output is 3 + 0 = 3.


 Constraints:

 1 <= s.length <= 100
 s consists of lowercase English letters only.

 Hint 1
 Use a hashmap
 Hint 2
 Simulate as described
 */
