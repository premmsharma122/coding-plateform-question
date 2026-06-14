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
    public int pairSum(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode cur = head;
        while(cur!=null){
            arr.add(cur.val);
            cur=cur.next;
        }
        int i=0, j=arr.size()-1;
        int m =0;
        while(i<=j){
            int sum = arr.get(i++)+arr.get(j--);
            m = Math.max(m,sum);
        }
        return m;
    }
}