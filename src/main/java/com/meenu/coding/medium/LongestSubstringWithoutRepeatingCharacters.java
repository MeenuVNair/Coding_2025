package com.meenu.coding.medium;


/**
 * @author Meenu V. Nair
 * @created 13/08/25
 */

/*******  APPROACH ******************** 
 We can iterate through the given string with index r as the right boundary and l as the left boundary of the window.
 We use a hash set to check if the character is present in the window or not.
 When we encounter a character at index r that is already present in the window,we shrink the window by incrementing the l pointer until the window no longer contains any duplicates.
 Also, we remove characters from the hash set that are excluded from the window as the l pointer moves.
 At each iteration, we update the result with the length of the current window, r - l + 1, if this length is greater than the current result.
 */

import java.util.HashSet;
import java.util.Set;

/**** COMPLEXITY ANALYSIS ********************
 Time complexity: O(n)
 Space complexity: O(m)
 */

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        for(int j = i; j < s.length(); j++) {
            while(set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            maxLength = Math.max(maxLength, j - i + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();
        String input = "bbbbb"; //"pwwkew"; //"abcabcbb";
        int expectedOutput = 1; //3;
        int actualOutput = obj.lengthOfLongestSubstring(input);
        System.out.println(expectedOutput == actualOutput ? "Passed" : "Failed");
        System.out.println("Expected output : " + expectedOutput + "\nActual output : " + actualOutput);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a string s, find the length of the longest substring without duplicate characters.



 Example 1:

 Input: s = "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.
 Example 2:

 Input: s = "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.
 Example 3:

 Input: s = "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


 Constraints:

 0 <= s.length <= 5 * 104
 s consists of English letters, digits, symbols and spaces.

 Hint 1
 Generate all possible substrings & check for each substring if it's valid and keep updating maxLen accordingly.
 */
