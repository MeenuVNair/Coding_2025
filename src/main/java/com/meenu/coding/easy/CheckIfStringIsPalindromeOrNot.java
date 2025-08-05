package com.meenu.coding.easy;


/**
 * @author Meenu V. Nair
 * @created 05/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:O(n) because in the worst case, the while loop iterates through half of the string to check for palindrome.
 Space Complexity:O(1) because it uses a constant amount of extra space regardless of the input string size.
 */

public class CheckIfStringIsPalindromeOrNot {
    public boolean palindromeCheck(String s) {
        if(s != null && s.length() == 1)
            return true;

        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a string s, return true if the string is palindrome, otherwise false.



 A string is called palindrome if it reads the same forward and backward.


 Examples:
 Input : s = "hannah"

 Output : true

 Explanation : The string when reversed is --> "hannah", which is same as original string , so we return true.

 Input : s = "aabbaaa"

 Output : false

 Explanation : The string when reversed is --> "aaabbaa", which is not same as original string, So we return false.

 Constraints:
 1 <= s.length <= 103
 s consist of only uppercase and lowercase English characters.
 */
