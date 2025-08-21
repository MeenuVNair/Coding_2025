package com.meenu.coding.problems.medium;

/**
 * @author Meenu V. Nair
 * @created 31/07/25
 */

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < rows; i++) {
            int l = 0, r = cols - 1, mid;

            while(l <= r) {
                mid = l + (r - l) / 2;

                if(matrix[i][mid] < target) {
                    l = mid + 1;
                } else if(matrix[i][mid] > target) {
                    r = mid - 1;
                } else {
                    return true;
                }
            }
        }
        return false;

    /*

    BRUTE FORCE

        for(int i = 0; i < rows ; i++) {
            for(int j = 0; j < cols; j++) {
                if(matrix[i][j] == target)
                    return true;
            }
        }
        return false;
        */
    }
}


/**
 You are given an m x n integer matrix matrix with the following two properties:

 Each row is sorted in non-decreasing order.
 The first integer of each row is greater than the last integer of the previous row.
 Given an integer target, return true if target is in matrix or false otherwise.

 You must write a solution in O(log(m * n)) time complexity.



 Example 1:


 Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 Output: true
 Example 2:


 Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 Output: false


 Constraints:

 m == matrix.length
 n == matrix[i].length
 1 <= m, n <= 100
 -104 <= matrix[i][j], target <= 104
 */
