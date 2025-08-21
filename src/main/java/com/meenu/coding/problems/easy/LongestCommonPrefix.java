package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 06/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:O(S), where S is the total number of characters in all strings, more precisely O(N*M) where N is the number of strings and M is the length of the shortest string.
 Space Complexity:O(1), excluding the space needed for the input array; otherwise, it's O(M) where M is the length of the longest common prefix.
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if(strs == null || strs.length == 0)
            return prefix;

        int index = 0;
        for(char c : strs[0].toCharArray()) {
            for(int i = 1; i < strs.length; i++) {
                if(index >= strs[i].length() || c != strs[i].charAt(index))
                    return prefix;
            }
            prefix += c;
            index++;
        }
        return prefix;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Write a function to find the longest common prefix string amongst an array of strings.

 If there is no common prefix, return an empty string "".



 Example 1:

 Input: strs = ["flower","flow","flight"]
 Output: "fl"
 Example 2:

 Input: strs = ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.

 Example 3:

 Input: strs = ["bat","bag","bank","band"]

 Output: "ba"
 Example 4:

 Input: strs = ["dance","dag","danger","damage"]

 Output: "da"
 Example 5:

 Input: strs = ["neet","feet"]

 Output: ""


 Constraints:

 1 <= strs.length <= 200
 0 <= strs[i].length <= 200
 strs[i] consists of only lowercase English letters if it is non-empty.
 */
