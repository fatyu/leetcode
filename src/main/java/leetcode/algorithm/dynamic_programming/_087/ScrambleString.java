package leetcode.algorithm.dynamic_programming._087;

/**
 Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

 Below is one possible representation of s1 = "great":

 great
 /    \
 gr    eat
 / \    /  \
 g   r  e   at
 / \
 a   t
 To scramble the string, we may choose any non-leaf node and swap its two children.

 For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

 rgeat
 /    \
 rg    eat
 / \    /  \
 r   g  e   at
 / \
 a   t
 We say that "rgeat" is a scrambled string of "great".

 Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

 rgtae
 /    \
 rg    tae
 / \    /  \
 r   g  ta  e
 / \
 t   a
 We say that "rgtae" is a scrambled string of "great".

 Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */

/**
 * 两种解题思路：
 * 1.递归处理
 * TODO 2.动态规划 看了几篇文章，云里雾里，三维数组？？？
 */

public class ScrambleString {

	public boolean isScramble(String s1, String s2) {
		if (null == s1 || null == s2) {
			return false;
		}
		if (s1.equals(s2)) {
			return true;
		}
		if (s1.length() != s2.length()) {
			return false;
		}

		//判断两个字符串的字母类型和数量是否相同

		int[] chars = new int[26];

		int stringLength = s1.length();
		for (int i = 0; i < stringLength; i++) {
			chars[s1.charAt(i) - 'a']++;
			chars[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++) {
			if (chars[i] != 0) {
				return false;
			}
		}
		//递归判断两个字符串的子字符串是否是ScrambleString
		for (int i = 1; i < stringLength; i++) {
			//同顺序判断
			if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
				return true;
			}
			//反顺序判断
			if (isScramble(s1.substring(0, i), s2.substring(stringLength - i)) && isScramble(s1.substring(i),
					s2.substring(0, stringLength - i))) {
				return true;
			}
		}

		return false;
	}


	public static void main(String[] args) {
		ScrambleString ss = new ScrambleString();
		System.out.println(ss.isScramble("great", "retga"));
	}
}
