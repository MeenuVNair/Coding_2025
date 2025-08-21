package com.meenu.coding.problems.hard;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ******************** 

 */

import java.util.*;

/**** COMPLEXITY ANALYSIS ********************
 Time complexity: O(m ∗n ∗ 4 ∗ 3^t−1 + s)
 Space complexity: O(s)

 Where m is the number of rows, n is the number of columns,
 t is the maximum length of any word in the array words and s is the sum of the lengths of all the words.
 */

public class WordSearch_II {
    class Trie {
        boolean word = false;
        Map<Character, Trie> children = new HashMap<>();

        public void addWord(String word) {
            Trie curr = this;
            for(char c : word.toCharArray()) {
                if(!curr.children.containsKey(c))
                    curr.children.put(c, new Trie());
                curr = curr.children.get(c);
            }
            curr.word = true;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for(String word : words) {
            root.addWord(word);
        }

        int rows = board.length;
        int cols = board[0].length;

        Set<String> result = new HashSet<>();
        boolean[][] visit = new boolean[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                dfs(board, i, j, root, "", result, visit);
            }
        }

        return new ArrayList<>(result);
    }

    public void dfs(char[][] board, int r, int c, Trie node, String word, Set<String> result, boolean[][] visit) {
        int rows = board.length;
        int cols = board[0].length;

        if(r < 0 || c < 0 || r == rows || c == cols || visit[r][c] || !node.children.containsKey(board[r][c]))
            return;

        visit[r][c] = true;
        node = node.children.get(board[r][c]);
        word += board[r][c];
        if(node.word)
            result.add(word);

        dfs(board, r + 1, c, node, word, result, visit);
        dfs(board, r - 1, c, node, word, result, visit);
        dfs(board, r, c + 1, node, word, result, visit);
        dfs(board, r, c - 1, node, word, result, visit);

        visit[r][c] = false;
    }

    public static void main(String[] args) {
        WordSearch_II obj = new WordSearch_II();
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};

        /*char[][] board = {{'a','b'},{'c','d'}};
        String[] words = {"abcb"};*/

        List<String> result = obj.findWords(board, words);
        for(String word : result)
            System.out.print(word + " ");
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an m x n board of characters and a list of strings words, return all words on the board.

 Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 Example 1:

 Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 Output: ["eat","oath"]
 Example 2:

 Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 Output: []

 Constraints:

 m == board.length
 n == board[i].length
 1 <= m, n <= 12
 board[i][j] is a lowercase English letter.
 1 <= words.length <= 3 * 104
 1 <= words[i].length <= 10
 words[i] consists of lowercase English letters.
 All the strings of words are unique.
 */
