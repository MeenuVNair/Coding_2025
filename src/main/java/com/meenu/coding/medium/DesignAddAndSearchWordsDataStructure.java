package com.meenu.coding.medium;


/**
 * @author Meenu V. Nair
 * @created 18/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.HashMap;
import java.util.Map;

/**** COMPLEXITY ANALYSIS ********************
 Time complexity: O(n) for addWord(), O(n) for search().
 Space complexity: O(t+n)
    Where n is the length of the string and t is the total number of TrieNodes created in the Trie.
 */

public class DesignAddAndSearchWordsDataStructure {
    class Trie {
        private boolean word = false;
        private Map<Character, Trie> children = new HashMap<>();
    }

    Trie root;

    public DesignAddAndSearchWordsDataStructure() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie curr = this.root;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c))
                curr.children.put(c, new Trie());
            curr = curr.children.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Trie root) {
        Trie curr = root;
        for(int i = index; i < word.length(); i++) {
            char c = word.charAt(i);
            if(c == '.') {
                for(Map.Entry<Character, Trie> entry : curr.children.entrySet()) {
                    if(entry.getValue() != null && dfs(word, i + 1, entry.getValue()))
                        return true;
                }
                return false;
            } else {
                if(!curr.children.containsKey(c))
                    return false;
                curr = curr.children.get(c);
            }
        }
        return curr.word;
    }

    public static void main(String[] args) {
        DesignAddAndSearchWordsDataStructure obj = new DesignAddAndSearchWordsDataStructure();
        obj.addWord("bad");
        obj.addWord("mad");
        obj.addWord("dad");
        boolean contains = obj.search("pad");
        System.out.println("Contains word pad ? " + contains);
        contains = obj.search("bad");
        System.out.println("Contains word bad ? " + contains);
        contains = obj.search(".ad");
        System.out.println("Contains word .ad ? " + contains);
        contains = obj.search("b..");
        System.out.println("Contains word b.. ? " + contains);


        //["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        //[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Design a data structure that supports adding new words and finding if a string matches any previously added string.

 Implement the WordDictionary class:

 WordDictionary() Initializes the object.
 void addWord(word) Adds word to the data structure, it can be matched later.
 bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.


 Example:

 Input
 ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 Output
 [null,null,null,null,false,true,true,true]

 Explanation
 WordDictionary wordDictionary = new WordDictionary();
 wordDictionary.addWord("bad");
 wordDictionary.addWord("dad");
 wordDictionary.addWord("mad");
 wordDictionary.search("pad"); // return False
 wordDictionary.search("bad"); // return True
 wordDictionary.search(".ad"); // return True
 wordDictionary.search("b.."); // return True


 Constraints:

 1 <= word.length <= 25
 word in addWord consists of lowercase English letters.
 word in search consist of '.' or lowercase English letters.
 There will be at most 2 dots in word for search queries.
 At most 104 calls will be made to addWord and search.
 */
