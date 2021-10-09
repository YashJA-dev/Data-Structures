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
    public TreeNode bstFromPreorder(int[] pre) {
        return formBst(pre,(int)9e10);
    }
    int i=0;
    public TreeNode formBst(int[] pre,int parent){
        if(i>=pre.length||pre[i]>parent)return null;
        int val=pre[i++];
        TreeNode node=new TreeNode(val);
        node.left=formBst(pre,val);
        node.right=formBst(pre,parent);
        return node;
    }
}