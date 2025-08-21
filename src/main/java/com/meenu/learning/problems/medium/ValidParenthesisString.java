package com.meenu.learning.problems.medium;
import java.util.Stack;

/**
 * @author Meenu V. Nair
 * @created 05/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:The time complexity is O(n) because the code iterates through the string 's' of length 'n' at most twice.
 Space Complexity:The space complexity is O(n) because in the worst case, the stacks 'open' and 'star' can store up to 'n' elements, where 'n' is the length of the input string 's'.
 */

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        // Initialize two stacks: one for storing indices of open brackets and the other for storing indices of asterisks

        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') { // If the current character is an open bracket, push its index onto the openBracket stack
                open.push(i);
            } else if(s.charAt(i) == ')') {
                if(!open.isEmpty()) { // If there's a corresponding open bracket in the openBracket stack, pop it
                    open.pop();
                } else if(!star.isEmpty()) { // If there's an asterisk in the asterisk stack, treat it as a replacement for the close bracket
                    star.pop();
                } else { // If no open bracket or asterisk is available to match the current close bracket, return false
                    return false;
                }
            } else { // If the current character is an asterisk, push its index onto the asterisk stack
                star.push(i);
            }
        }

        // Check if there are any unmatched open brackets and asterisks
        while(!open.isEmpty() && !star.isEmpty()) {
            // If an open bracket occurs after an asterisk, return false
            // As this condition will never be able to generate a valid parenthesis sequence
            if(open.peek() > star.peek()) {
                return false;
            }
            // Pop the top elements from both stacks
            open.pop();
            star.pop();
        }
        // If all open brackets can be matched with either a close bracket or an asterisk, return true
        return open.isEmpty();
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

 The following rules define a valid string:

 Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 Any right parenthesis ')' must have a corresponding left parenthesis '('.
 Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".


 Example 1:

 Input: s = "()"
 Output: true
 Example 2:

 Input: s = "(*)"
 Output: true
 Example 3:

 Input: s = "(*))"
 Output: true


 Constraints:

 1 <= s.length <= 100
 s[i] is '(', ')' or '*'.
 */
