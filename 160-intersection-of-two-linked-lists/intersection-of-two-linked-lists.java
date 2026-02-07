/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA =0;
        int lenB = 0;

        ListNode temp = headA;
        while(temp != null){
            lenA++;
            temp = temp.next;
        }
        temp = headB;
        while(temp != null){
            lenB++;
            temp = temp.next;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        int diff = Math.abs(lenA - lenB);

        if(lenA > lenB){
            for(int i=0; i<diff; i++){
                tempA = tempA.next;
            }
        }else{
            for(int i=0; i<diff; i++){
                tempB = tempB.next;
            }
        }
        while(tempA != null && tempB != null){
            if(tempA == tempB){
                return tempA;
            }
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return null;
    }
}

