// https://leetcode.com/problems/linked-list-cycle-ii/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode intersect = getIntersection(head);
        if (intersect != null) {
            while (head != intersect) {
                head = head.next;
                intersect = intersect.next;
            }
            return intersect;
        }
        return null;
    }
    
    public ListNode getIntersection(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            else
                return null;
            if (fast == slow) {
                return fast;
            }
        } while (fast != slow);
            return fast;
    }
}