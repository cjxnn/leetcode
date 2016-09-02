/**
 * Given a singly linked list L: L0->L1->…->Ln-1->Ln,
 * reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2->…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return;
            
        ListNode temp1 = head, temp2 = head;
        while (temp2.next != null && temp2.next.next != null){
            temp1 = temp1.next;
            temp2 = temp2.next.next;
        }
        
        ListNode tail = temp1.next;
        temp1.next = null;

        temp1 = null;
        temp2 = tail;
        while (tail.next != null){
            tail = tail.next;
            temp2.next = temp1;
            temp1 = temp2;
            temp2 = tail;
        }
        tail.next = temp1;
        
        while (head.next != null){
            temp1 = tail;
            tail = tail.next;
            temp1.next = head.next;
            head.next = temp1;
            head = temp1.next;
        }
        head.next = tail;
    }
}