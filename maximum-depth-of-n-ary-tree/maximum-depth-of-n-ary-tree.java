/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }
    
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    public int maxDepth(Node root) {
        if(root==null)return 0;
        max(root,1);
        return maxi;
    }
    int maxi=0;
    public void max(Node root,int i){
        if(root==null)return;
        for(Node node:root.children){
            System.out.println("before "+i+" val"+node.val);
            i++;
            max(node,i);
            i--;
            System.out.println("after "+i+" val"+node.val);
        }
        maxi=Math.max(maxi,i);
    }
}