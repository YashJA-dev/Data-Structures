/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node,Node> map=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null)return null;
        map.put(node,new Node(node.val));
        Queue<Node> qu=new LinkedList<>();
        qu.offer(node);
        bfs(qu);
        return map.get(node);
    }
    public void bfs(Queue<Node> qu){
        while(!qu.isEmpty()){
            Node node=qu.poll();
            for(Node val:node.neighbors){
                if(!map.containsKey(val)){
                    map.put(val,new Node(val.val));
                    qu.offer(val);
                }
                map.get(node).neighbors.add(map.get(val));
            }
        }
    } 
}