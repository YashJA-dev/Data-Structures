class Solution {
    List<List<Integer>> adj;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());
        Stack<Integer> st=new Stack<>();
        int[] inorder=new int[numCourses];
        for(int[] arr:prerequisites){
            inorder[arr[0]]++;
            adj.get(arr[1]).add(arr[0]);
        }
        int n=numCourses;
        Queue<Integer> qu=new LinkedList<>(); 
        for(int i=0;i<n;i++){
            if(inorder[i]==0)qu.add(i);
        }
        int i=0;
        int[] ans=new int[n];
        while(!qu.isEmpty()){
            ans[i++]=qu.peek();
            int val=qu.poll();
            for(int j:adj.get(val)){
                inorder[j]--;
                if(inorder[j]==0)qu.offer(j);
            }
        }
        if(i==n)return ans;
        return new int[0];
    }
    public void dfs(boolean[] vis,int i,Stack<Integer> st){
        vis[i]=true;
        for(int val:adj.get(i)){
            if(!vis[val]){
                dfs(vis,val,st);
            }
        }
        st.push(i);
    }
}