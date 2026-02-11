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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode temp = head;

        int i=0;
        while(temp != null){
            if(st.isEmpty() || temp.val <= st.peek().val){
                st.push(temp);
            } 
            // else if(!st.isEmpty() && temp.val <= st.peek()){
            //     st.push(temp);
            //     temp = temp.next;
            // } 
            else{
                while(!st.isEmpty()&& temp.val > st.peek().val){
                    st.pop();
                }
                st.push(temp);
            }
            temp = temp.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (ListNode ele : st) {
            curr.next = new ListNode(ele.val);
            curr = curr.next;
        }
        return dummy.next;        
    }
}