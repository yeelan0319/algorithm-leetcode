import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new char[][]{{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}}, "ABCCED", true);
        test(2, new char[][]{{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}}, "SEE", true);
        test(3, new char[][]{{'A','B','C','E'}, {'S','F','C','S'},{'A','D','E','E'}}, "ABCB", false);
    }

    public static void test(int testNo, char[][] board, String word, boolean expectValue) {
        boolean res = exist(board, word);

//        for(int[] row : matrix) {
//            for(int i : row) {
//                System.out.print(i + " ");
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

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = m == 0? 0 : board[0].length;
        if(m == 0 || n == 0) {
            return false;
        }
        boolean[][] used = new boolean[m][n];
        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(existHelper(board, used, row, col, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean existHelper(char[][] board, boolean[][] used, int row, int col, String word, int begin) {
        if(begin == word.length()) return true;
        //注意超界情况需要either在这边判断或者在if时判断
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if(board[row][col] == word.charAt(begin) && !used[row][col]) {
            used[row][col] = true;
            if(existHelper(board, used, row + 1, col, word, begin + 1) ||
                    existHelper(board, used, row - 1, col, word, begin + 1) ||
                    existHelper(board, used, row, col + 1, word, begin + 1) ||
                    existHelper(board, used, row, col - 1, word, begin + 1)) {
                return true;
            }
            used[row][col] = false;
        }
        return false;
    }
}