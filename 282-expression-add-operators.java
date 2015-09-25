import com.sun.org.apache.xpath.internal.operations.Bool;

        import java.util.*;
        import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
    public static void main(String[] args) {
        test(1, "123", 6, 2);
        test(2, "232", 8, 2);
        test(3, "105", 5, 2);
        test(4, "00", 0, 3);
        test(5, "3456237490", 9191, 0);
        test(6, "000", 0, 9);
    }

    public static void test(int testNo, String num, int target, int expectValue) {
        List<String> res = addOperators(num, target);

        for(String s : res) {
            System.out.print(s + ",");
        }
        System.out.println("");
//        if (Arrays.equals(res, expectValue)) {
//            System.out.println(testNo + ": Pass");
//        } else {
//            System.out.println(testNo + ": Fail");
//            System.out.println("Expect " + expectValue + ", Return " + res);
//        }
    }

    public static List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if(num.length() < 2) return res;
        addOperatorsHelper(num, target, 0, 0, 0, "", res);
        return res;
    }
    public static void addOperatorsHelper(String num, int target, int start, long multi, long eval, String path, List<String> res) {
        if(num.length() == start) {
            if(target == eval) {
                res.add(path);
            }
            return;
        }
        for(int i = start; i < num.length(); i++) {
            if(i != start && num.charAt(start) == '0') return;
            long x = Long.parseLong(num.substring(start, i + 1));
            if(start == 0) {
                addOperatorsHelper(num, target, i + 1, x, eval + x, path + x, res);
            }
            else {
                addOperatorsHelper(num, target, i + 1, x, eval + x, path + "+" + x, res);
                addOperatorsHelper(num, target, i + 1, -x, eval - x, path + "-" + x, res);
                addOperatorsHelper(num, target, i + 1, multi * x, eval - multi + multi * x, path + "*" + x, res);
            }
        }
    }
}