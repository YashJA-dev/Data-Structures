class Solution {
    List<List<Integer>> adj=new ArrayList<>();
    public int maximalNetworkRank(int n, int[][] roads) {
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] ar:roads){
            adj.get(ar[0]).add(ar[1]);
            adj.get(ar[1]).add(ar[0]);
        }
        for(int i=0;i<n;i++){
            System.out.print(i+" -> ");
            for(int x:adj.get(i)){
                System.out.print(x+" - ");
            }
            System.out.println();
        }
        int max=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int sizex=adj.get(i).size();
                int sizey=adj.get(j).size();
                boolean see=false;
                for(int k:adj.get(j)){
                    if(k==i){
                        see=true;
                        break;
                    }
                }
                int ans=0;
                if(see){
                    ans=sizex+sizey-1;
                }else{
                    ans=sizex+sizey;
                }
                max=Math.max(ans,max);
            }
        }
        return max;
    }
}