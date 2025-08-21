package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:O(N) due to the recursive calls made N times.
 Space Complexity:O(N) due to the call stack growing linearly with N during recursion.
 */

public class SumOfFirstNNumbers {
    public int NnumbersSum(int N) {
        if(N == 0)
            return 0;
        int sum = N + NnumbersSum(N - 1);
        return sum;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer N, return the sum of first N natural numbers. Try to solve this using recursion.


 Examples:
 Input : N = 4

 Output : 10

 Explanation : first four natural numbers are 1, 2, 3, 4.

 Sum is 1 + 2 + 3 + 4 => 10.

 Input : N = 2

 Output : 3

 Explanation : first two natural numbers are 1, 2.

 Sum is 1 + 2 => 3.

 Constraints:
 1 <= N <= 103
 */
