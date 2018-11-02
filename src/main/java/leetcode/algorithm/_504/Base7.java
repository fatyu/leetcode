package leetcode.algorithm._504;

/**
 *
 Given an integer, return its base 7 string representation.
 Example 1:
 Input: 100
 Output: "202"
 Example 2:
 Input: -7
 Output: "-10"
 Note: The input will be in range of [-1e7, 1e7].
 递归对7求余数和求除数
 */
public class Base7 {
	public String base7IntegerToString(int num) {
		String flag = num >= 0 ? "" : "-";//判断正负数
		int result = 0;
		num = Math.abs(num);
		int count = 0;
		result = calNum(result, num, count);
		return flag + result;
	}

	private int calNum(int result, int number, int count) {
		count = count + 1;
		int divide = number / 7;
		int cal = number % 7;
		result += (int) (Math.pow(10, count - 1) * cal);
		if (divide >= 7) {
			result += calNum(0, divide, count);
		} else {
			result += (int) (Math.pow(10, count) * divide);
		}
		return result;
	}


	public static void main(String[] args) {
		Base7 base = new Base7();
		System.out.println(base.base7IntegerToString(121));
	}
}
