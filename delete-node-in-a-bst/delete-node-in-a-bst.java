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
    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteInBST(root,key);
    }
     public TreeNode deleteInBST(TreeNode root,int val){
        if(root==null)return null;
        if(root.val>val)root.left=deleteInBST(root.left,val);
        else if(root.val<val)root.right=deleteInBST(root.right,val);
        else{
            if(root.left==null&&root.right==null)return null;
            else if(root.left==null)return root.right;
            else if(root.right==null)return root.left;
            else{
                TreeNode max=maxi(root.left);
                System.out.println(max.val);
                root.val=max.val;
                root.left=deleteInBST(root.left,max.val);
                // printBst(root);

                return root;
            }    
        }
        return root;
    }
    private TreeNode maxi(TreeNode root){
        if(root.right==null)return root;
        return maxi(root.right);
        
    }
}