package leetcode.algorithm._001;

import java.util.HashMap;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSum {

	private int[] ints;
	private int sum;

	public TwoSum() {
	}


	public TwoSum(int[] ints, int sum) {
		this.ints = ints;
		this.sum = sum;
	}

	public int[] getInts() {
		return ints;
	}

	public void setInts(int[] ints) {
		this.ints = ints;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int[] findIndexs() {

		int[] result = new int[2];
		//		Arrays.sort(result);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < ints.length; i++) {
			map.put(i + 1, ints[i]);
		}
		for (int i = 0; i < ints.length; i++) {
			int first = ints[i];
			int second = sum - first;
			for (int j = 0; j < ints.length; j++) {
				if (i != j) {
					int indexNum = map.get(j + 1);
					if (indexNum == second) {
						result[0] = i + 1;
						result[1] = j + 1;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] ints = {2, 1, 9, 4, 4, 56, 90, 3};
		ts.setInts(ints);
		ts.setSum(8);
		int[] findIndexs = ts.findIndexs();
		if (0 == findIndexs[0] || 0 == findIndexs[1]) {
			System.out.println("没有对应的数据!");
			return;
		}
		System.out.println(
				"sum [" + ts.getSum() + "]-->" + "n1:" + findIndexs[0] + "[" + ints[findIndexs[0] - 1] + "],n2:"
						+ findIndexs[1] + "[" + ints[findIndexs[1] - 1] + "]");
	}

}
