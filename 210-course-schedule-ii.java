import com.sun.org.apache.xpath.internal.operations.Bool;

        import java.util.*;
        import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, 2, new int[][]{{1,0}}, new int[]{0,1});
        test(2, 2, new int[][]{{1,0},{0,1}}, new int[]{});
        test(3, 4, new int[][]{{1,0},{2,0},{3,1},{3,2}}, new int[]{0,1,2,3});
    }

    public static void test(int testNo, int numCourses, int[][] prerequisites, int[] expectValue) {
        int[] res = findOrder(numCourses, prerequisites);

//        for(int i : res) {
//            System.out.print(i + " ");
//        }
//        System.out.println("");
        if (Arrays.equals(res, expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> relationship = new HashMap<Integer, List<Integer>>(numCourses);
        int[] color = new int[numCourses];
        List<Integer> res = new ArrayList<Integer>();
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
                if(!dfs_visit(relationship, color, i, res)) return new int[]{};
            }
        }
        int[] resarray = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            resarray[i] = res.get(i);
        }
        return resarray;
    }
    public static boolean dfs_visit(Map<Integer, List<Integer>> graph, int[] color, int u, List<Integer> res) {
        color[u] = 1;
        if(graph.containsKey(u)) {
            for (int v : graph.get(u)) {
                if (color[v] == 1) {
                    return false;
                }
                else if (color[v] == 0) {
                    if (!dfs_visit(graph, color, v, res)) return false;
                }
            }
        }
        res.add(u);
        color[u] = 2;
        return true;
    }
}