package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 06/08/25
 */

/*******  APPROACH ******************** 
 To simulate typing with backspaces, we can use a Stack.
 Every time we encounter a character, we push it.
 If we encounter #, we pop from the stack (if it's not empty).

 */

import java.util.Stack;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity: O(n + m) — where n and m are lengths of s and t
 Space Complexity: O(n + m) — for storing final characters in stacks
 */

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStack = new Stack<>();
        Stack<Character> tStack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(c != '#') {
                sStack.push(c);
            } else if(!sStack.isEmpty()) {
                sStack.pop();
            }
        }

        for(char c : t.toCharArray()) {
            if(c != '#') {
                tStack.push(c);
            } else if(!tStack.isEmpty()) {
                tStack.pop();
            }
        }

        while(!sStack.isEmpty()) {
            char c = sStack.pop();
            if(tStack.isEmpty() || tStack.pop() != c){
                return false;
            }
        }
        return sStack.isEmpty() && tStack.isEmpty();
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

 Note that after backspacing an empty text, the text will continue empty.



 Example 1:

 Input: s = "ab#c", t = "ad#c"
 Output: true
 Explanation: Both s and t become "ac".
 Example 2:

 Input: s = "ab##", t = "c#d#"
 Output: true
 Explanation: Both s and t become "".
 Example 3:

 Input: s = "a#c", t = "b"
 Output: false
 Explanation: s becomes "c" while t becomes "b".


 Constraints:

 1 <= s.length, t.length <= 200
 s and t only contain lowercase letters and '#' characters.


 Follow up: Can you solve it in O(n) time and O(1) space?
 */
