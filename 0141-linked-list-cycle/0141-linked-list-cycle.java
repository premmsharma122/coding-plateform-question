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
        if(head==null || head.next==null) return false;
        HashSet<ListNode> hs = new HashSet<>();
        ListNode cur  = head;
        while(cur!=null && cur.next!=null){
            ListNode v = cur;
            if(hs.contains(v)) return true;
            hs.add(v);
            cur=cur.next;
        }
        return false;
    }
}