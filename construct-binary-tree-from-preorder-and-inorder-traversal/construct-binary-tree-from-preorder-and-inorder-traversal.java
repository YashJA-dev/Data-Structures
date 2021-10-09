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
    public TreeNode buildTree(int[] pre, int[] ino) {
        for(int i=0;i<ino.length;i++){
            map.put(ino[i],i);
        }
        return construct(pre,0,pre.length-1);
    }
    int i=0;
    public TreeNode construct(int[] pre,int l,int r){
        if(l>r)return null;
        int val=pre[i++];
        int mid=map.get(val);
        TreeNode node=new TreeNode(val);
        if(l==r)return node;
        node.left=construct(pre,l,mid-1);
        node.right=construct(pre,mid+1,r);
        return node;
    }
}