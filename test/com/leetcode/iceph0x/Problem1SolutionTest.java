package com.leetcode.iceph0x;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Problem1SolutionTest {

	private Problem1Solution solution;
	private TestCase[] testCases = new TestCase[] { 
			new TestCase(new int[] { 1, 7, 2, 14 }, 9, new int[] { 2, 3 }),
	        new TestCase(new int[] { 1, 7, 2, 14 }, 0, null),
	        new TestCase(new int[] { 1, 7, 2, 5, 14, 19 }, 24, new int[] { 4, 6 }), 
    };

	@Before
	public void setUp() throws Exception {
		solution = new Problem1Solution();
	}

	@Test
	public void testTwoSum() {
		for (TestCase testCase : testCases) {
			int[] result = solution.twoSum(testCase.nums, testCase.target);
			assertTrue(testCase.test(result));
		}
	}
	
	private static class TestCase {
		int[] nums;
		int target;
		int[] result;

		TestCase(int[] nums, int target, int[] result) {
			this.nums = nums;
			this.target = target;
			this.result = result;
		}

		boolean test(int[] result) {
			if (this.result == result)
				return true;

			if (result == null || result.length != 2)
				return false;

			return this.result[0] == result[0] && this.result[1] == result[1] || this.result[0] == result[1]
			        && this.result[1] == result[0];
		}
	}
}
