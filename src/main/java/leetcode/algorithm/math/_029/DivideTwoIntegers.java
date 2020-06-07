package leetcode.algorithm.math._029;

/**
 *
 Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 Return the quotient after dividing dividend by divisor.
 The integer division should truncate toward zero.
 不能使用乘法，除法，取模
 //解题思路：
 1.注意正负数
 2.注意越界问题
 3.注意0问题
 */
public class DivideTwoIntegers {
	public int divide(int dividend, int divisor) {
		//判断除数是不是为0
		if (divisor == 0) {
			throw new RuntimeException("the divisor number cant be zero!");
		}
		//首先确定正负数
		int sign = 1;
		if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
			sign = -1;
		}
		//将两个整数转为正整数，防止越界使用long
		long dividendLong = Math.abs((long) dividend);
		long divisorLong = Math.abs((long) divisor);

		//判断被除数是不是小于除数,或者被除数==0
		if (dividendLong < divisorLong || dividendLong == 0) {
			return 0;
		}

		long resultLong = divide(dividendLong, divisorLong);


		int result = 0;
		if (resultLong > Integer.MAX_VALUE) {
			result = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
		} else {
			result = (int) (sign * resultLong);
		}

		return result;
	}

	private long divide(long dividendLong, long divisorLong) {
		if (dividendLong < divisorLong) {
			return 0;
		}
		long countSum = divisorLong;
		long count = 1;
		while ((countSum + countSum) <= dividendLong) {
			countSum += countSum;
			count += count;//countsum 对应一次 count
		}
		return count + divide(dividendLong - countSum, divisorLong);
	}

	public static void main(String[] args) {
		DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
		System.out.println(divideTwoIntegers.divide(-1, 1));
	}

}
