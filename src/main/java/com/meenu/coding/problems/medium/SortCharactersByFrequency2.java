package com.meenu.coding.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 06/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity: O(n + klogk), where n is the length of the string s and k is the number of unique characters (at most 26) which simplifies to O(n + 26log26) which can be further simplified to O(n).
 Space Complexity: O(k), where k is the number of unique characters (at most 26), thus O(1).
 */

public class SortCharactersByFrequency2 {
    public List<Character> frequencySort(String s) {
        Pair[] frequency = new Pair[26];
        for(int i = 0; i < 26; i++) {
            frequency[i] = new Pair(0, (char)(i + 'a'));
        }

        for(char c : s.toCharArray()) {
            frequency[c - 'a'].freq++;
        }

        Arrays.sort(frequency, (p1, p2) -> {
            if(p1.freq != p2.freq) return p2.freq - p1.freq;
            return p1.character - p2.character;
        });

        List<Character> result = new ArrayList<>();
        for(Pair p : frequency) {
            if(p.freq > 0)
                result.add(p.character);
        }

        return result;
    }

    class Pair {
        int freq;
        char character;
        Pair(int freq, char c) {
            this.freq = freq;
            this.character = c;
        }
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given a string s. Return the array of unique characters, sorted by highest to lowest occurring characters.

 If two or more characters have same frequency then arrange them in alphabetic order.


 Examples:
 Input : s = "tree"

 Output : ['e', 'r', 't' ]

 Explanation : The occurrences of each character are as shown below :

 e --> 2

 r --> 1

 t --> 1.

 The r and t have same occurrences , so we arrange them by alphabetic order.

 Input : s = "raaaajj"

 Output : ['a' , 'j', 'r' ]

 Explanation : The occurrences of each character are as shown below :

 a --> 4

 j --> 2

 r --> 1

 Constraints:
 1 <= s.length <= 105
 s consist of only lowercase English characters.
 */
