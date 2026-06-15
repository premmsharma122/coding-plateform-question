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
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        int s = 0;
        ListNode d = head;

        while (d != null) {
            s++;
            d = d.next;
        }

        int mid = s / 2;

        ListNode f = head;
        int i = 0;

        while (i < mid - 1) {
            f = f.next;
            i++;
        }

        f.next = f.next.next;

        return head;
    }
}
