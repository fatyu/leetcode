package leetcode.algorithm._400;

/**
 Leetcode NO.400:Nth Digit::1>>>>>>>>https://leetcode.com/problems/nth-digit
 eg:
 4000
 1-9 9*1
 10-99 90*2
 100-999 900*3
 1000-9999 9000*4
 ====================
 解题思路：
 1. 确认入参的位数
 2. 算出所在位数数字所占数字数量
 3. 数字除以位数 求出是几位数的第几个数字 如果余数是0 结果就是数字的最后一位
 4. 如果余数不为0 结果就是除法结果的数字+1，然后取这个数字的第余数位数字作为结果
 */
public class NTHDigit {
	public int findNthDigit(int n) {
		if (n <= 0 || n > Integer.MAX_VALUE) {
			throw new RuntimeException(
					"The input num is invalid,pls input the number between 1 and Integer.MAX_VALUE.");
		}
		//1.快速计算一个数字位数
		int digitLength = 1;
		int indexSum = 0, frontNumSum = 0;
		while (n > (indexSum += digitLength * 9 * Math.pow(10, (digitLength - 1)))) {
			frontNumSum += digitLength * 9 * Math.pow(10, (digitLength - 1));
			digitLength++;
		}
		//2.计算当前位数剩余的数字数量
		int leftCount = n - frontNumSum;//计算是所在位数的第几个数字
		int indexCount = (int) Math.ceil(((double) leftCount / digitLength));
		int left = (leftCount % digitLength) == 0 ? (digitLength - 1) : ((leftCount % digitLength) - 1);
		String resultNum = "" + (indexCount + (int) Math.pow(10, digitLength - 1) - 1);
		char charAt = resultNum.charAt(left);
		return Integer.valueOf(String.valueOf(charAt));
	}

	public static void main(String[] args) {
		NTHDigit digit = new NTHDigit();
		System.out.println(digit.findNthDigit(100));


	}


}