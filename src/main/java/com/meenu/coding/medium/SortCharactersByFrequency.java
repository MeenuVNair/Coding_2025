package com.meenu.coding.medium;


/**
 * @author Meenu V. Nair
 * @created 06/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.*;

/**** COMPLEXITY ANALYSIS ********************
Time Complexity : O(Nlog(N))
 */

/*public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList<>(freqMap.keySet());
        list.sort((a, b) -> freqMap.get(b) - freqMap.get(a));

        StringBuilder outputString = new StringBuilder();
        for(Character c : list) {
            int frequency = freqMap.get(c);
            while(frequency != 0) {
                outputString.append(c);
                frequency--;
            }
        }

        return outputString.toString();
    }
}*/

/**********  WITH MAX HEAP *********/

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity :
 */

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        StringBuilder outputString = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            int frequency = freqMap.get(c);
            while(frequency != 0) {
                outputString.append(c);
                frequency--;
            }
        }

        return outputString.toString();
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

 Return the sorted string. If there are multiple answers, return any of them.



 Example 1:

 Input: s = "tree"
 Output: "eert"
 Explanation: 'e' appears twice while 'r' and 't' both appear once.
 So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 Example 2:

 Input: s = "cccaaa"
 Output: "aaaccc"
 Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
 Note that "cacaca" is incorrect, as the same characters must be together.
 Example 3:

 Input: s = "Aabb"
 Output: "bbAa"
 Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 Note that 'A' and 'a' are treated as two different characters.


 Constraints:

 1 <= s.length <= 5 * 105
 s consists of uppercase and lowercase English letters and digits.
 */
