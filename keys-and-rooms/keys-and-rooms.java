class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] vis=new boolean[n];
        
        dfs(rooms,vis,0);
        for(boolean sa:vis)if(!sa)return false;
        return true;
    }
    public void dfs(List<List<Integer>> rooms,boolean[] vis,int i){
        vis[i]=true;
        for(int k:rooms.get(i)){
            if(!vis[k])dfs(rooms,vis,k);
        }
    }
}