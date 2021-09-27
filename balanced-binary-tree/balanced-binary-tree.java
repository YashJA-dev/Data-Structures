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
    public boolean isBalanced(TreeNode root) {
        return isBalancedTree(root,0,0)!=-1;
    }
    public int isBalancedTree(TreeNode root,int l,int r){
        if(root==null)return 0;
        l=isBalancedTree(root.left,l,r);
        if(l==-1)return -1;
        r=isBalancedTree(root.right,l,r);
        if(r==-1)return -1;

        if((int)Math.abs(l-r)>1)return -1;
        return Math.max(l,r)+1;
    }
}