// https://leetcode.com/problems/add-two-numbers/
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
        ListNode sum = new ListNode();
        ListNode currentNode = sum;
        int carryForward = 0;
        int value, tensPlace, unitsPlace;
        while(true) {
            value = carryForward;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            tensPlace = value/10;
            unitsPlace = value%10;
            currentNode.next = new ListNode(unitsPlace);
            currentNode = currentNode.next;
            carryForward = tensPlace;
            if (l1 == null && l2 == null) {
                if (carryForward > 0) {
                    while(carryForward > 0) {
                        currentNode.next = new ListNode(carryForward%10);
                        carryForward /= 10;
                    }
                }
                break;
            }
        }
        return sum.next;
    }
}