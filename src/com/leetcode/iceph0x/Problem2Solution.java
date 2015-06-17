package com.leetcode.iceph0x;

/**
 * Add Two Numbers
 * 
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 ->3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * @author iceph0x
 *
 */
public class Problem2Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		ListNode next = null;

		int flag = 0;
		while (l1 != null || l2 != null) {
			int v = addNode(l1, l2) + flag;
			if (v >= 10) {
				v -= 10;
				flag = 1;
			}
			else {
				flag = 0;
			}

			if (next == null) {
				result = next = new ListNode(v);
			}
			else {
				next.next = new ListNode(v);
				next = next.next;
			}

			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}

		if (flag != 0) {
			if (result == null)
				result = new ListNode(flag);
			else
				next.next = new ListNode(flag);
		}

		return result;
	}

	private int addNode(ListNode l1, ListNode l2) {
		return (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
	}

	public static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
		}
	}
}
