package com.meenu.coding.easy;


/**
 * @author Meenu V. Nair
 * @created 01/08/25
 */

/*******  APPROACH ******************** 
 Initialize a variable ‘maxProfit’ to 0 and declare another variable ‘minValue’ which we will use to keep track of the buying price (minimum price from day 0 to day i) for selling the stock.
 Traverse the array from index 1 to n-1. We started at index 1 because buying and selling the stock on the 0th day will give us a profit of 0, which we have initialized our maxProfit as already.
 In each iteration, try to find the curProfit. The selling price will be Arr[i] and ‘minValue’ will give us the buying price. We calculate the curProfit. If it is more than the existing profit value (maxProfit), we update the maxProfit value.
 Before going to the next iteration, we check if the current price (Arr[i]) is less than the minValue value, and we assign it as the new mini value. In this way, we keep track of the buying price in a single iteration itself.
 */

/**
 Time Complexity:The time complexity is O(n) because the code iterates through the input array once.
 Space Complexity:The space complexity is O(1) because the code uses a fixed number of variables regardless of the input size.
 */

public class BestTimeToBuyAndSellStock {
    public int stockBuySell(int[] arr, int n) {
        int maxProfit = 0;
        int minValue = arr[0];

        for(int i = 1; i < arr.length; i++) {
            int currProfit = arr[i] - minValue;
            maxProfit = Math.max(currProfit, maxProfit);
            minValue = Math.min(minValue, arr[i]);
        }

        return maxProfit;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array arr of n integers, where arr[i] represents price of the stock on the ith day. Determine the maximum profit achievable by buying and selling the stock at most once.



 The stock should be purchased before selling it, and both actions cannot occur on the same day.


 Examples:
 Input: arr = [10, 7, 5, 8, 11, 9]

 Output: 6

 Explanation: Buy on day 3 (price = 5) and sell on day 5 (price = 11), profit = 11 - 5 = 6.

 Input: arr = [5, 4, 3, 2, 1]

 Output: 0

 Explanation: In this case, no transactions are made. Therefore, the maximum profit remains 0.

 Constraints:
 1 <= n<= 105
 0 <= arr[i] <= 106
 */
