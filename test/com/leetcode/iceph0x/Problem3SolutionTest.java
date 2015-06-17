package com.leetcode.iceph0x;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Problem3SolutionTest {
	
	private Problem3Solution solution;
	private String[] strings = new String[] {
			"eee",
			"abcba",
			"xzeedabcdebcdecdedee",
			"abcdefghijklmnopqrstuvwxyz~!@#abcdefghijklmnopqrstuvwxyz~!@#abcdefghijklmnopqrstuvwxyz~!@#abcdefghijklmnopqrstuvwxyz~!@#",
	};
	private int[] results = new int[] {
			1,
			3,
			5,
			30,
	};
	

	@Before
	public void setUp() throws Exception {
		solution = new Problem3Solution();
	}

	@Test
	public void testLengthOfLongestSubstring() {
		for (int i = 0; i < strings.length; ++i) {
			assertEquals(solution.lengthOfLongestSubstring(strings[i]), results[i]);
		}
	}
}
