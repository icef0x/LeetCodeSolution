package com.leetcode.iceph0x;

import java.util.HashMap;

/**
 * Two Sum.
 * 
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number. The function twoSum should return indices of the two
 * numbers such that they add up to the target, where index1 must be less than
 * index2. Please note that your returned answers (both index1 and index2) are
 * not zero-based. You may assume that each input would have exactly one
 * solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 
 * Output: index1=1, index2=2
 * 
 * @author iceph0x
 */
public class Problem1Solution {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(nums.length);
		for (int i = 0; i < nums.length; ++i) {
			Integer index = hm.get(nums[i]);
			if (index != null) {
				return new int[] { index + 1, i + 1 };
			}
			else {
				hm.put(target - nums[i], i);
			}
		}

		return null;
	}
}
