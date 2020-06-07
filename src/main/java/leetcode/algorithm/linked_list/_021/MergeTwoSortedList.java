package leetcode.algorithm.linked_list._021;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 * 解题思路：递归对比
 */
public class MergeTwoSortedList {


	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		if ((null == l1) && (null == l2)) {
			return null;
		}
		if (null == l1) {return l2;}
		if (null == l2) {return l1;}

		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;

		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}


	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		ListNode l1N = new ListNode(3);
		ListNode l1NN = new ListNode(5);
		l1N.next = l1NN;
		l1.next = l1N;


		ListNode l2 = new ListNode(2);
		ListNode l2N = new ListNode(4);
		ListNode l2NN = new ListNode(6);
		l2N.next = l2NN;
		l2.next = l2N;

		MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
		ListNode result = mergeTwoSortedList.mergeTwoLists(l1, l2);
		result.printString();

	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	boolean hasNext() {
		return next != null;
	}

	public void printString() {
		StringBuilder sb = new StringBuilder("" + this.val);
		while (hasNext()) {
			sb.append("->" + next.val);
			next = next.next;
		}
		System.out.println("ListNode{" + sb.toString() + '}');
	}


}
