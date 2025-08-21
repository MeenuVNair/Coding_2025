package com.meenu.coding.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 05/08/25
 */

/*******  APPROACH ******************** 
 To reverse the words in a sentence, we need to:
 Ignore extra spaces
 Split the sentence into words
 Rebuild the sentence with words in reverse order

 1. Trim leading/trailing spaces.
 2. Split the string by one or more spaces using regex: \\s+.
 3. Iterate in reverse through the words array.
 4. Append each word followed by a space to a StringBuilder.
 5. Finally, trim the result to remove the trailing space.
 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity: O(n) because the code iterates through the cleaned string array once to reverse the words.
 Space Complexity: O(n) because the StringBuilder `reversedStringBuilder` and the `words` array can grow linearly with the input string's length.
 */

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        StringBuilder reversedStringBuilder = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
            reversedStringBuilder.append(words[i]);
            reversedStringBuilder.append(" ");
        }

        return reversedStringBuilder.toString().trim();
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an input string s, reverse the order of the words.

 A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

 Return a string of the words in reverse order concatenated by a single space.

 Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.



 Example 1:

 Input: s = "the sky is blue"
 Output: "blue is sky the"
 Example 2:

 Input: s = "  hello world  "
 Output: "world hello"
 Explanation: Your reversed string should not contain leading or trailing spaces.
 Example 3:

 Input: s = "a good   example"
 Output: "example good a"
 Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


 Constraints:

 1 <= s.length <= 104
 s contains English letters (upper-case and lower-case), digits, and spaces ' '.
 There is at least one word in s.


 Follow-up: If the string data type is mutable in your language, can you solve it in-place with O(1) extra space?
 */
