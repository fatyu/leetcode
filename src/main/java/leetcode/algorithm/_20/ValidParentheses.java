package leetcode.algorithm._20;

import java.util.Stack;

/**
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 An input string is valid if:
 Open brackets must be closed by the same type of brackets.
 Open brackets must be closed in the correct order.
 Note that an empty string is also considered valid.
 eg:
 {} true
 {[]} true
 ({)} false
 //关键点要想到Stack进行入栈出栈操作
 */
public class ValidParentheses {
    @Deprecated
    //逻辑思路存在边界问题，失败
    public boolean isValid(String s) {
        if (null == s || "".equals(s)) {
            return false;
        }
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        int max = length / 2;
        for (int i = 0; i < max; i++) {
            String front = s.substring(i, i + 1);
            String end = s.substring(length - 1 - i, length - i);
            if (!front.equals(end)) {
                return false;
            }
        }
        return false;
    }

    //使用Stack做字符匹配
    public boolean isValidParentheses(String s) {
        if (null == s || "".equals(s)) {
            return false;
        }
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {//当满足配对时，后入栈的应该会被优先pop
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                //当不是上述三个字符时，进行pop操作
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();//最终所有元素都会出栈
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValidParentheses("()()"));
    }
}
