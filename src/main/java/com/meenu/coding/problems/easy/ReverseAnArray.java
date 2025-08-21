package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 11/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:O(n) because the while loop iterates at most n/2 times, where n is the length of the array.
 Space Complexity:O(1) as it uses a constant amount of extra space for variables like i, j, and temp, regardless of the input array size.
 */

public class ReverseAnArray {
    public void reverse(int[] arr, int n) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 ay [1,2,1,1,5,1] is [1,5,1,1,2,1].

 Input: n=3, arr = [1,2,1]

 Output:
 [2,1,2]
 [1,2,1]
 [1,1,2]
 [2,1,1]
 🎉 Correct! You’ve earned 10 points!
 Constraints:
 1 <= n <= 104

 1 <= arr[i] <= 105
 */
