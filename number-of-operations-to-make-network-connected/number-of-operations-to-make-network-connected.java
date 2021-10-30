class Solution {
    List<List<Integer>> adj=new ArrayList<>();
    public int makeConnected(int n, int[][] connections) {
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        int noOfEdges=connections.length;
        for(int i=0;i<connections.length;i++){
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(connections[i][0]);
        }
        boolean[] vis=new boolean[n];
        int componentsTotal=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                componentsTotal++;
                dfs(vis,i);
            }
        }
        int red=noOfEdges-((n-1)-(componentsTotal-1));
        if(red>=componentsTotal-1){
            return componentsTotal-1;
        }
        return -1;
    }
    public void dfs(boolean[] vis,int i){
        vis[i]=true;
        for(int val:adj.get(i)){
            if(!vis[val]){
                dfs(vis,val);
            }
        }
    }
}