package com.meenu.coding.easy;

/**
 * @author Meenu V. Nair
 * @created 31/07/25
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n <= 3) {
            return n;
        }

        int prev1 = 3;
        int prev2 = 2;
        int curr = 0;

        for(int i = 3; i < n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}

/**
 *
 You are climbing a staircase. It takes n steps to reach the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



 Example 1:

 Input: n = 2
 Output: 2
 Explanation: There are two ways to climb to the top.
 1. 1 step + 1 step
 2. 2 steps
 Example 2:

 Input: n = 3
 Output: 3
 Explanation: There are three ways to climb to the top.
 1. 1 step + 1 step + 1 step
 2. 1 step + 2 steps
 3. 2 steps + 1 step


 Constraints:

 1 <= n <= 45
 */
