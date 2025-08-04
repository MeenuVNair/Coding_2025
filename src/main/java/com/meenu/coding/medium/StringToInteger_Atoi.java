package com.meenu.coding.medium;


/**
 * @author Meenu V. Nair
 * @created 04/08/25
 */

/*******  APPROACH ******************** 

 */

/**
 Time Complexity:O(n), where n is the length of the input string, due to the while loops.
 Space Complexity:O(1), as the algorithm uses a constant amount of extra space.
 */

public class StringToInteger_Atoi {
    public int myAtoi(String input) {
        int n = input.length();
        int i = 0;

        while(i < n && input.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;
        if(i < n && input.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if(i < n && input.charAt(i) == '+') {
            i++;
        }

        long result = 0;
        while(i < n && Character.isDigit(input.charAt(i))) {
            result = result * 10 + (input.charAt(i) - '0');
            i++;

            if(result * sign >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(result * sign <= Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }
        return (int) result * sign;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 

 */
