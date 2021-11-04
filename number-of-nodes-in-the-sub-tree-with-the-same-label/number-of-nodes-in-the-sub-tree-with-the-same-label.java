class Solution {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        int[] frequency = new int[n];
        List<List<Integer>> adjacent = new ArrayList<>();
        for (int i = 0; i < n; i++) adjacent.add(new LinkedList<>());
        for (int[] edge : edges) {
            adjacent.get(edge[0]).add(edge[1]);
            adjacent.get(edge[1]).add(edge[0]);
        }
        boolean visited[] = new boolean[n];
        DFSHelper(0, visited, labels, adjacent, frequency);
        return frequency;
    }

    public int[] DFSHelper(int v, boolean[] visited, String labels, List<List<Integer>> adjacent, int[] frequency) {
        visited[v] = true;
        int[] count = new int[26]; //cont of current call

        int index = labels.charAt(v) - 'a'; //get index of a ccharacter
        for(int val:adjacent.get(v)){
             if(!visited[val]){
                 int[] countings=DFSHelper(val,visited,labels,adjacent,frequency);
                 for(int i=0;i<26;i++){
                     count[i]+=countings[i];
                 }
             }   
        }
        count[index]++;
        frequency[v]=count[index];
        return count;
    }
}
