package leetcode.algorithm.array._027;

import org.apache.commons.lang3.ArrayUtils;

public class RemoveElement {
	public int removeElement(int[] nums, int removeVal) {
		if (null == nums || nums.length < 1) {
			return 0;
		}
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != removeVal) {
				nums[result] = nums[i];
				result += 1;
			}
		}

		System.out.println(ArrayUtils.toString(nums));
		return result;
	}

	public static void main(String[] args) {
		RemoveElement re = new RemoveElement();
		re.removeElement(new int[]{2,3,2,2,3,2,1,3,4,1},3);
	}
}
