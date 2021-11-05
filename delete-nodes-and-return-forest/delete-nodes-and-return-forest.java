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
    List<TreeNode> list=new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set=new HashSet<>();
        for(int val:to_delete){
            set.add(val);
        }
        TreeNode node=deleteNode(root,null,list,set,0);
        if(node!=null)list.add(node);
        return list;
    }
    public TreeNode deleteNode(TreeNode root,TreeNode prev,List<TreeNode> res,Set<Integer> set,int side){
        if(root==null)return null;
        root.left=deleteNode(root.left,root,res,set,0);
        root.right=deleteNode(root.right,root,res,set,1);
        if(set.contains(root.val)){
            set.remove(root.val);
            if(root.left!=null)res.add(root.left);
            if(root.right!=null)res.add(root.right);
            return null;
        }
        return root;
    }
}