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
 Time Complexity:Insert, search and startsWith have O(m) time complexity, where m is the key length.
 Space Complexity:O(N*L) where N is the number of words and L is the average length of the words
 */

public class ImplementTrie_Prefix_Tree {
    class TrieNode {
        private boolean word;
        private Map<Character, TrieNode> children = new HashMap<>();
    }
    TrieNode root;

    public ImplementTrie_Prefix_Tree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = this.root;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c))
                curr.children.put(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.word = true;
    }

    public boolean search(String word) {
        TrieNode curr = this.root;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c))
                return false;
            curr = curr.children.get(c);
        }
        return curr.word;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for(char c : prefix.toCharArray()) {
            if(!curr.children.containsKey(c))
                return false;
            curr = curr.children.get(c);
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementTrie_Prefix_Tree obj = new ImplementTrie_Prefix_Tree();
        obj.insert("apple");
        boolean isWordPresent = obj.search("apple");
        System.out.println("Is the word apple present ? " + isWordPresent);
        isWordPresent = obj.search("app");
        System.out.println("Is the word app present ? " + isWordPresent);
        boolean isPrefixPresent = obj.startsWith("app");
        System.out.println("Is there a word that starts with app ? " + isPrefixPresent);
        isPrefixPresent = obj.startsWith("node");
        System.out.println("Is there a word that starts with node ? " + isPrefixPresent);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

 Implement the Trie class:

 Trie() Initializes the trie object.
 void insert(String word) Inserts the string word into the trie.
 boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


 Example 1:

 Input
 ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 Output
 [null, null, true, false, true, null, true]

 Explanation
 Trie trie = new Trie();
 trie.insert("apple");
 trie.search("apple");   // return True
 trie.search("app");     // return False
 trie.startsWith("app"); // return True
 trie.insert("app");
 trie.search("app");     // return True


 Constraints:

 1 <= word.length, prefix.length <= 2000
 word and prefix consist only of lowercase English letters.
 At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 */
