package com.meenu.coding.problems.medium;


/**
 * @author Meenu V. Nair
 * @created 04/08/25
 */

import java.util.*;

/*******  APPROACH ********************
DFS
 */

/**
 Time complexity: O(V+E)
 Space complexity: O(V+E)
 */

public class CourseSchedule {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();
    private Set<Integer> visitSet = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++) {
            preMap.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {
            preMap.get(prereq[0]).add(prereq[1]);
        }

        for(int c = 0; c < numCourses; c++) {
            if(!dfs(c))
                return false;
        }
        return true;
    }

    public boolean dfs(int course) {
        if(visitSet.contains(course))
            return false;
        if(preMap.get(course).isEmpty())
            return true;

        visitSet.add(course);
        for(int pre : preMap.get(course)) {
            if(!dfs(pre))
                return false;
        }
        visitSet.remove(course);
        preMap.put(course, new ArrayList<>());
        return true;
    }
}

/*******  PROBLEM DESCRIPTION ******************** 
 There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

 For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 Return true if you can finish all courses. Otherwise, return false.



 Example 1:

 Input: numCourses = 2, prerequisites = [[1,0]]
 Output: true
 Explanation: There are a total of 2 courses to take.
 To take course 1 you should have finished course 0. So it is possible.
 Example 2:

 Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 Output: false
 Explanation: There are a total of 2 courses to take.
 To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


 Constraints:

 1 <= numCourses <= 2000
 0 <= prerequisites.length <= 5000
 prerequisites[i].length == 2
 0 <= ai, bi < numCourses
 All the pairs prerequisites[i] are unique.
 */
