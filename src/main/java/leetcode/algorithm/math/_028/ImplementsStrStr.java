package leetcode.algorithm.math._028;

/**
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 */
public class ImplementsStrStr {

    @Deprecated
    public int strStrFailed(String haystack, String needle) {
        if(haystack==null){
            return -1;
        }
        if (null == needle || "".equals(needle)) {
            return 0;
        }
        if(haystack.length()<needle.length()){
            return -1;
        }
        int result = -1;
        String compartor = needle;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == compartor.charAt(0)) {
                if (haystack.charAt(i) == needle.charAt(0) && (needle.length()-compartor.length())==0) {
                    result = i;
                }
                compartor = compartor.substring(1, compartor.length());
                if (compartor.equals("")) {
                    return result;
                }

            } else if(haystack.charAt(i) ==  needle.charAt(0)) {
                result = i;
                compartor = needle;
                compartor = compartor.substring(1, compartor.length());

            }else{
                compartor = needle;
                result = -1;
            }
        }
        return result;
    }


    public int strStr(String haystack, String needle) {
        if(haystack==null){
            return -1;
        }
        if (null == needle || "".equals(needle)) {
            return 0;
        }
        if(haystack.length()<needle.length()){
            return -1;
        }


        //使用java String 的substring方法
        for(int i = 0;i<=(haystack.length()-needle.length());i++){
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }

        return -1;
    }

    public static void main(String [] args){
        ImplementsStrStr i = new ImplementsStrStr();
        System.out.println(i.strStr("mississippi","issip"));
    }
}