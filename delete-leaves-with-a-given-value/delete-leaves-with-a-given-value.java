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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return trimBST(root,target);
    }
        public TreeNode trimBST(TreeNode root,int key) {
        if(root==null)return null;
        if(root.val==key){
            if(bottomFull(root,key)){
                return null;
            }
        }

        root.left=trimBST(root.left,key);
        root.right=trimBST(root.right,key);
        return root;
    }

    private boolean bottomFull(TreeNode root,int key) {
        if(root==null)return true;
        if(root.val!=key)return false;
        if(!bottomFull(root.left, key))return false;
        if(!bottomFull(root.right, key))return false;
        return true;
    }

}