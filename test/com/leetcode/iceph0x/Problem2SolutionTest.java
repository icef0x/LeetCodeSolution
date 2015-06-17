package com.leetcode.iceph0x;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import com.leetcode.iceph0x.Problem2Solution.ListNode;

public class Problem2SolutionTest {
	
	private Problem2Solution solution;
	

	@Before
	public void setUp() throws Exception {
		solution = new Problem2Solution();
	}

	@Test
	public void testAddTwoNumbers() {
		TestCase[] testCases = generateTestCases();
		for (TestCase testCase : testCases) {
			ListNode result = solution.addTwoNumbers(testCase.input1, testCase.input2);
			assertTrue(testCase.testResult(result));
		}
	}

	private TestCase[] generateTestCases() {
		TestCase[] testCases = new TestCase[1000];
		Random r = new Random();
		for (int i = 0; i < testCases.length; ++i) {
			long input1 = Math.abs(0l + r.nextInt());
			long input2 = Math.abs(0l + r.nextInt());
			long result = input1 + input2;
			testCases[i] = new TestCase(transformToListNode(input1), transformToListNode(input2),
			        transformToListNode(result));
		}
		return testCases;
	}
	
	private ListNode transformToListNode(long num) {
		String s = Long.toString(num);
		ListNode head = new ListNode(s.charAt(s.length() - 1) - '0');
		ListNode index = head;
		for (int i = s.length() - 2; i >= 0; --i) {
			index.next = new ListNode(s.charAt(i) - '0');
			index = index.next;
		}
		return head;
	}
	
	private static class TestCase {
		ListNode input1;
		ListNode input2;
		ListNode result;
		
		public TestCase(ListNode input1, ListNode input2, ListNode result) {
			this.input1 = input1;
			this.input2 = input2;
			this.result = result;
        }
		
		public boolean testResult(ListNode result) {
			if (this.result == result)
				return true;
			
			if (result == null)
				return false;
			
			boolean correct = true;
			for (ListNode r = this.result; r != null || result != null; r = r.next, result = result.next) {
				if (r == null)
					return false;
				if (result == null)
					return false;				
				if (r.val != result.val)
					return false;
			}
			return true;
		}
	}
}
