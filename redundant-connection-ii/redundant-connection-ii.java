class Solution {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] indegre = new int[n + 1];
        DSU dsu = new DSU(n + 1);
        int bl1 = -1,bl2=-1;
        Arrays.fill(indegre, -1);
        for (int i = 0; i < edges.length; i++) {
            if (indegre[edges[i][1]] == -1) {
                indegre[edges[i][1]] = i;
                System.out.println(Arrays.toString(indegre));
            } else {
                bl1=i;
                bl2=indegre[edges[i][1]];
                 break;
            }
        }
        for(int i=0;i<n;i++){
            if(i==bl1)continue;
            if(dsu.union(edges[i][0],edges[i][1])){
                if(bl1==-1)return edges[i];
                else return edges[bl2];
            }
        }
        return edges[bl1];
    }
}

class DSU {
    int[] parent;
    int[] size;

    DSU(int n) {
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int findParent(int node) {
        if (node == parent[node]) return node;
        return parent[node] = findParent(parent[node]);
    }

    public boolean union(int u, int v) {
        int parentOfU = findParent(u);
        int parentOfV = findParent(v);
        if (parentOfU == parentOfV) return true; else if (size[parentOfU] >= size[parentOfV]) {
            parent[parentOfV] = parentOfU;
            size[parentOfU] += size[parentOfV];
        } else if (size[parentOfU] < size[parentOfV]) {
            parent[parentOfU] = parentOfV;
            size[parentOfV] += size[parentOfU];
        }
        return false;
    }
}
