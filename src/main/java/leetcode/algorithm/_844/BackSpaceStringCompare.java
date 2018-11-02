package leetcode.algorithm._844;

import java.util.Stack;

/**
 Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

 Example 1:

 Input: S = "ab#c", T = "ad#c"
 Output: true
 Explanation: Both S and T become "ac".

 Example 2:

 Input: S = "ab##", T = "c#d#"
 Output: true
 Explanation: Both S and T become "".

 Example 3:

 Input: S = "a##c", T = "#a#c"
 Output: true
 Explanation: Both S and T become "c".

 Example 4:

 Input: S = "a#c", T = "b"
 Output: false
 Explanation: S becomes "c" while T becomes "b".

 Note:

 1. 1 <= S.length <= 200
 2. 1 <= T.length <= 200
 3. S and T only contain lowercase letters and '#' characters.

 Follow up:

 - Can you solve it in O(N) time and O(1) space?
 解题思路：用栈进行字符串入栈操作。最后出栈对比，如果存在不同直接返回false
 */
public class BackSpaceStringCompare {
	public boolean backspaceCompare(String s, String t) {
		if (s != null && (s.length() > 0) && t != null && (t.length() > 0)) {
			Stack<String> sStack = new Stack<>();
			Stack<String> tStack = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '#') {
					if (!sStack.isEmpty()) {
						sStack.pop();
					}
				} else {
					sStack.push(String.valueOf(c));
				}
			}
			for (int i = 0; i < t.length(); i++) {
				char c = t.charAt(i);
				if (c == '#') {
					if (!tStack.isEmpty()) {
						tStack.pop();
					}
				} else {
					tStack.push(String.valueOf(c));
				}
			}

			if (sStack.size() != tStack.size()) {
				return false;
			}
			for (int i = 0; i < sStack.size(); i++) {
				String sPop = sStack.pop();
				String tPop = tStack.pop();
				if (!sPop.equals(tPop)) {
					return false;
				}
			}
			return true;

		}
		return false;
	}

	public static void main(String[] args) {
		BackSpaceStringCompare c = new BackSpaceStringCompare();
		System.out.println(c.backspaceCompare("d##ed", "d###ee#d"));
	}
}
