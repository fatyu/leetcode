package leetcode.algorithm._027;

public class RemoveElement {
	public int removeElement(int[] nums, int removeVal) {
		if (null == nums || nums.length < 1) {
			return 0;
		}
		int result = 1;
		for (int i = 0; i < nums.length; i++) {
			if ((i + 1 < nums.length) && nums[i] != removeVal) {
				nums[result] = nums[i + 1];
				result += 1;
			}
		}
		return result;
	}
}
