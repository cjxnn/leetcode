/**
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 * Follow up: What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 * Example: Init a singly linked list [1,2,3].
 *     ListNode head = new ListNode(1);
 *     head.next = new ListNode(2);
 *     head.next.next = new ListNode(3);
 *     Solution solution = new Solution(head);
 * getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 *     solution.getRandom();
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
 
 public class Solution {
    private final Random rand = new Random();
    private final ListNode first;
    
    private int length;
    private ListNode answer, temp; 

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        first = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        answer = first;
        temp = first.next;
        
        length = 1;
        while (temp != null){
            if (length++ == rand.nextInt(length)) answer = temp;
            temp = temp.next;
        }
        
        return answer.val;
    }
}