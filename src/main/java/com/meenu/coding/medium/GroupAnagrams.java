package com.meenu.coding.medium;


/**
 * @author Meenu V. Nair
 * @created 05/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.*;

/**** COMPLEXITY ANALYSIS ********************
 Time complexity: O(m∗n)
 Space complexity: O(m) extra space.
                    O(m∗n) space for the output list.
                    Where m is the number of strings and n is the length of the longest string.
 */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        for(String s : strs) {
            int[] count = new int[26];
            for(char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(s);
        }
        return new ArrayList<>(result.values());
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

 An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

 Example 1:

 Input: strs = ["act","pots","tops","cat","stop","hat"]

 Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
 Example 2:

 Input: strs = ["x"]

 Output: [["x"]]
 Example 3:

 Input: strs = [""]

 Output: [[""]]
 Constraints:

 1 <= strs.length <= 1000.
 0 <= strs[i].length <= 100
 strs[i] is made up of lowercase English letters.
 */
