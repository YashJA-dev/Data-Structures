class Solution {
    List<List<Node>> adj = new ArrayList<>();

    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new Node(times[i][1], times[i][2]));
        }
        int[] ans = new int[n + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[k] = 0;
        pq.offer(new Node(k,0));
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int value = node.val;
            int weight = node.weight;
            for (Node val : adj.get(value)) {
                System.out.println(val.val+" "+val.weight);
                if (val.weight + weight < ans[val.val]) {
                    ans[val.val] = val.weight + weight;
                    pq.offer(new Node(val.val,ans[val.val]));
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<ans.length;i++){
            if(ans[i]==Integer.MAX_VALUE)return -1;
            max=Math.max(max,ans[i]);
        }
        return max;
    }

    public void dfs(List<List<Node>> adj, int i) {}

    class Node {
        int val;
        int weight;

        Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }
    }

    class Compare implements Comparator<Node> {

        public int compare(Node p1, Node p2) {
            if (p1.weight < p2.weight) return 1; 
            else if (p1.weight > p2.weight) return -1;
            return 0;
        }
    }
}
