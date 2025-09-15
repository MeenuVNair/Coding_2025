package com.meenu.learning.problems.easy;

import java.util.Arrays;
import java.util.List;

/**
 * @author Meenu V. Nair
 * @created 15/09/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(m*n), where n = text.length(), m = brokenLetters.length()
 Space Complexity : O(n)
 */

/*public class MaximumNumberOfWordsYouCanType {
    public int canBeTypedWords(String text, String brokenLetters) {
        List<String> wordList = Arrays.asList(text.split(" "));
        int count = wordList.size();
        for(String word : wordList) {
            for(char c : brokenLetters.toCharArray()) {
                if(word.contains(String.valueOf(c))) {
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}*/

/********** OPTIMISED **************/


/**
 The first solution checked each broken letter against each word using word.contains(...), causing repeated scans of words: O(m * n) in effect.
 The optimized approach builds a constant-time lookup (the boolean[26]) so each character of text is checked once → linear time.
 */


/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(m + n), where n = text.length(), m = brokenLetters.length()
 Space Complexity : O(1) (only the fixed-size broken array), excluding the input strings
 */

public class MaximumNumberOfWordsYouCanType {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken = new boolean[26];
        for(char c : brokenLetters.toCharArray()) {
            broken[c - 'a'] = true;
        }

        int count = 0;

        List<String> words = Arrays.asList(text.split(" "));
        for(String word : words) {
            boolean canType = true;
            for(char c : word.toCharArray()) {
                if(broken[c - 'a']) {
                    canType = false;
                    break;
                }
            }
            if(canType)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        MaximumNumberOfWordsYouCanType obj = new MaximumNumberOfWordsYouCanType();
        String text = "hello world";
        String brokenLetters = "ad";
        System.out.println(obj.canBeTypedWords(text, brokenLetters)); // 1
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.

 Given a string text of words separated by a single space (no leading or trailing spaces) and a string brokenLetters of all distinct letter keys that are broken, return the number of words in text you can fully type using this keyboard.



 Example 1:

 Input: text = "hello world", brokenLetters = "ad"
 Output: 1
 Explanation: We cannot type "world" because the 'd' key is broken.
 Example 2:

 Input: text = "leet code", brokenLetters = "lt"
 Output: 1
 Explanation: We cannot type "leet" because the 'l' and 't' keys are broken.
 Example 3:

 Input: text = "leet code", brokenLetters = "e"
 Output: 0
 Explanation: We cannot type either word because the 'e' key is broken.


 Constraints:

 1 <= text.length <= 104
 0 <= brokenLetters.length <= 26
 text consists of words separated by a single space without any leading or trailing spaces.
 Each word only consists of lowercase English letters.
 brokenLetters consists of distinct lowercase English letters.
 Hint 1
 Check each word separately if it can be typed.
 Hint 2
 A word can be typed if all its letters are not broken.
 */
