class Solution {
    List<List<Integer>> adj=new ArrayList<>();
    public int findCenter(int[][] edges) {
        for(int[] arr:edges){
            int u=arr[0];
            int v=arr[1];
            while(adj.size()<u+1||adj.size()<v+1){
                adj.add(new ArrayList<>());
            }
            adj.get(u).add(v);
            adj.get(v).add(u);
        
        }
        // int i=0;
        for(int i=0;i<adj.size();i++){
            System.out.println(adj.get(i).size());
            if((adj.get(i).size()+1)==adj.size()-1)return i;
        }
        return 0;
    }
}