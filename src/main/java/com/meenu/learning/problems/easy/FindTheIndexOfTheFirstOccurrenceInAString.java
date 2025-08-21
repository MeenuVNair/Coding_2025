package com.meenu.learning.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 04/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time: O((N - M) * M)
 Space: O(1)
 */

public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        int length1 = haystack.length();
        int length2 = needle.length();
        if(length2 > length1)
            return -1;

        int i = 0, j = 0;

        while(i < length1) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if(j == length2)
                    return i - length2;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        return -1;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



 Example 1:

 Input: haystack = "sadbutsad", needle = "sad"
 Output: 0
 Explanation: "sad" occurs at index 0 and 6.
 The first occurrence is at index 0, so we return 0.
 Example 2:

 Input: haystack = "leetcode", needle = "leeto"
 Output: -1
 Explanation: "leeto" did not occur in "leetcode", so we return -1.


 Constraints:

 1 <= haystack.length, needle.length <= 104
 haystack and needle consist of only lowercase English characters.
 */
