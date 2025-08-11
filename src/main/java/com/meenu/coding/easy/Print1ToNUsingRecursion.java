package com.meenu.coding.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 
first call recursion, then print -> to get in ascending order

 printing and then calling recursively will return in descending order
 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:The time complexity is O(n) due to the recursive calls.
 Space Complexity:The space complexity is O(n) due to the call stack.
 */

public class Print1ToNUsingRecursion {
    public void printNumbers(int n) {
        if(n == 1) {
            System.out.println(n);
            return;
        }
        printNumbers(n - 1);
        System.out.println(n);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer n, write a function to print all numbers from 1 to n (inclusive) using recursion.

 You must not use any loops such as for, while, or do-while.
 The function should print each number on a separate line, in increasing order from 1 to n.

 Examples:
 Input: n = 5

 Output:

 1

 2

 3

 4

 5

 Input: n = 1

 Output:

 1

 Constraints:
 1 <= n <= 100

 Hint 1
 You can start with the base case: when n equals 1, print the number and stop the recursion. This will act as the terminating condition for your recursion.

 Hint 2
 To print all numbers from 1 to n, you can call the function recursively with n-1 first, which ensures that the numbers print in increasing order. After the recursive call, print n to achieve the desired order.
 */
