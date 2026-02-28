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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode l1=list1, l2=list2;
        ListNode dmy = new ListNode(-1);
        ListNode t = dmy;
        while(l1 != null && l2!=null){
            if(l1.val<=l2.val){
                t.next=l1;
                l1=l1.next;
            }else{
                t.next=l2;
                l2=l2.next;
            }
            t=t.next;
        }
        if(l1!=null) t.next=l1;
        if(l2!=null) t.next=l2;
        return dmy.next;
    }
}