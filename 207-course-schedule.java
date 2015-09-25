import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, 2, new int[][]{{1,0}}, true);
        test(2, 2, new int[][]{{1,0},{0,1}}, false);
    }

    public static void test(int testNo, int numCourses, int[][] prerequisites, boolean expectValue) {
        boolean res = canFinish(numCourses, prerequisites);

//        for(char[] row : board) {
//            for(char c : row) {
//                System.out.print(c + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
        if (res == expectValue) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses < 2) return true;
        Map<Integer, List<Integer>> relationship = new HashMap<Integer, List<Integer>>(numCourses);
        int[] color = new int[numCourses];
        for(int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int require = prerequisite[1];
            if(!relationship.containsKey(course)) {
                relationship.put(course, new LinkedList<Integer>());
            }
            relationship.get(course).add(require);
        }
        for(int i = 0; i < numCourses; i++) {
            if(color[i] == 0) {
                if(!dfs_visit(relationship, color, i)) return false;
            }
        }
        return true;
    }
    public static boolean dfs_visit(Map<Integer, List<Integer>> graph, int[] color, int u) {
        color[u] = 1;
        if(graph.containsKey(u)) {
            for (int v : graph.get(u)) {
                if (color[v] == 1) {
                    return false;
                } else if (color[v] == 0) {
                    if (!dfs_visit(graph, color, v)) return false;
                }
            }
        }
        color[u] = 2;
        return true;
    }
}