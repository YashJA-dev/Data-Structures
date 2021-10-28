class Solution {
    List<Set<Integer>> adj;
    public int findCircleNum(int[][] isConnected) {
        adj=new ArrayList<>();
        for(int i=0;i<isConnected.length;i++)adj.add(new HashSet<>());
        int n=isConnected.length;
        for(int i=0;i<n;i++){
            boolean see=false;
            int k=0;
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1&&!see){
                    see=true;
                    k=j;
                    continue;
                }
                if(see&&isConnected[i][j]==1){
                    adj.get(k).add(j);
                    adj.get(j).add(k);
                }
            }
        }
        int[] par=new int[n];
        Arrays.fill(par,-1);
        int c=0;
        for(int i=0;i<n;i++){
            if(par[i]==-1){
                c++;
                dfs(i,i,par);
            }
        }
        return c;
    }
    public void dfs(int i,int parent,int[] par){
        par[i]=parent;
        for(int val:adj.get(i)){
            if(par[val]==-1){
                dfs(val,parent,par);
            }
        }
    }
}