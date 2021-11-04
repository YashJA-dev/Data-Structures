class Solution {
    List<List<Integer>> adj = new ArrayList<>();

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] inorder = new int[n];
        for(int i=0;i<n;i++)adj.add(new ArrayList<>());
        List<Integer> ans=new ArrayList<>();
        if(n<=2){
            for(int i=0;i<n;i++){
                ans.add(i);
            }
            return ans;
        }
        for(int[] arr:edges){
            inorder[arr[0]]++;
            inorder[arr[1]]++;
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        Queue<Integer> qu=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inorder[i]==1)qu.offer(i);
        }
        while(n>2){
            int size=qu.size();
            n=n-size;
            for(int i=0;i<size;i++){
                int val=qu.poll();
                for(int items:adj.get(val)){
                    inorder[items]--;
                    if(inorder[items]==1)qu.offer(items);
                }
            }
        }
       while(!qu.isEmpty()){
           ans.add(qu.poll());
       }
        return ans;
    }
}
