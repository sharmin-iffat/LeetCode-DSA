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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> st = new Stack<>();

        int len =0;
        ListNode temp = head;

        while(temp != null){
            len++;
            temp = temp.next;
        }
        temp = head;
        for(int i=0; i<len/2; i++){
            st.add(temp.val);
            temp = temp.next;
        }
        if (len % 2 == 1) {
            temp = temp.next;
        }
        while(st.size() != 0 && temp != null){
            int top = st.pop();
            if(top != temp.val) return false;
            else temp = temp.next;
        }
        return true;
        
    }
}