package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 13/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 

 */

public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int i = 0;
        int count = 0;

        while(i <= arr.length - k) {
            int j = i + 1;
            int sum = arr[i];
            while(j < Math.min(arr.length, i + k)) {
                sum += arr[j];
                j++;
            }
            int average = sum / k;
            if(average >= threshold && (j - i) == k)
                count++;
            i++;
        }
        return count;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size k and average greater than or equal to threshold.



 Example 1:

 Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 Output: 3
 Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).
 Example 2:

 Input: arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
 Output: 6
 Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.


 Constraints:

 1 <= arr.length <= 105
 1 <= arr[i] <= 104
 1 <= k <= arr.length
 0 <= threshold <= 104

 Hint 1
 Start with a window of size K and test its average against the threshold.
 Hint 2
 Keep moving the window by one element maintaining its size k until you cover the whole array. Count the number of windows that have an average greater than or equal to the threshold.
 */
