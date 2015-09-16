import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", new ArrayList<String>(Arrays.asList("AAAAACCCCC", "CCCCCAAAAA")));
        test(2, "AAAAAAAAAAAAAAAAAAAAAA", new ArrayList<String>(Arrays.asList("AAAAAAAAAA")));
        test(3, "ACACACACGTGTGTGT", new ArrayList<String>());
        test(4, "ACGT", new ArrayList<String>());
    }

    public static void test(int testNo, String s, List<String> expectValue) {
        List<String> res = findRepeatedDnaSequences(s);

//        for(char[] row : board) {
//            for(char c : row) {
//                System.out.print(c + " ");
//            }
//            System.out.println("");
//        }
//        System.out.println("");
        if (res.equals(expectValue)) {
            System.out.println(testNo + ": Pass");
        } else {
            System.out.println(testNo + ": Fail");
            System.out.println("Expect " + expectValue + ", Return " + res);
        }
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        int n = s.length();
        if(n < 10) return res;
        HashMap<Integer, Boolean> repeatDnaSequences = new HashMap<Integer, Boolean>();
        for(int i = 0; i < n - 9; i++) {
            String sequence = s.substring(i, i + 10);
            int hash = sequence.hashCode();
            if(!repeatDnaSequences.containsKey(hash)) {
                repeatDnaSequences.put(hash, false);
            }
            else if(!repeatDnaSequences.get(hash)){
                repeatDnaSequences.put(hash, true);
                res.add(sequence);
            }
        }
        return res;
    }
}