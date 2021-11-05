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
        if(root==null)return root;
        else if(root.val>key)root.left=deleteNode(root.left,key);
        else if(root.val<key)root.right=deleteNode(root.right,key);
        else{
            if(root.left==null&&root.right==null){
               System.out.println(root.val);
                return null;
            }
            else if(root.left==null)return root.right;
            else if(root.right==null)return root.left;
            else{
                TreeNode max=maxOfRight(root.left);
                root.val=max.val;
                root.left=deleteNode(root.left,root.val);
                return root;
            }
        }
        return root;
    }
    public TreeNode maxOfRight(TreeNode root){
        if(root.right==null)return root;
        return maxOfRight(root.right);
    }
}
