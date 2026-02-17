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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int length = 1;
        while(tail.next != null){
            length++;
            tail = tail.next;
        }

        k = k % length;
        if( k == 0){
            return head;
        }

        tail.next = head;

        int stepNew = length - k -1;
        ListNode newTail = head;

        for(int i=0; i<stepNew; i++){ 
            newTail = newTail.next;
        }
        ListNode newH = newTail.next;
        newTail.next = null;

        return newH;
    }
}