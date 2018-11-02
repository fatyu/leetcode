package leetcode.algorithm._275;

import java.util.Arrays;

/**
 * @author fatyu
 *
 * https://leetcode.com/problems/h-index-ii/?tab=Description
 *
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 *
 */
public class HIndexII {
	public int hIndex(int[] citations) {
		//因为数据已经进行过升序排列,使用二分查找进行处理数据即可.
		int length = citations.length;
		int low = 0;
		int high = length - 1;
		while (low <= high) {
			int index = low + ((high - low) >> 1);
			if (citations[index] == length - index) {
				return length - index;
			}
			if (citations[index] > length - index) {
				high = index - 1;
			}
			if (citations[index] < length - index) {
				low = index + 1;
			}
		}
		return length - low;
	}

	public static void main(String[] args) {
		int[] citations = new int[]{0, 0};
		Arrays.sort(citations);
		HIndexII hIndex = new HIndexII();
		int hindex = hIndex.hIndex(citations);
		System.out.println("the h-index is :" + hindex);
	}

}
