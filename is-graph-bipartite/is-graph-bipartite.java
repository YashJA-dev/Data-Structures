class Solution {
    // ArrayList<ArrayList<Integer>> adj;
    int[] vis;
    public boolean isBipartite(int[][] adj) {
        
        vis=new int[adj.length];
        Arrays.fill(vis,-1);
        return bfs(adj,vis,adj.length);
    }
    public boolean bfs(int[][] adj,int[] vis,int n){
        for(int i=0;i<n;i++){
            if(vis[i]==-1){
                vis[i]=0;
                Queue<Integer> qu=new LinkedList<>();
                qu.add(i);
                while(!qu.isEmpty()){
                    int val=qu.poll();
                    for(int value:adj[val]){
                        if(vis[value]==-1){
                            vis[value]=(vis[val]==0)?1:0;
                            qu.add(value);
                        }else{
                            if(vis[value]==vis[val])return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}