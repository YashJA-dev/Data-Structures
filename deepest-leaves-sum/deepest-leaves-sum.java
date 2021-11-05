/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> qu=new LinkedList<>();
        qu.add(root);
        int max=0;
        while(!qu.isEmpty()){
            int n=qu.size();
            int val=0;
            for(int i=0;i<n;i++){
                TreeNode node=qu.poll();
                val+=node.val;
                if(node.left!=null)qu.offer(node.left);
                if(node.right!=null)qu.offer(node.right);
            }
            max=val;
        }
        return max;
    }
}