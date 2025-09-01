package com.meenu.learning.problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Meenu V. Nair
 * @created 01/09/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(n)
 Space Complexity : O(n)
 where n is the total number of characters across all strings in the input list (strs for encode, and the length of the encoded string str for decode).
 */

public class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            int len = s.length();
            sb.append(len);
            sb.append("#");
            sb.append(s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        StringBuilder sb;
        List<String> decodedString = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            String len = "";
            while(str.charAt(i) != '#') {
                len = len + str.charAt(i);
                i++;
            }
            int length = Integer.parseInt(len);
            sb = new StringBuilder();
            int j;
            for(j = i + 1; j <= i + length; j++) {
                sb.append(str.charAt(j));
            }
            decodedString.add(sb.toString());
            i = j;
        }
        return decodedString;
    }

    public static void main(String[] args) {
        EncodeAndDecodeStrings obj = new EncodeAndDecodeStrings();
        List<String> input = new ArrayList<>();
        input.add("neet");
        input.add("code");
        input.add("love");
        input.add("you");
        String encoded = obj.encode(input);
        System.out.println("Encoded string : " + encoded);
        List<String> decoded = obj.decode(encoded);
        System.out.println("Decoded String : " + decoded.toString());
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

 Please implement encode and decode

 Example 1:

 Input: ["neet","code","love","you"]

 Output:["neet","code","love","you"]
 Example 2:

 Input: ["we","say",":","yes"]

 Output: ["we","say",":","yes"]
 Constraints:

 0 <= strs.length < 100
 0 <= strs[i].length < 200
 strs[i] contains only UTF-8 characters.


 Recommended Time & Space Complexity
 You should aim for a solution with O(m) time for each encode() and decode() call and O(m+n) space, where m is the sum of lengths of all the strings and n is the number of strings.


 Hint 1
 A naive solution would be to use a non-ascii character as a delimiter. Can you think of a better way?


 Hint 2
 Try to encode and decode the strings using a smart approach based on the lengths of each string. How can you differentiate between the lengths and any numbers that might be present in the strings?


 Hint 3
 We can use an encoding approach where we start with a number representing the length of the string, followed by a separator character (let's use # for simplicity), and then the string itself. To decode, we read the number until we reach a #, then use that number to read the specified number of characters as the string.
 */
