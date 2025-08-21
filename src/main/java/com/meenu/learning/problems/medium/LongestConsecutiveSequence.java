package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 20/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.HashSet;
import java.util.Set;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n^2)
 Space Complexity : O(n)
 */

/********** BRUTE FORCE (Time Limit Exceeded) ********************/

/*public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int streak = 0, result = 0;
        for(int num : nums) {
            streak = 0;
            int curr = num;
            while(set.contains(curr)) {
                streak++;
                curr++;
            }
            result = Math.max(result, streak);
        }
        return result;
    }
}*/

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n)
 Space Complexity : O(n)
 */

/********** HashSet ********************/

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int longest = 0;
        for(int num : set) {
            if(!set.contains(num - 1)) {
                int curr = num + 1;
                int count = 1;
                while(set.contains(curr)) {
                    count++;
                    curr++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

 You must write an algorithm that runs in O(n) time.



 Example 1:

 Input: nums = [100,4,200,1,3,2]
 Output: 4
 Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 Example 2:

 Input: nums = [0,3,7,2,5,8,4,6,0,1]
 Output: 9
 Example 3:

 Input: nums = [1,0,1,2]
 Output: 3


 Constraints:

 0 <= nums.length <= 105
 -109 <= nums[i] <= 109

 Recommended Time & Space Complexity
 You should aim for a solution as good or better than O(n) time and O(n) space, where n is the size of the input array.

 Hint 1
 A brute force solution would be to consider every element from the array as the start of the sequence and count the length of the sequence formed with that starting element. This would be an O(n^2) solution. Can you think of a better way?

 Hint 2
 Is there any way to identify the start of a sequence? For example, in [1, 2, 3, 10, 11, 12], only 1 and 10 are the beginning of a sequence. Instead of trying to form a sequence for every number, we should only consider numbers like 1 and 10.

 Hint 3
 We can consider a number num as the start of a sequence if and only if num - 1 does not exist in the given array. We iterate through the array and only start building the sequence if it is the start of a sequence. This avoids repeated work. We can use a hash set for O(1) lookups by converting the array to a hash set.
 */
