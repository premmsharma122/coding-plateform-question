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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int s=0;
        ListNode tmp = head;
        ListNode ans= tmp;
        while(tmp!=null){
            s++;
            tmp=tmp.next;
        }
        if(s==1 && n>=1) return null;
        if(s==n){
            return head.next;
        }
        int k=s-n-1;//3
        ListNode dm=head;
        while(k-->0){
            dm=dm.next;
        }
        if(dm.next!=null) dm.next=dm.next.next;
        
        return ans;
    }
}