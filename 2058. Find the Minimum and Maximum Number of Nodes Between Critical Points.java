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

        ListNode prev = head;
        ListNode cur = head.next;
        ArrayList<Integer> cr = new ArrayList<>();
        int pos = 1;

        while (cur != null && cur.next != null) {

            if ((cur.val < prev.val && cur.val < cur.next.val) ||
                (cur.val > prev.val && cur.val > cur.next.val)) {
                cr.add(pos);
            }

            prev = cur;
            cur = cur.next;
            pos++;
        }

        if (cr.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDist = Integer.MAX_VALUE;

        for (int i = 1; i < cr.size(); i++) {
            minDist = Math.min(
                minDist,
                cr.get(i) - cr.get(i - 1)
            );
        }

        int maxDist = cr.get(cr.size() - 1)
                    - cr.get(0);

        return new int[]{minDist, maxDist};
    }
}
