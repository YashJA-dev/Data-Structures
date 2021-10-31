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
        List<Integer> li = new ArrayList<>();
        int max_max_num = -1;
        int max_min_num = (int) 1e18;
        int min_max_num = -1;
        int min_min_num = (int) 1e18;
        ListNode prev = head;
        ListNode next = head.next;
        int i = 2;
        while (next.next != null) {
            if (i == 3) {
                System.out.println(prev.val + " " + next.val + " " + next.next.val);
            }
            if (prev.val < next.val && next.val > next.next.val) {
                li.add(i);
                // max_max_num=Math.max(max_max_num,i);
                // max_min_num=Math.min(max_min_num,i);
                // maximum.add(new Pair(next.val,i));
            } else if (prev.val > next.val && next.val < next.next.val) {
                li.add(i);
                // min_max_num=Math.max(min_max_num,i);
                // min_min_num=Math.min(min_min_num,i);
                // maximum.add(new Pair(next.val,i));
            }
            prev = next;
            next = next.next;
            i++;
        }
        int[] ans = new int[2];
        Collections.sort(li);
        Arrays.fill(ans, -1);

        if (li.size() >= 2) {
            int max = li.get(li.size() - 1);
            System.out.println(li.get(li.size() - 2) + " value");
            ans[1] = (li.get(li.size() - 1)) - (li.get(0));
            ans[0]=(int)1e18;
            for (int k = 1; k < li.size(); k++) {
                ans[0] = Math.min(li.get(k) - li.get(k - 1), ans[0]);
            }
        }
        return ans;
    }
}
