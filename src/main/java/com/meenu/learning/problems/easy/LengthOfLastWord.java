package com.meenu.learning.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 31/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity : O(n)
 Space Complexity : O(n)
 */

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int spaceCount = 0;
        int word = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' ') {
                length++;
                word++;
            }
            else if(s.charAt(i) == ' ' && word == 0) {
                while(i >= 0 && s.charAt(i) != ' ') {
                    i--;
                }
                if(i >= 0 && s.charAt(i) != ' ')
                    word++;
            } else {
                break;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        LengthOfLastWord obj = new LengthOfLastWord();
        System.out.println(obj.lengthOfLastWord("Hello World"));
        System.out.println(obj.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(obj.lengthOfLastWord("luffy is still joyboy"));
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a string s consisting of words and spaces, return the length of the last word in the string.

 A word is a maximal substring consisting of non-space characters only.

 Example 1:

 Input: s = "Hello World"
 Output: 5
 Explanation: The last word is "World" with length 5.
 Example 2:

 Input: s = "   fly me   to   the moon  "
 Output: 4
 Explanation: The last word is "moon" with length 4.
 Example 3:

 Input: s = "luffy is still joyboy"
 Output: 6
 Explanation: The last word is "joyboy" with length 6.


 Constraints:

 1 <= s.length <= 104
 s consists of only English letters and spaces ' '.
 There will be at least one word in s.
 */
