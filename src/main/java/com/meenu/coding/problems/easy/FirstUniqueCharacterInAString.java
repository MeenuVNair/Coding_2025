package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 04/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.HashMap;
import java.util.Map;

/**** COMPLEXITY ANALYSIS ********************
 Time complexity: O(n)
 Space complexity: O(26) → O(1)
 */

/*public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, i);
            } else {
                map.put(c, -1);
            }
        }

        int min = Integer.MAX_VALUE;
        for(char c : map.keySet()) {
            if(map.get(c) > -1 && map.get(c) < min) {
                min = map.get(c);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}*/

/** EVEN SIMPLER SOLUTION (complexity remains same) */


public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.



 Example 1:

 Input: s = "leetcode"

 Output: 0

 Explanation:

 The character 'l' at index 0 is the first character that does not occur at any other index.

 Example 2:

 Input: s = "loveleetcode"

 Output: 2

 Example 3:

 Input: s = "aabb"

 Output: -1



 Constraints:

 1 <= s.length <= 105
 s consists of only lowercase English letters.
 */
