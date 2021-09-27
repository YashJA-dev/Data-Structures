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
    public TreeNode balanceBST(TreeNode root) {
        // String[] ar= formList(root,new StringBuilder()).split(',');
        String x=formList(root,new StringBuilder());
        System.out.println(x);
        String[] ar=x.split(",");
        return form(ar,0,ar.length-1);
    }
   public TreeNode form(String[] ar,int l,int r){
       if(l>r)return null;
       int mid=(l+r)/2;
       int v=Integer.valueOf(ar[mid]);
       TreeNode root=new TreeNode(v);
       root.left=form(ar,l,mid-1);
       root.right=form(ar,mid+1,r);
       return root;
   }
    public String formList(TreeNode node,StringBuilder sb){
        if(node==null)return sb.toString();
        formList(node.left,sb);
        sb.append(String.valueOf(node.val)+",");
        formList(node.right,sb);
        return sb.toString();
    }
    
    
}