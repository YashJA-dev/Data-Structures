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
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }    
        i=inorder.length-1;
        return constructTree(postorder,0,postorder.length-1);
    }
    int i;
    public TreeNode constructTree(int[] post,int l,int r){
        if(l>r)return null;
        int val=post[i--];
        int mid=map.get(val);
        TreeNode node=new TreeNode(val);
        if(l==r)return node;
        node.right = constructTree(post,mid+1,r);
        node.left  = constructTree(post,l,mid-1);
        return node;
    }
}