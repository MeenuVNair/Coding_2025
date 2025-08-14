package com.meenu.coding.medium;


/**
 * @author Meenu V. Nair
 * @created 14/08/25
 */

/*******  APPROACH ******************** 
 1. Two pointers start at opposite ends
        l (left pointer) starts at index 0.
        r (right pointer) starts at the last index.
 2. Keep track of the tallest bars seen so far
        leftmax = tallest bar from the left so far.
        rightmax = tallest bar from the right so far.
 3. Move the pointer with the smaller max
    If leftmax < rightmax, it means the water level on the left is limited by leftmax.
        Move the left pointer one step to the right (l++).
        Update leftmax if the new bar is taller.
        Water trapped at this position = leftmax - height[l].
    Else (rightmax <= leftmax), the water level on the right is limited by rightmax.
        Move the right pointer one step to the left (r--).
        Update rightmax if the new bar is taller.
        Water trapped at this position = rightmax - height[r].
 4. Repeat until left and right pointers meet
 5. Accumulate trapped water in water.
 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n)
 Space Complexity : O(1)
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int water = 0;
        int leftMax = height[0], rightMax = height[height.length - 1];
        while(i < j) {
            if(leftMax < rightMax) {
                i++;
                leftMax = Math.max(leftMax, height[i]);
                water += leftMax - height[i];
            } else {
                j--;
                rightMax = Math.max(rightMax, height[j]);
                water += rightMax - height[j];
            }
        }
        return water;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 Example 1:

 Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 Output: 6
 Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 Example 2:

 Input: height = [4,2,0,3,2,5]
 Output: 9

 Constraints:

 n == height.length
 1 <= n <= 2 * 104
 0 <= height[i] <= 105
 */
