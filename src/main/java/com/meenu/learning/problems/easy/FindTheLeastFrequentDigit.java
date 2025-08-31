package com.meenu.learning.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 31/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.Map;
import java.util.TreeMap;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : 
 Space Complexity : 
 */

public class FindTheLeastFrequentDigit {
    public int getLeastFrequentDigit(int n) {
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        int temp = n;
        while(temp != 0) {
            int digit = temp % 10;
            temp = temp / 10;
            freqMap.put(digit, freqMap.getOrDefault(digit, 0) + 1);
        }
        int min = Integer.MAX_VALUE;
        int result = -1;
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            if(entry.getValue() < min) {
                min = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindTheLeastFrequentDigit obj = new FindTheLeastFrequentDigit();
        System.out.println(obj.getLeastFrequentDigit(1553322)); // 1
        System.out.println(obj.getLeastFrequentDigit(723344511)); // 2
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an integer n, find the digit that occurs least frequently in its decimal representation. If multiple digits have the same frequency, choose the smallest digit.

 Return the chosen digit as an integer.

 The frequency of a digit x is the number of times it appears in the decimal representation of n.


 Example 1:

 Input: n = 1553322

 Output: 1

 Explanation:

 The least frequent digit in n is 1, which appears only once. All other digits appear twice.

 Example 2:

 Input: n = 723344511

 Output: 2

 Explanation:

 The least frequent digits in n are 7, 2, and 5; each appears only once.



 Constraints:

 1 <= n <= 2^31- 1

 */
