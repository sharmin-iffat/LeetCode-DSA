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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;       // First critical point
        int prevCritical = -1; // Previous critical point

        int minDist = Integer.MAX_VALUE;
        int maxDist = -1;

        int index = 1;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr != null && curr.next != null) {

            // Check if current node is a critical point
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                // First critical point
                if (first == -1) {
                    first = index;
                }

                // Calculate distance from previous critical point
                if (prevCritical != -1) {
                    minDist = Math.min(minDist, index - prevCritical);
                }

                prevCritical = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // Need at least two critical points
        if (first == -1 || first == prevCritical) {
            return new int[]{-1, -1};
        }

        // Distance between first and last critical point
        maxDist = prevCritical - first;

        return new int[]{minDist, maxDist};
    }
}