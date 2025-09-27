package com.meenu.learning.problems.easy;


/**
 * @author Meenu V. Nair
 * @created 27/09/25
 */

/*******  APPROACH ******************** 

 */

/**** COMPLEXITY ANALYSIS ******************** 
 Time Complexity : 
 Space Complexity : 
 */

public class LargestTriangleArea {
    static double helper(int arr1[], int arr2[], int arr3[]){
        double x1 = (double)arr1[0];
        double y1 = (double)arr1[1];

        double x2 = (double)arr2[0];
        double y2 = (double)arr2[1];

        double x3 = (double)arr3[0];
        double y3 = (double)arr3[1];

        return Math.abs((x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)))/2;
    }
    public double largestTriangleArea(int[][] arr) {


        double ans = 0;

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                for(int k=j+1; k<arr.length; k++){
                    ans = Math.max(ans,helper(arr[i],arr[j],arr[k]));
                }
            }
        }
        return ans;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.



 Example 1:


 Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 Output: 2.00000
 Explanation: The five points are shown in the above figure. The red triangle is the largest.
 Example 2:

 Input: points = [[1,0],[0,0],[0,1]]
 Output: 0.50000


 Constraints:

 3 <= points.length <= 50
 -50 <= xi, yi <= 50
 All the given points are unique.
 */
