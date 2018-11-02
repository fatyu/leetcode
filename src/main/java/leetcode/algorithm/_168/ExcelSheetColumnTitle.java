package leetcode.algorithm._168;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 For example:
 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 ...
 Example 1:

 Input: 1
 Output: "A"
 Example 2:

 Input: 28
 Output: "AB"
 Example 3:

 Input: 701
 Output: "ZY"
 Excel中是使用的26进制，本题的解决思路是
 1.对数字减1，对26求余数和'A'相加，返回字符串，拼接在结果字符串的最前面，跳入第二步
 2.对26求除数，然后用结果求余数，走第一步。直至除数小于1
 */

public class ExcelSheetColumnTitle {
	public String convertToTitle(int num) {
		String result = "";
		while (num > 0) {
			result = String.valueOf((char) ('A' + --num % 26)) + result;
			num /= 26;
		}
		return result;
	}

	public static void main(String[] args) {
		ExcelSheetColumnTitle esct = new ExcelSheetColumnTitle();
		System.out.println(esct.convertToTitle(52));
	}

}
