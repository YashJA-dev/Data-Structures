class Solution {
    boolean vis[] ;
    ArrayList<ArrayList<Integer>> adj;
    public boolean validPath(int n, int[][] edges, int start, int end) {
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        vis=new boolean[n];
        
        
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
          adj.get(edges[i][1]).add(edges[i][0]);
        }
        for(int[] ar:edges){
            System.out.println(Arrays.toString(ar));
        }
        if(!vis[start]){
            if(dfs(adj,start,start,end,true))return true;
        }
        return false;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int start,int i,int end,boolean first){
        vis[i]=true;
        if(i==end)return true;
        for(int val:adj.get(i)){
            if(!vis[val]){
                if(dfs(adj,start,val,end,false))return true;
            }
        }
        return false;
    }
     private boolean dfs(int start, int end,boolean[] visited,ArrayList<ArrayList<Integer>> adjList){
        if(start==end)
            return true;
        visited[start] = true;
        for(int ver : adjList.get(start)){
            if(!visited[ver]) {
            	if(dfs(ver,end,visited,adjList))
            		return true;
            }
        }
        return false;
    }
}