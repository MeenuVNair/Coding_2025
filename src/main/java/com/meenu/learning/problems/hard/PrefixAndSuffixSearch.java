package com.meenu.learning.problems.hard;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.HashMap;
import java.util.Map;

/**** COMPLEXITY ANALYSIS ********************
 Time complexity: O (n ∗ m^3) time for initialization.
                  O(m) for each f() function call.
 Space complexity: O (n ∗ m^3)
        Where n is the number of words and m is the average length of each word.
 */

public class PrefixAndSuffixSearch {
    Map<String, Integer> map;
    public PrefixAndSuffixSearch(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            String currentWord = words[i];
            for(int j = 0; j < currentWord.length(); j++) {
                String prefix = currentWord.substring(0, j + 1);
                for(int k = 0; k < currentWord.length(); k++) {
                    String curr = prefix + "$" + currentWord.substring(k);
                    map.put(curr, i);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        String word = pref + "$" + suff;
        return map.getOrDefault(word, -1);
    }

    public static void main(String[] args) {
        String[] words = {"apple", "meenu"};
        PrefixAndSuffixSearch searchObject = new PrefixAndSuffixSearch(words);
        System.out.println(searchObject.f("ap", "e"));
        System.out.println(searchObject.f("a", "enu"));
        System.out.println(searchObject.f("me", "enu"));
    }
}

/*******  PROBLEM DESCRIPTION ********************

 Design a special dictionary that searches the words in it by a prefix and a suffix.

 Implement the WordFilter class:

 WordFilter(string[] words) Initializes the object with the words in the dictionary.
 f(string pref, string suff) Returns the index of the word in the dictionary, which has the prefix pref and the suffix suff. If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.


 Example 1:

 Input
 ["WordFilter", "f"]
 [[["apple"]], ["a", "e"]]
 Output
 [null, 0]
 Explanation
 WordFilter wordFilter = new WordFilter(["apple"]);
 wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix = "a" and suffix = "e".

 Constraints:

 1 <= words.length <= 104
 1 <= words[i].length <= 7
 1 <= pref.length, suff.length <= 7
 words[i], pref and suff consist of lowercase English letters only.
 At most 104 calls will be made to the function f.

 Hint 1
 Take "apple" as an example, we will insert add "apple{apple", "pple{apple", "ple{apple", "le{apple", "e{apple", "{apple" into the Trie Tree.
 Hint 2
 If the query is: prefix = "app", suffix = "le", we can find it by querying our trie for "le { app".
 Hint 3
 We use '{' because in ASCii Table, '{' is next to 'z', so we just need to create new TrieNode[27] instead of 26.
 Also, compared with traditional Trie, we add the attribute weight in class TrieNode. You can still choose any different character.

 */
