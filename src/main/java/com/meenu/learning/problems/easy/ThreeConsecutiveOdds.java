package com.meenu.learning.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 22/09/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity : O(n)
 Space Complexity : O(1)
 */

public class ThreeConsecutiveOdds {
    public boolean threeConsecutiveOdds(int[] arr) {
        int i = 0, j = 0;

        while(j < arr.length) {
            i = j;
            while(j < arr.length && arr[j] % 2 == 0) {
                i++;
                j++;
            }
            while(j < arr.length && arr[j] % 2 == 1) {
                j++;
                if(j - i == 3)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ThreeConsecutiveOdds obj = new ThreeConsecutiveOdds();
        int[] arr = new int[] {2,6,4,1};
        System.out.println(obj.threeConsecutiveOdds(arr)); // false

        int[] arr1 = new int[] {1,2,34,3,4,5,7,23,12};
        System.out.println(obj.threeConsecutiveOdds(arr1)); //true

        int[] arr2 = new int[] {424,915,193,591,923};
        System.out.println(obj.threeConsecutiveOdds(arr2)); //true
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.


 Example 1:

 Input: arr = [2,6,4,1]
 Output: false
 Explanation: There are no three consecutive odds.
 Example 2:

 Input: arr = [1,2,34,3,4,5,7,23,12]
 Output: true
 Explanation: [5,7,23] are three consecutive odds.


 Constraints:

 1 <= arr.length <= 1000
 1 <= arr[i] <= 1000

 Hint 1
 Check every three consecutive numbers in the array for parity.
 */
