package leetcode.algorithm._014;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 Write a function to find the longest common prefix string amongst an array of strings.

 If there is no common prefix, return an empty string "".

 Example 1:

 Input: ["flower","flow","flight"]
 Output: "fl"
 Example 2:

 Input: ["dog","racecar","car"]
 Output: ""
 Explanation: There is no common prefix among the input strings.
 Note:

 All given inputs are in lowercase letters a-z.

 解题思路：将数字字符串进行遍历生成多个

 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
//        int maxLength = 0;
////准备数据
//        List<char[]> chars = new ArrayList<>();
//        for (String str : strs) {
//            maxLength = maxLength > str.length() ? maxLength : str.length();
//            chars.add(str.toCharArray());
//        }
        //Stack<String> resultStack = new Stack<>();
        boolean continueFlag = true;
        int position = 0;
        while (continueFlag) {
            int curr = 0;
            for (int i = 0; i < strs.length; i++) {
                if(strs[i]==null||strs[i].length()<1){
                    return null;
                }
                if (curr == 0) {
                    curr = strs[i].charAt(position);
                } else if(curr!=0&&curr ==strs[i].charAt(position)){
                    curr = strs[i].charAt(position);
                }else{
                    continueFlag=false;
                }
            }
            if(continueFlag){
                result=result +""+(char)curr;
            }
            position++;
        }
        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.longestCommonPrefix(new String[]{"","",""}));
    }
}
