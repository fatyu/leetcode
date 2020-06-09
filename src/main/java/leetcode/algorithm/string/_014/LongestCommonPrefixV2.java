package leetcode.algorithm.string._014;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 * <p>
 * All given inputs are in lowercase letters a-z.
 * --
 * 解题思路：
 * 1.假设公共前缀==第一个字符串，是最长公共前缀
 * 2.从第二个字符开始遍历，查找两个字符串的公共前缀，判断第二个字符串是否startwith("公共前缀")
 * 3.如果startwith==true，继续循环遍历第n个字符
 * 4.如果startwith==false，假设的公共前缀进行字符串截取，删除最后一个字符
 * 5.重复第二步
 */
public class LongestCommonPrefixV2 {
    public static void main(String[] args) {
        LongestCommonPrefixV2 lcp = new LongestCommonPrefixV2();
        System.out.println(lcp.longestCommonPrefix(new String[]{null, "ssssiii", "ssiii"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (null == strs) {
            return null;
        }
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        if (null == prefix) {
            return null;
        }
        for (int i = 1; i < strs.length; i++) {
            if (strs[i] == null) {
                return null;
            }
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix == "") {
                    return "";
                }
            }

        }
        return prefix;
    }
}
