class Solution {
    List<List<Node>> adj=new ArrayList<>();
    public double maxProbability(int n, int[][] edges, double[] succ, int start, int end) {
        PriorityQueue<Node> pq=new PriorityQueue<>(new Compare());
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        int j=0;
        for(int i=0;i<edges.length;i++){
            
            adj.get(edges[i][0]).add(new Node(edges[i][1],succ[i]));
            adj.get(edges[i][1]).add(new Node(edges[i][0],succ[i]));
            // j++;
        }
        double[] ans=new double[n];
        Arrays.fill(ans,0);
        pq.add(new Node(start,1));
        ans[start]=1;
        while(!pq.isEmpty()){
            Node p=pq.poll();
            int value=p.val;
            double weight=p.weight;
            for(Node node:adj.get(value)){
                if((p.weight*node.weight)>ans[node.val]){
                    ans[node.val]=(p.weight*node.weight);
                    pq.offer(new Node(node.val,ans[node.val]));
                }
            }
        }
        System.out.println(Arrays.toString(ans));
        
        return ans[end];
    }
    class Node{
        int val;
        double weight;
        Node(int val,double weight){
            this.val=val;
            this.weight=weight;
        }
    }
    class Compare implements Comparator<Node>{
        public int compare(Node p1,Node p2){
            if(p1.weight>p2.weight)return -1;
            else if(p1.weight<p2.weight)return 1;
            return 0;
        }
    }
}