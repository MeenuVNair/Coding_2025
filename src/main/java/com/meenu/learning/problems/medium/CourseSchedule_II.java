package com.meenu.learning.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 28/08/25
 */

/*******  APPROACH ******************** 
 Topological Sort
 */

import java.util.*;

/**** COMPLEXITY ANALYSIS ********************
 Time Complexity : O(E + V)
 Space Complexity : O(E + V)
 */

public class CourseSchedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
        for(int[] preReq : prerequisites) {
            adjacencyList.get(preReq[0]).add(preReq[1]);
            /*
            if writing as adjacencyList.get(preReq[0]).add(preReq[1]); --> then no need to reverse the output in the end
            If writing as adjacencyList.get(preReq[1]).add(preReq[0]);
            (which is basically what the problem statement says, ie., prerequisites[i] = [a, b] indicates that you must take course b first if you want to take course a
            For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.)
            ==> then the result should be reversed in the end;
             */
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> currentPath = new HashSet<>();
        List<Integer> courses = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, adjacencyList, visited, currentPath, courses))
                return new int[0];
        }
        return courses.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> adjacencyList, Set<Integer> visited, Set<Integer> currentPath, List<Integer> courses) {
        if(currentPath.contains(course))
            return false;
        if(visited.contains(course))
            return true;
        currentPath.add(course);
        for(Integer preReq : adjacencyList.get(course)) {
            if(!dfs(preReq, adjacencyList, visited, currentPath, courses))
                return false;
        }
        currentPath.remove(course);
        visited.add(course);
        courses.add(course);
        return true;
    }

    public static void main(String[] args) {
        CourseSchedule_II obj = new CourseSchedule_II();
        int numCourses = 2; //3;
        //int[][] prerequisites = new int[][] {{1, 0}}; // [0, 1, 2]
        //int[][] prerequisites = new int[][] {{0,1},{1,2},{2,0}}; // []
        int[][] prerequisites = new int[][] {{0, 1}}; // [1, 0]
        int[] order = obj.findOrder(numCourses, prerequisites);
        for(int i : order)
            System.out.print(i + ", ");
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

 For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.



 Example 1:

 Input: numCourses = 2, prerequisites = [[1,0]]
 Output: [0,1]
 Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 Example 2:

 Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 Output: [0,2,1,3]
 Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 Example 3:

 Input: numCourses = 1, prerequisites = []
 Output: [0]


 Constraints:

 1 <= numCourses <= 2000
 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 prerequisites[i].length == 2
 0 <= ai, bi < numCourses
 ai != bi
 All the pairs [ai, bi] are distinct.
 */
