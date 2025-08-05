package com.meenu.coding.easy;


/**
 * @author Meenu V. Nair
 * @created 05/08/25
 */

/*******  APPROACH ******************** 
 Instead of reversing the entire sentence, we reverse each word individually while preserving their original order

 1. Split the input string by spaces using regex \\s+ to handle multiple spaces.
 2. For each word:
 - Reverse it manually using a loop.
 - Append the reversed word and a space to a StringBuilder.
 3. Trim the final string to remove the trailing space.

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time complexity: O(n)
                Every character is visited exactly once.
 Space complexity: O(n)
                For the wordList array and the StringBuilder.
 */

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        String[] wordList = s.split("\\s+");

        StringBuilder reversedString = new StringBuilder();
        for(int i = 0; i < wordList.length; i++) {
            String currentWord = wordList[i];
            int j = currentWord.length() - 1;
            while(j >= 0) {
                reversedString.append(currentWord.charAt(j--));
            }
            reversedString.append(" ");
        }

        return reversedString.toString().trim();
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.



 Example 1:

 Input: s = "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Example 2:

 Input: s = "Mr Ding"
 Output: "rM gniD"


 Constraints:

 1 <= s.length <= 5 * 104
 s contains printable ASCII characters.
 s does not contain any leading or trailing spaces.
 There is at least one word in s.
 All the words in s are separated by a single space.
 */
