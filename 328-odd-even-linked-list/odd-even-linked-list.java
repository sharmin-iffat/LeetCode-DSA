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
    public ListNode oddEvenList(ListNode head) {
        int len =0;

        ListNode dummyOdd = new ListNode(0);
        ListNode d1 = dummyOdd;

        ListNode dummyEven = new ListNode(0);
        ListNode d2 = dummyEven;
        

        ListNode temp = head;

        while(temp != null){
            len++;
            if(len % 2 !=0){
                dummyOdd.next = temp;
                dummyOdd = dummyOdd.next;
            }else{
                dummyEven.next = temp;
                dummyEven = dummyEven.next;
            }
            temp = temp.next;
        }
        dummyEven.next = null; 
        dummyOdd.next = d2.next;
        return d1.next;
        
    }
}