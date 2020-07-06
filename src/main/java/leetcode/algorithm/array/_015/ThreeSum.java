package leetcode.algorithm.array._015;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/3sum/
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * 解决思路：
 * 1.暴力循环，三层循环进行处理
 * 2. 遍历两次数组，并将数组的值存入一个map，直接map中查询a+b
 * 例如 [-1,-3,-5,8,2,1],额外存储一个map{k:-1,v:-1;k:-3,v:-3,...}
 * [-1,-3,-5,8,2,1]
 * [-1,-3,-5,8,2,1]
 * > -1+(-1)
 * > map中get(2)
 */
public class ThreeSum {

    //    public List<List<Integer>> threeSum(int[] nums) {
//        if (null == nums) {
//            return null;
//        }
//        if (nums.length <= 2) {
//            return null;
//        }
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                for (int k = 0; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        List<Integer> subSet = new ArrayList<>();
//                        subSet.add(nums[i]);
//                        subSet.add(nums[j]);
//                        subSet.add(nums[k]);
//                        result.add(subSet);
//                    }
//                }
//            }
//        }
//        return result;
//    }
    public List<List<Integer>> threeSum(int[] nums) {

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i : nums) {
            indexMap.put(nums[i], nums[i]);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (indexMap.containsKey((-(nums[i] + nums[j])))) {
                    List<Integer> subSet = new ArrayList<>();
                    subSet.add(nums[i]);
                    subSet.add(nums[j]);
                    subSet.add(-(nums[i] + nums[j]));
                    result.add(subSet);
                }
            }
        }
        return result;
    }
}
