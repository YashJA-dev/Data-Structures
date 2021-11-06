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
    // sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
       return sumOfFull(root,0,low,high);
    }
    
    public int sumOfFull(TreeNode root,int sum,int left,int high){
        if(root==null)return sum;
        sum=sumOfFull(root.left,sum,left,high);
        System.out.println("out "+root.val);

        if(root.val>=left&&root.val<=high){
            System.out.println("in "+root.val);
            sum+=root.val;
        };
        sum=sumOfFull(root.right,sum,left,high);
        return sum;
    }
}