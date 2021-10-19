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
    int i=0;
    public int[] findMode(TreeNode root) {
        getModes(root);
        
        int[] ans=new int[res.size()];
        i=0;
        for(int val:res)ans[i++]=val;
        return ans;
    }
    List<Integer> res=new ArrayList<>();
    TreeNode prev=null;
    int c=0;
    int max=0;
    public void getModes(TreeNode root){
        if(root==null)return;
        getModes(root.left);
        System.out.println(c+" bfore");
        if(prev!=null&&prev.val==root.val){
            c++;
        }else{
            prev=root;
            c=1;
        }
        if(c>max){
            res.clear();
            max=c;
        }
        if(c==max)res.add(root.val);
        System.out.println(c+" after");

        getModes(root.right);
    }
}