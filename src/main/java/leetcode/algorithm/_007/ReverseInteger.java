package leetcode.algorithm._007;

/**
 Given a 32-bit signed integer, reverse digits of an integer.
 Example 1:
 Input: 123
 Output: 321

 Example 2:
 Input: -123
 Output: -321

 Example 3:
 Input: 120
 Output: 21
 Note:
 Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 解题思路：因为数字是10进制，通过求除和求余来进行移位和当前位置数字的确定
 因为有数字越界问题，使用长整型进行数字结果的存储，最终进行和Integer的最大值最小值比较。
 */
public class ReverseInteger {
    public int reverse(int num) {
        long result = 0;
        while (num != 0) {//当数字不为0
            result = result * 10 + num % 10;
            num /= 10;
        }
        return result>Integer.MAX_VALUE||result< Integer.MIN_VALUE?0:(int)result;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(23324));
        System.out.println(ri.reverse(2332040));
        System.out.println(ri.reverse(-943487));
    }
}
