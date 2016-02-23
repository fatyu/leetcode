package leetcode._001;

import java.util.Arrays;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSumv2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 3, 2, 4 }, 6)));
	}

	private static int[] solution(int[] numbers, int target) {
		int[] targetArray = new int[2];
		int startIndex = 0;
		int endIndex = numbers.length - 1;
		IndexNum[] ins = new IndexNum[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			IndexNum in = new IndexNum();
			in.setIndex(i + 1);
			in.setNum(numbers[i]);
			ins[i] = in;
		}
		Arrays.sort(ins);

		while (startIndex < endIndex) {
			if (ins[startIndex].getNum() + ins[endIndex].getNum() < target) {
				startIndex++;
			}
			if (ins[startIndex].getNum() + ins[endIndex].getNum() > target) {
				endIndex--;
			}
			if (ins[startIndex].getNum() + ins[endIndex].getNum() == target) {
				int i1 = ins[startIndex].getIndex();
				int i2 = ins[endIndex].getIndex();
				if (i1 < i2) {
					targetArray[0] = i1;
					targetArray[1] = i2;
				} else {
					targetArray[0] = i2;
					targetArray[1] = i1;
				}
				break;
			}
		}
		return targetArray;
	}

}

class IndexNum implements Comparable<IndexNum> {

	int index;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	int num;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int compareTo(IndexNum o) {
		return this.getNum() - o.getNum();
	}
}
