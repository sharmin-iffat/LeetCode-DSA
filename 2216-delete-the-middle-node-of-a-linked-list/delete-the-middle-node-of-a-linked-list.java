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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        if(len == 0) return head;

        temp = head;
        int j = len/2;
        for(int i=0; i<j-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}