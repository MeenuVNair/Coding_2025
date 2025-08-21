package com.meenu.learning.problems.hard;


/**
 * @author Meenu V. Nair
 * @created 19/08/25
 */

/*******  APPROACH ********************

 We’re given:
     A grid of characters (like a crossword puzzle).
     A word.
 We need to check:
     Can we trace this word in the grid by moving up,
     down, left, or right?
     We can’t reuse the same cell twice in one path.

 1. Start at every cell in the grid.
 2.If the cell’s letter matches the first letter of the word, try to “walk” through the grid:
    Move up, down, left, or right.
    Keep track of how many characters of the word we’ve matched so far.
 3. If we reach the end of the word → return true.
 4. If we run out of moves or the letters don’t match → backtrack and try a different path.
 5. If no path works → return false.

 This is just a DFS (Depth First Search) with backtracking, Trie is not needed here

 ==> Why a Trie is NOT needed here
    A Trie (prefix tree) is useful when:
        You need to search for many words at once (like in the "Word Search II" problem on LeetCode).
        Or when you need efficient prefix lookups.

 But here:
     We only need to find one word.
     Checking one word is straightforward → just compare characters in sequence.
     Using a Trie adds extra complexity:
        You build a Trie for just one word (wasted effort).
        You store extra data structures (Map<Character, Trie>) → more memory.
        Code becomes harder to follow.
     So the Trie gives no benefit, only overhead.

 */

/**** COMPLEXITY ANALYSIS ********************

 Time Complexity:O(M * N * 4^L), where M is the number of rows, N is the number of columns, and L is the length of the word.
 Space Complexity:O(M * N + L), where M is the number of rows, N is the number of columns of the board, and L is the maximum depth of the recursion, which is the length of the word.

 */

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(dfs(board, i, j, 0, word, visited))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int r, int c, int index, String word, boolean[][] visited) {
        int rows = board.length;
        int cols = board[0].length;

        if(index == word.length())
            return true;  // word fully matched

        if(r < 0 || c < 0 || r == rows || c == cols || visited[r][c] || word.charAt(index) != board[r][c])
            return false;

        visited[r][c] = true;

        boolean found = dfs(board, r + 1, c, index + 1, word, visited) ||
                        dfs(board, r - 1, c, index + 1, word, visited) ||
                        dfs(board, r, c + 1, index + 1, word, visited) ||
                        dfs(board, r, c - 1, index + 1, word, visited);

        visited[r][c] = false; //backtracking
        return found;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = { {'A', 'B', 'C', 'E'} , {'S' ,'F' ,'C' ,'S'} , {'A', 'D', 'E', 'E'} };
        String word = "ABCCED";
        System.out.println(wordSearch.exist(board, word));
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a grid of n x m dimension grid of characters board and a string word.The word can be created by assembling the letters of successively surrounding cells, whether they are next to each other vertically or horizontally. It is forbidden to use the same letter cell more than once.

 Return true if the word exists in the grid otherwise false.


 Examples:
 Input : board = [ ["A", "B", "C", "E"] , ["S" ,"F" ,"C" ,"S"] , ["A", "D", "E", "E"] ] , word = "ABCCED"

 Output : true

 Explanation : The word is coloured in yellow.





 Input : board = [["A", "B", "C", "E"] , ["S", "F", "C", "S"] , ["A", "D", "E", "E"]] , word = "SEE"

 Output : true

 Explanation : The word is coloured in yellow.





 Input : board = [["A", "B", "C", "E"] , ["S", "F", "C", "S"] , ["A", "D", "E", "E"]] , word = "ABCB"

 Output:
 true
 false

 Submit
 Constraints:
 n = board.length
 m = board[i].length
 1 <= n, m <=6
 1 <= word.length <= 15
 board and word consist of only lowercase and uppercase English letters.

 Hint 1
 Start at every cell in the grid and try to match the first character of word. If a match is found, recursively explore the neighboring cells to match the subsequent characters.
 Mark the current cell as visited (e.g., by modifying its value temporarily) to prevent revisiting it in the same path.

 Hint 2
 If the current index of the word equals its length, it means the word is successfully found. If the current cell does not match the expected character or goes out of bounds, backtrack immediately.
 */
