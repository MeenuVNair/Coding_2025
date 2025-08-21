package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 05/08/25
 */

/*******  APPROACH ********************
 We need to check if the given string reads the same forward and backward ignoring cases and non-alphanumeric characters.
 To make this easier, we clean the string first, then use two pointers to compare characters from both ends.


 Clean the string using regex to remove non-alphanumeric characters and convert to lowercase.
 Check for edge case: If the cleaned string is empty, return true.
 Use two pointers (i at start, j at end):
 Compare characters at i and j.
 If they match, move inward.
 If not, return false.
 If the loop completes, return true.
 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time complexity: O(n):
    Cleaning the string using replaceAll() and toLowerCase() takes O(n
    Two-pointer traversal takes O(n)
 Space complexity: O(n):
    We create a new cleaned string of length up to n
 */

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String spaceRemovedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if(spaceRemovedString == "")
            return true;

        int i = 0, j = spaceRemovedString.length() - 1;
        while(i < j) {
            if(spaceRemovedString.charAt(i) != spaceRemovedString.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

 Given a string s, return true if it is a palindrome, or false otherwise.



 Example 1:

 Input: s = "A man, a plan, a canal: Panama"
 Output: true
 Explanation: "amanaplanacanalpanama" is a palindrome.
 Example 2:

 Input: s = "race a car"
 Output: false
 Explanation: "raceacar" is not a palindrome.
 Example 3:

 Input: s = " "
 Output: true
 Explanation: s is an empty string "" after removing non-alphanumeric characters.
 Since an empty string reads the same forward and backward, it is a palindrome.


 Constraints:

 1 <= s.length <= 2 * 105
 s consists only of printable ASCII characters.
 */
