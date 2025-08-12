package com.meenu.coding.medium;


/**
 * @author Meenu V. Nair
 * @created 12/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity:O(m*n) due to iterating through the matrix twice
 Space Complexity:O(m+n) due to the boolean arrays row and col
 */

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0. You must do it in place.


 Examples:
 Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]

 Output: [[1,0,1],[0,0,0],[1,0,1]]

 Explanation:

 Element at position (1,1) is 0, so set entire row 1 and column 1 to 0.

 Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]

 Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

 Explanation:

 There are two zeroes: (0,0) and (0,3).

 Row 0 → all elements become 0
 Column 0 and column 3 → all elements become 0
 Input: matrix = [[1,2,3,4],[5,6,0,8],[9,10,11,12]]

 Output:
 [[1,2,0,4],[0,0,0,0],[9,10,0,12]]
 [[1,2,3,4],[0,0,0,0],[9,10,0,12]]
 [[1,2,0,0],[0,0,0,0],[9,10,0,12]]
 [[1,2,3,0],[0,0,0,0],[9,10,0,12]]

 Submit
 Constraints:
 m == matrix.length
 n == matrix[0].length
 1 <= m, n <= 200
 -231 <= matrix[i][j] <= 231 - 1

 Hint 1
 Think about what it means to do the operation "in place." You are not allowed to use a separate matrix to track changes, so you need to somehow mark rows and columns using the existing matrix.

 Hint 2
 If you set a row or column to zero as soon as you find a zero, you may affect other cells that you haven't checked yet. Consider delaying the zeroing until after you’ve identified all the rows and columns that need to be changed.

 Hint 3
 Use the first row and first column of the matrix as markers to remember which rows and columns should be zeroed. Be cautious with the (0,0) cell, as it’s shared between both the first row and first column—you might need an additional variable to track the state of the first column separately.
 */
