package com.leetcode.iceph0x;

/**
 * Longest Substring Without Repeating Characters
 * 
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 * @author iceph0x
 *
 */
public class Problem3Solution {

	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0)
			return 0;

		int head = 0;
		int max = 1;
		int[] cache = new int[256];
		java.util.Arrays.fill(cache, -1);
		cache[s.charAt(0) & 0xff] = 0;

		for (int i = 1; i < s.length(); ++i) {
			char c = s.charAt(i);
			int index = findChar(s, c, head, i, cache);
			if (index == -1) {
				int size = i - head + 1;
				if (max < size)
					max = size;
			}
			else {
				head = index + 1;
			}
		}

		return max;
	}

	private int findChar(String s, char target, int start, int end, int[] cache) {
		int index = cache[target & 0xff];
		cache[target & 0xff] = end;
		if (index < start) {
			return -1;
		}
		else {
			return index;
		}
	}
}