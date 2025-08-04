package com.meenu.coding.easy;


/**
 * @author Meenu V. Nair
 * @created 04/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time complexity: O(n)
 Space complexity:O(26) → O(1)
 */

/*public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        int[] counts = new int[26];
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for(int count : counts) {
            if(count != 0) {
                return false;
            }
        }
        return true;
    }
}*/

import java.util.HashMap;
import java.util.Map;

/** with hash map */
/**
Time complexity: O(n)
Space complexity:O(26) → O(1)
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> counts = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            counts.put(s.charAt(i), counts.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            if(!counts.containsKey(t.charAt(i)) || counts.get(t.charAt(i)) == 0) {
                return false;
            }
            counts.put(t.charAt(i), counts.get(t.charAt(i)) - 1);
        }

        return true;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given two strings s and t, return true if t is an anagram of s, and false otherwise.



 Example 1:

 Input: s = "anagram", t = "nagaram"

 Output: true

 Example 2:

 Input: s = "rat", t = "car"

 Output: false



 Constraints:

 1 <= s.length, t.length <= 5 * 104
 s and t consist of lowercase English letters.


 Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
