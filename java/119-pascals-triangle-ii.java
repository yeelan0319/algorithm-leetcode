import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.function.BooleanSupplier;

/**
 * Created by yiranmao on 8/19/15.
 */
public class Driver {
	public static void main(String[] args) {
		test(1, 0, 0);
		test(2, 1, 1);
		test(3, 2, 2);
		test(4, 3, 5);
	}

	public static void test(int testNo, int rowIndex, int expectValue) {
		List<Integer> res = getRow(rowIndex);

		System.out.println(res.toString());
		System.out.println("");
//        if (Arrays.equals(res,expectValue)) {
//            System.out.println(testNo + ": Pass");
//        } else {
//            System.out.println(testNo + ": Fail");
//            System.out.println("Expect " + expectValue + ", Return " + res);
//        }
	}

	public static List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<Integer>();
		res.add(1);
		for(int i = 0; i < rowIndex; i++) {
			res.add(0, 1);
			for(int j = 1; j < res.size() - 1; j++) {
				res.set(j, res.get(j) + res.get(j + 1));
			}
		}
		return res;
	}
}