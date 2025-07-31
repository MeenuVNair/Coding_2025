package com.meenu.coding.easy;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() == 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            else {
                if(stack.isEmpty())
                    return false;
                if((s.charAt(i) == ')' && stack.peek() != '(') ||
                        (s.charAt(i) == '}' && stack.peek() != '{') ||
                        (s.charAt(i) == ']' && stack.peek() != '['))
                    return false;

                else
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }
}


/**

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true

Example 5:

Input: s = "([)]"

Output: false



Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
 */