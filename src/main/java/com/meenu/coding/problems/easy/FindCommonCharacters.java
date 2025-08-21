package com.meenu.coding.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 07/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity: O(n * L)

 Space Complexity: O(L)
 (excluding output, it's O(1) extra space)

 n = number of words
 L = average length of each word (worst case: max length)

 */

public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        int[] arr = new int[26];
        Arrays.fill(arr, Integer.MAX_VALUE);

        // iterate through all words in the given list
        for(int i = 0; i < words.length; i++) {
            // to store frequency of each characters in the current word
            int[] tempArray = new int[26];
            for(int j = 0; j < words[i].length(); j++) {
                int ind = words[i].charAt(j) - 'a';
                tempArray[ind]++;
            }

            //update main array with min frequency
            for(int k = 0; k < 26; k++) {
                arr[k] = Math.min(tempArray[k], arr[k]);
            }
        }

        // Build the result list by adding each character as many times as its minimum frequency across all words
        List<String> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i]; j++) { // Add character (i + 'a') arr[i] times to the result
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.



 Example 1:

 Input: words = ["bella","label","roller"]
 Output: ["e","l","l"]
 Example 2:

 Input: words = ["cool","lock","cook"]
 Output: ["c","o"]


 Constraints:

 1 <= words.length <= 100
 1 <= words[i].length <= 100
 words[i] consists of lowercase English letters.
 */
