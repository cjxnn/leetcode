/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution{
	public ListNode deleteDuplicates(ListNode head){
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode current = dummy;
		while(current.next != null){
			boolean isRepeat = false;
			while(current.next.next != null && current.next.val == current.next.next.val){
				isRepeat = true;
				current.next = current.next.next;
			}

			if (isRepeat)
				current.next = current.next.next;
			else
				current = current.next;
		}

		return dummy.next;
	}
}
