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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathsFormed(root,new ArrayList<>(),targetSum);
        return res;
    }
    List<List<Integer>> res=new ArrayList<>();
    public void pathsFormed(TreeNode node,List<Integer> ds,int targetSum){
        if(node==null)return;
        if(node.left==null&&node.right==null){
            if(targetSum-node.val==0){
                
                ds.add(node.val);
                res.add(new ArrayList<>(ds));
                ds.remove(ds.size()-1);

            }
            return ;
        }
        ds.add(node.val);
        pathsFormed(node.left,ds,targetSum-node.val);
        ds.remove(ds.size()-1);
        ds.add(node.val);
        pathsFormed(node.right,ds,targetSum-node.val);
        ds.remove(ds.size()-1);
    }

 }