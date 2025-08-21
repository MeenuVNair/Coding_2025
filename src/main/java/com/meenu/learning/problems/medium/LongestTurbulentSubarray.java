package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 12/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 TC : O(n2)
 SC : O(1)
 */

/***********  BRUTE FORCE   **************************/

/*public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] arr) {
        int result = 1;
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i + 1]) continue;
            int sign = arr[i] > arr[i + 1] ? 1 : 0;
            int j = i + 1;
            while(j < arr.length - 1) {
                if(arr[j] == arr[j + 1]) break;
                int currSign = arr[j] > arr[j + 1] ? 1 : 0;
                if(currSign == sign) break;

                sign = currSign;
                j++;
            }
            result = Math.max(result, j - i + 1);
        }
        return result;
    }
}*/

/***********  DP (Top Down)   **************************/

public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int[][] memo = new int[n][2];

        for(int i = 0; i < n; i++) {
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
        int maxLength = 1;
        for(int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, checkMaxTurbulent(i, n, true, arr, memo));
            maxLength = Math.max(maxLength, checkMaxTurbulent(i, n, false, arr, memo));
        }
        return maxLength;
    }

    private int checkMaxTurbulent(int i, int n, boolean sign, int[] arr, int[][] memo) {
        int signIndex = sign ? 1 : 0;
        if(i == n - 1) {
            return 1;
        }
        if(memo[i][signIndex] != -1) {
            return memo[i][signIndex];
        }

        int result = 1;
        if((sign && arr[i] > arr[i + 1])
                || (!sign && arr[i] < arr[i + 1])) {
            result = 1 + checkMaxTurbulent(i + 1, n, !sign, arr, memo);
            memo[i][signIndex] = result;
        }
        return result;
    }
}


/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer array arr, return the length of a maximum size turbulent subarray of arr.

 A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

 More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:

 For i <= k < j:
 arr[k] > arr[k + 1] when k is odd, and
 arr[k] < arr[k + 1] when k is even.
 Or, for i <= k < j:
 arr[k] > arr[k + 1] when k is even, and
 arr[k] < arr[k + 1] when k is odd.


 Example 1:

 Input: arr = [9,4,2,10,7,8,8,1,9]
 Output: 5
 Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
 Example 2:

 Input: arr = [4,8,12,16]
 Output: 2
 Example 3:

 Input: arr = [100]
 Output: 1

 Constraints:

 1 <= arr.length <= 4 * 104
 0 <= arr[i] <= 109
 */
