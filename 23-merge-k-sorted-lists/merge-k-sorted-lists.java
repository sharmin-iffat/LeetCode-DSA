/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

       PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );
       

        for(ListNode head: lists){    
            while(head != null){
                pq.offer(head);
                head = head.next;
            } 
        }

        ListNode dummy = new ListNode(0);
        ListNode ans =  dummy;

        while(pq.size()>0){
            dummy.next = pq.poll();
            dummy = dummy.next;
        } 
        dummy.next = null;

        return ans.next;
        
    }
}