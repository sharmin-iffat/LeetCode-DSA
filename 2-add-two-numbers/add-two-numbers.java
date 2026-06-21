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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode temp1 =l1;
        ListNode temp2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;

        while(temp1 != null || temp2 != null || carry != 0){
            int val1 = (temp1 == null) ? 0 : temp1.val;
            int val2 = (temp2 == null) ? 0 : temp2.val;

            int sum = val1 + val2 + carry;

            int value = sum%10;
            carry = sum/10;

            ListNode ans = new ListNode(value);
            dummy.next = ans;
            dummy = dummy.next;

            temp1 = (temp1 == null) ? null : temp1.next;
            temp2 = (temp2 == null) ? null : temp2.next;

        }
        return newHead.next;
        
    }
   
}