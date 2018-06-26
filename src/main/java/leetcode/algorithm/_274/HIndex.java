package leetcode.algorithm._274;

import java.util.Arrays;

/**
 * @author fatyu
 *
 * https://leetcode.com/problems/h-index/?tab=Description
 *
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 * For example, given citations = [3, 0, 6, 1, 5], which means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, his h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 */
public class HIndex {

    public int hIndex(int[] citations) {
        //首先进行数组数据排序 低->高
        Arrays.sort(citations);
        int length = citations.length;
        //遍历数组 坐标值小于等于已经遍历过的数量即可
        for (int i = 0; i < length; i++) {
            int currentCount = length - i;
            if (citations[i] >= currentCount) {
                return currentCount;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        int[] citations = new int[]{3, 0, 6, 1, 5};
        int hindex = hIndex.hIndex(citations);
        System.out.println("the h-index is :" + hindex);
    }
}
