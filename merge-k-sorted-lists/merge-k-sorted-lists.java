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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(ListNode list:lists){
            while(list!=null){
                pq.add(list.val);
                list=list.next;
            }
        }
        ListNode list=new ListNode(-1);
        ListNode head=list;
        while(!pq.isEmpty()){
            list.next=new ListNode(pq.poll());
            list=list.next;
        }
        return head.next;
    }
    class Compare implements Comparator<ListNode>{
        public int compare(ListNode p1,ListNode p2){
            if(p1.val>p2.val){
                return 1;
            }else if(p1.val<p2.val)return -1;
            return 0;
        }
    }
}