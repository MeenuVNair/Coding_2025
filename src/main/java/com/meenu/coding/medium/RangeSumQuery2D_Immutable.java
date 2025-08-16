package com.meenu.coding.medium;


/**
 * @author Meenu V. Nair
 * @created 16/08/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time complexity: O(1) for each query.
 Space complexity: O(m∗n), Where m is the number of rows and n is the number of columns in the matrix.
 */

public class RangeSumQuery2D_Immutable {
    int[][] sumMatrix;
    public RangeSumQuery2D_Immutable(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        sumMatrix = new int[m + 1][n + 1];
        for(int i = 0; i < m; i++) {
            int prefix = 0;
            for(int j = 0; j < n; j++) {
                prefix += matrix[i][j];
                int above = sumMatrix[i][j + 1];
                sumMatrix[i + 1][j + 1] = prefix + above;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++;
        int bottomRight = sumMatrix[row2][col2];
        int above = sumMatrix[row1 - 1][col2];
        int left = sumMatrix[row2][col1 - 1];
        int topLeft = sumMatrix[row1 - 1][col1 - 1];

        return bottomRight - above - left + topLeft;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 0, 1, 4, 2},
                                    {5, 6, 3, 2, 1},
                                    {1, 2, 0, 1, 5},
                                    {4, 1, 0, 1, 7},
                                    {1, 0, 3, 0, 5}};
        RangeSumQuery2D_Immutable obj = new RangeSumQuery2D_Immutable(matrix);
        int row1 = 1; //1; //2;
        int col1 = 2; //1; //1;
        int row2 = 2; //2; //4;
        int col2 = 4; //2; //3;

        int result = obj.sumRegion(row1, col1, row2, col2);
        System.out.println(result);
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given a 2D matrix matrix, handle multiple queries of the following type:

 Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 Implement the NumMatrix class:

 NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
 int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
 You must design an algorithm where sumRegion works on O(1) time complexity.

 Example 1:

 Input
 ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
 [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
 Output
 [null, 8, 11, 12]

 Explanation
 NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
 numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
 numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
 numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)


 Constraints:

 m == matrix.length
 n == matrix[i].length
 1 <= m, n <= 200
 -104 <= matrix[i][j] <= 104
 0 <= row1 <= row2 < m
 0 <= col1 <= col2 < n
 At most 104 calls will be made to sumRegion.
 */
