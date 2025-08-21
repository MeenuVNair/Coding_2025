package com.meenu.learning.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 08/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time complexity : O(n log n)
    Outer loop runs n times.
    Inner loop runs for each i proportional to the number of bits in i, i.e., O(log i).
 Space Complexity : O(n)
    You allocate an array of size n+1 to store the results: O(n)
    No other significant space usage (no recursion, no extra data structures).
 */

public class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        if(n == 0) {
            result[0] = 0;
            return result;
        }

        for(int i = 1; i <= n; i++) {
            int count = 0;
            int num = i;
            while(num > 0) {
                if((num & 1) == 1)
                    count++;
                num = num >> 1;
            }
            result[i] = count;
        }
        return result;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.



 Example 1:

 Input: n = 2
 Output: [0,1,1]
 Explanation:
 0 --> 0
 1 --> 1
 2 --> 10
 Example 2:

 Input: n = 5
 Output: [0,1,1,2,1,2]
 Explanation:
 0 --> 0
 1 --> 1
 2 --> 10
 3 --> 11
 4 --> 100
 5 --> 101


 Constraints:

 0 <= n <= 105


 Follow up:

 It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
 Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
 */
