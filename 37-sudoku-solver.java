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
        }, 2);
    }

    public static void test(int testNo, char[][] board, int expectValue) {
        solveSudoku(board);

        for(char[] row : board) {
            for(char c : row) {
                System.out.print(c + " ");
            }
            System.out.println("");
        }
        System.out.println("");
//        if (res == expectValue) {
//            System.out.println(testNo + ": Pass");
//        } else {
//            System.out.println(testNo + ": Fail");
//            System.out.println("Expect " + expectValue + ", Return " + res);
//        }
    }

    public static void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
    public static boolean solveSudokuHelper(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    List<Character> candidates = findCandidate(board, i, j);
                    for(char c : candidates) {
                        board[i][j] = c;
                        if(solveSudokuHelper(board)) return true;
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }
    public static List<Character> findCandidate(char[][] board, int row, int col) {
        HashSet<Character> rowHs = new HashSet<Character>();
        HashSet<Character> colHs = new HashSet<Character>();
        HashSet<Character> gridHs = new HashSet<Character>();
        List<Character> res = new ArrayList<Character>();
        for(int i = 0; i < 9; i++) {
            if(board[row][i] != '.') rowHs.add(board[row][i]);
            if(board[i][col] != '.') colHs.add(board[i][col]);
        }
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[startRow + i][startCol + j] != '.') gridHs.add(board[startRow + i][startCol + j]);
            }
        }
        for(int i = 1; i < 10; i++) {
            char c = (char) ('0' + i);
            if(!rowHs.contains(c) && !colHs.contains(c) && !gridHs.contains(c)) res.add(c);
        }
        return res;
    }
}