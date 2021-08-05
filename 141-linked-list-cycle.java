// https://leetcode.com/problems/linked-list-cycle/
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
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode singlePointer = head;
        ListNode doublePointer = head;
        do {
            if (doublePointer.next != null && doublePointer.next.next != null) {
                doublePointer = doublePointer.next.next;
                singlePointer = singlePointer.next;
            }
            else
                return false;
        } while (singlePointer != doublePointer);
        return true;
    }
}