import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }, true);
        test(2, new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'5', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }, false);
    }

    public static void test(int testNo, char[][] board, boolean expectValue) {
        boolean res = isValidSudoku(board);

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

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> row = new HashSet<Character>();
        HashSet<Character> col = new HashSet<Character>();
        HashSet<Character> grid = new HashSet<Character>();
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if((board[i][j] != '.' && row.contains(board[i][j])) ||
                        (board[j][i] != '.' && col.contains(board[j][i]))||
                        (board[(i / 3) * 3 + j / 3][(i % 3) * 3+ j % 3] != '.' && grid.contains(board[(i / 3) * 3 + j / 3][(i % 3) * 3+ j % 3]))) {
                    return false;
                }
                row.add(board[i][j]);
                col.add(board[j][i]);
                grid.add(board[(i / 3) * 3 + j / 3][(i % 3) * 3+ j % 3]);
            }
            row.clear();
            col.clear();
            grid.clear();
        }
        return true;
    }
}