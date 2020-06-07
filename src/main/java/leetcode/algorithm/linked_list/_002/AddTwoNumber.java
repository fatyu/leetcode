package leetcode.algorithm.linked_list._002;

/**
 * Created by fatyu on 15/1/28.
 * <p/>
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public boolean hasNext() {
		return next == null;
	}

	@Override
	public String toString() {
		return new StringBuffer(128).append("[val:").append(this.val).append(" next:").append(next).append("]")
				.toString();
	}

}

public class AddTwoNumber {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (null == l1) {
			return l2;
		}
		if (null == l2) {
			return l1;
		}
		ListNode result = new ListNode(0);//
		ListNode tmpResult = result;//
		boolean hasLeftNode = true;
		while (hasLeftNode) {
			int l1Val = l1 == null ? 0 : l1.val;
			int l2Val = l2 == null ? 0 : l2.val;
			int val = tmpResult.val + l1Val + l2Val;
			int nextNodeInitVal = 0;
			nextNodeInitVal = val / 10;
			val = val % 10;
			tmpResult.val = val;
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
			hasLeftNode = l1 != null || l2 != null;
			if (hasLeftNode || nextNodeInitVal > 0) {
				tmpResult.next = new ListNode(nextNodeInitVal);
				tmpResult = tmpResult.next;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);

		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);

		AddTwoNumber addTwoNumber = new AddTwoNumber();
		ListNode addResult = addTwoNumber.addTwoNumbers(l1, l2);
		System.out.println(addResult);
	}
}
