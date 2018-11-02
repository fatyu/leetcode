package leetcode.algorithm._141;

/**
 Given a linked list, determine if it has a cycle in it.
 Follow up:
 Can you solve it without using extra space?
 */
public class LinkedListCycle {
	/**
	 * Definition for singly-linked list.
	 * class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */
	//解题思路：如果出现环形链，则通过一个快指针和一个慢指针进行链表循环，终究两个指针会相撞。
	public boolean hasCycle(ListNode head) {

		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && slow != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}