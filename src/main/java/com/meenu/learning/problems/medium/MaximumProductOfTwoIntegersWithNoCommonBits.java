package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 16/09/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity : 
 Space Complexity : 
 */

public class MaximumProductOfTwoIntegersWithNoCommonBits {
    public long maxProduct(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int mask = (1 << (32 - Integer.numberOfLeadingZeros(max))) - 1;
        boolean[] has = new boolean[mask + 1];
        for (int num : nums) {
            has[num] = true;
        }
        long res = 0;
        for (int i = mask / 2; i >= 1; i--) {
            if (!has[i])
                continue;
            for (int j = i ^ mask; (long) j * i > res; j = (j - 1) & (i ^ mask)) {
                if (has[j]) {
                    res = (long) j * i;
                    break;
                }
            }
        }
        return res;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 You are given an integer array nums.

 Your task is to find two distinct indices i and j such that the product nums[i] * nums[j] is maximized, and the binary representations of nums[i] and nums[j] do not share any common set bits.

 Return the maximum possible product of such a pair. If no such pair exists, return 0.



 Example 1:

 Input: nums = [1,2,3,4,5,6,7]

 Output: 12

 Explanation:

 The best pair is 3 (011) and 4 (100). They share no set bits and 3 * 4 = 12.

 Example 2:

 Input: nums = [5,6,4]

 Output: 0

 Explanation:

 Every pair of numbers has at least one common set bit. Hence, the answer is 0.

 Example 3:

 Input: nums = [64,8,32]

 Output: 2048

 Explanation:

 No pair of numbers share a common bit, so the answer is the product of the two maximum elements, 64 and 32 (64 * 32 = 2048).



 Constraints:

 2 <= nums.length <= 105
 1 <= nums[i] <= 106

 Hint 1
 Think of each number as a mask: treat nums[i] as a bitmask.
 Hint 2
 Create an array dp of size 1<, where B is your bit‑width.
 Hint 3
 Initialize dp[mask] to the maximum nums[i] exactly equal to that mask, or 0 if none.
 Hint 4
 For each m, propagate to all its super‑masks M: dp[m] = max(dp[m], dp[M])
 Hint 5
 For a number x with mask mx, compute its "complement mask" as cm = ~mx & ((1<.
 Hint 6
 The best disjoint partner is then dp[cm].
 Hint 7
 Loop over all x in nums, look up dp[cm], and track the maximum x * partner.
 */
