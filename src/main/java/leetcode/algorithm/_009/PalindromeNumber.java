package leetcode.algorithm._009;

/**
 Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

 Example 1:

 Input: 121
 Output: true
 Example 2:

 Input: -121
 Output: false
 Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 Example 3:

 Input: 10
 Output: false
 Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 Follow up:

 Coud you solve it without converting the integer to a string?

 回文数字判断
 //解决思路 数字转字符串 然后拆分对称比较是否是相同字符。 但是问题要求不能将数字转为字符串。
 //另一种思路：另外一种思路 取高低位，判断两者是否相同如果相同去除高低位，然后继续判断高低位，直至数字为0
 */
public class PalindromeNumber {


    public boolean isPalindrome(int n) {
        if (n < 0) {
            return false;
        }
        if (n < 10) {
            return true;
        }

        int dividNum = 1;
        while (n / dividNum > 10) {
            dividNum *= 10;
        }

        while (n > 0) {
            int h = n / dividNum;//高位数字
            int l = n % 10;
            if (h == l) {
                n = (n%dividNum)/10;
                dividNum /= 100;//删除两位
            } else {
                return false;
            }
        }
        return false;
    }
}
