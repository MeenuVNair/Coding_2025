package com.meenu.learning.problems.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Meenu V. Nair
 * @created 24/09/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n)
 Space Complexity : O(n)
 */

public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean isNegative = (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) ? true : false;
        long numeratorL = Math.abs((long) numerator);
        long denominatorL = Math.abs((long) denominator);
        Map<Long, Integer> previousRemains = new HashMap<Long, Integer>();
        StringBuilder sb = new StringBuilder();
        long quotian = numeratorL / denominatorL;
        sb.append(quotian);

        numeratorL %= denominatorL;

        if (numeratorL != 0) {
            sb.append(".");
        }

        int quotianIndex = 0;
        while (numeratorL != 0) {
            numeratorL *= 10;
            quotian = Math.abs(numeratorL / denominatorL);
            if (!previousRemains.containsKey(numeratorL)) {
                sb.append(quotian);
                previousRemains.put(numeratorL, quotianIndex++);
            } else {
                int firstIndex = 1 + previousRemains.get(numeratorL) + sb.indexOf(".");
                sb.insert(firstIndex, '(');
                sb.append(")");
                break;
            }
            numeratorL %= denominatorL;
        }

        if (isNegative) {
            sb.insert(0, "-");
        }
        return sb.toString();
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 If multiple answers are possible, return any of them.

 It is guaranteed that the length of the answer string is less than 104 for all the given inputs.



 Example 1:

 Input: numerator = 1, denominator = 2
 Output: "0.5"
 Example 2:

 Input: numerator = 2, denominator = 1
 Output: "2"
 Example 3:

 Input: numerator = 4, denominator = 333
 Output: "0.(012)"


 Constraints:

 -231 <= numerator, denominator <= 231 - 1
 denominator != 0


 Hint 1
 No scary math, just apply elementary math knowledge. Still remember how to perform a long division?
 Hint 2
 Try a long division on 4/9, the repeating part is obvious. Now try 4/333. Do you see a pattern?
 Hint 3
 Notice that once the remainder starts repeating, so does the divided result.
 Hint 4
 Be wary of edge cases! List out as many test cases as you can think of and test your code thoroughly.

 */
