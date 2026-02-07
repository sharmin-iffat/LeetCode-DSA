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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp1 = head;
        ListNode temp2 = head;
        int len =1;
        while(temp2 != null){
            len++;
            temp2 = temp2.next;

            if(len <= k){
                temp1 = temp1.next;
            }
        }
        temp2 = head;
        for(int i=1; i<len-k; i++){
            temp2 = temp2.next;
        }

        int val = temp1.val;
        temp1.val= temp2.val;
        temp2.val = val;

        return head;
    }
}