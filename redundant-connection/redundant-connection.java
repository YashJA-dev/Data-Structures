class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int prev=0;
        DSU dsu=new DSU(edges.length+1);
        for(int i=0;i<edges.length;i++){
            int parentU=dsu.findParent(edges[i][0]);
            int parentV=dsu.findParent(edges[i][1]);
            // System.out.println(parentU+" size "+dsu.size[parentU]+" | "+parentV+" size "+dsu.size[parentU]);
            if(parentU==parentV)prev=i;
            else{
                dsu.union(edges[i][0],edges[i][1]);
                // System.out.println(dsu.findParent(edges[i][0])+" "+dsu.findParent(edges[i][1]));
            }
        }
        return edges[prev];
    }
}
class DSU{
    int[] parent;
    int[] size;
    DSU(int n){
        parent=new int[n];
        size=new int[n];
        Arrays.fill(size,1);
        for(int i=0;i<n;i++)parent[i]=i;
    }
    public int findParent(int node){
        if(node==parent[node])return node;
        return parent[node]=findParent(parent[node]);
    }
    public void union(int u,int v){
        int parentOfU=findParent(u);
        int parentOfV=findParent(v);
        // if(u==3&&v==5)System.out.println(parentOfU+" "+parentOfV);
        if(size[parentOfU]>=size[parentOfV]){
            parent[parentOfV]=parentOfU;
            size[parentOfU]+=size[parentOfV];
        }else if(size[parentOfU]<size[parentOfV]){
            parent[parentOfU]=parentOfV;
            size[parentOfV]+=size[parentOfU];
        }
    }
}