package com.meenu.learning.problems.hard;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ******************** 
 When we insert a word, at each node:
    countPrefix → incremented (means this prefix is part of another word).
    At the last character → countWord++.
 So after inserting multiple words, these counts tell us:
    How many words end here (countWord).
    How many words pass through this node (countPrefix).

 When we erase a word, we want to reverse what we did during insertion.
 1. Check if the word exists
        If word isn’t there, nothing to erase.
 2. Walk through each character
    Decrement the prefixCount, because one occurrence of this prefix is disappearing
 3. Remove unused branches, If no word uses this prefix anymore, we can safely delete the node (garbage cleanup).
 4. Decrement the ending word count, because one word that ended here has been removed.

 Example : Suppose we insert:

 insert("apple")
 insert("apple")
 insert("app")

 Now counters look like:
 a (prefix=3)
 p (prefix=3)
 p (prefix=3, word=1)   <- "app"
 l (prefix=2)
 e (prefix=2, word=2) <- "apple"

 Case 1: erase("apple")

 Traverse a → p → p → l → e
 Decrement prefix counts along the way
 At e, do countWord-- (2 → 1)
 Still prefix > 0, so branch stays

 Now structure is:

 a (3→2)
 p (3→2)
 p (3→2, word=1)
 l (2→1)
 e (2→1, word=1)

 Case 2: erase("apple") again

 Traverse again, decrement counts
 At e, do countWord-- (1 → 0)
 Now l → e still exist because "app" needs them

 Structure:

 a (2→1)
 p (2→1)
 p (2→1, word=1)
 l (1→0)
 e (1→0, word=0)

 Case 3: erase("app")

 Traverse a → p → p
 Decrement prefix counts
 At p, do countWord-- (1 → 0)

 Now "app" is gone, "apple" is gone → Trie is empty, nodes can be pruned.


 */

import java.util.HashMap;
import java.util.Map;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity:O(m) for insert, countWordsEqualTo, countWordsStartingWith, and erase, where m is the length of the input string.
 Space Complexity:O(m*k) where m is the number of inserted words and k is the average length of the words, due to storing the trie nodes.
 */

public class TrieImplementationAndAdvancedOperations {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int prefixCount = 0; // how many words share this prefix
        int wordCount = 0; // how many words end here
    }

    TrieNode root;

    public TrieImplementationAndAdvancedOperations() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c))
                curr.children.put(c, new TrieNode());
            curr = curr.children.get(c);
            curr.prefixCount++;
        }
        curr.wordCount++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode curr = root;
        int count = 0;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c))
                return 0;
            curr = curr.children.get(c);
        }
        return curr.wordCount;

    }

    public int countWordsStartingWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()) {
            if(!curr.children.containsKey(c))
                return 0;
            curr = curr.children.get(c);
        }
        return curr.prefixCount;
    }

    public void erase(String word) {

        if(countWordsEqualTo(word) == 0) return; // word not present, nothing to delete

        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            TrieNode next = curr.children.get(c);
            next.prefixCount--;
            if(next.prefixCount == 0) {
                curr.children.remove(c); // cleanup unused nodes
                return;
            }
            curr = next;
        }
        curr.wordCount--;
    }

    public static void main(String[] args) {
        TrieImplementationAndAdvancedOperations trie = new TrieImplementationAndAdvancedOperations();
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apex");

        System.out.println(trie.countWordsEqualTo("apple"));   // 2
        System.out.println(trie.countWordsStartingWith("app")); // 3 ("apple","apple","app")

        trie.erase("apple");
        System.out.println(trie.countWordsEqualTo("apple"));   // 1
        System.out.println(trie.countWordsStartingWith("app")); // 2 ("apple","app")

        trie.erase("apple");
        System.out.println(trie.countWordsEqualTo("apple"));   // 0

        System.out.println(trie.countWordsEqualTo("app"));   // 1
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Trie Implementation and Advanced Operations


 0

 100
 Hard


 Implement "TRIE” data structure from scratch with the following functions.

 Trie(): Initialize the object of this “TRIE” data structure.
 insert(“WORD”): Insert the string “WORD” into this “TRIE” data structure.
 countWordsEqualTo(“WORD”): Return how many times this “WORD” is present in this “TRIE”.
 countWordsStartingWith(“PREFIX”): Return how many words are there in this “TRIE” that have the string “PREFIX” as a prefix.
 erase(“WORD”): Delete one occurrence of the string “WORD” from the “TRIE”.

 Examples:
 Input : ["Trie", "insert", "countWordsEqualTo", "insert", "countWordsStartingWith", "erase", "countWordsStartingWith"]

 [ "apple", "apple", "app", "app", "apple", "app" ]



 Output : [null, null, 1, null, 2, null, 1]



 Explanation :

 Trie trie = new Trie()

 trie.insert("apple")

 trie.countWordsEqualTo("apple")  // return 1

 trie.insert("app")

 trie.countWordsStartingWith("app") // return 2

 trie.erase("apple")

 trie.countWordsStartingWith("app")   // return 1

 Input : ["Trie", "insert", "countWordsEqualTo", "insert", "erase", "countWordsStartingWith"]

 [ "mango", "apple", "app", "app", "mango" ]



 Output : [null, null, 0, null, null, 1]



 Explanation :

 Trie trie = new Trie()

 trie.insert("mango")

 trie.countWordsEqualTo("apple")  // return 0

 trie.insert("app")

 trie.erase("app")

 trie.countWordsStartingWith("mango") // return 1

 Input : ["Trie", "insert", "insert", "erase", "countWordsEqualTo", "insert", "countWordsStartingWith"]

 ["abcde","fghij","abcde", "bcde", "abcde", "fgh"]

 Output:
 [null, null, null, null, 0, null, 1]
 [null, null, null, null, 0, 0, null]
 [null, null, null, 0, null, null, 0]
 [null, null, null, 0, null, 0, null]

 Submit
 Constraints:
 1 <= word.length , prefix.length <= 2000
 word and prefix consist only of lowercase English letters.
 At most 3*104 calls in total will be made to insert, countWordsEqualTo , countWordsStartingWith and erase.

 Hint 1
 Insertion follows a character-by-character traversal, incrementing both prefix_count for all traversed nodes and word_count at the last character node. Searching for exact words involves checking word_count, while prefix-based searches rely on prefix_count.

 Hint 2
 To efficiently erase a word, the word count is decremented at the last character node, and prefix_count values are reduced along the path. If word_count reaches zero but the prefix is still used by other words, the structure remains intact. However, if no words depend on a node, it can be deleted to free memory.

 */
