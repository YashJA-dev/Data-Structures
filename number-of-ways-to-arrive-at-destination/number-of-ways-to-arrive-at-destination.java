class Solution2 {
    List<List<Node>> adj = new ArrayList<>();
    int mod = 1000000007;

    public int countPaths(int n, int[][] roads) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Compare());
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        // for(int[] arr:roads){
        //     Arrays.sort(arr,0,2);
        // }
        for (int i = 0; i < roads.length; i++) {
            Node left = new Node(roads[i][0], roads[i][2]);
            Node right = new Node(roads[i][1], roads[i][2]);
            adj.get(roads[i][0]).add(right);
            adj.get(roads[i][1]).add(left);
        }
        Arrays.fill(ans, Integer.MAX_VALUE);
        int[] freq = new int[n];
        ans[0] = 0;
        freq[0] = 1;
        pq.add(new Node(0, 0));
        while (!pq.isEmpty()) {
            Node p = pq.poll();
            for (Node node : adj.get(p.val)) {
                if ((node.weight + p.weight) < ans[node.val]) {
                    ans[node.val] = (node.weight + p.weight) % mod;
                    pq.add(new Node(node.val, ans[node.val]));
                    freq[node.val] = freq[p.val];
                } else if ((node.weight + p.weight) == ans[node.val]) {
                    freq[node.val] = ((freq[node.val]) + (freq[p.val])) % mod;
                    // count[v]= count[u]%MOD+count[v]%MOD;
                }
            }
        }
        System.out.println(Arrays.toString(freq));
        System.out.println(Arrays.toString(ans));
        for (int i = 0; i < n; i++) if (ans[i] == Integer.MAX_VALUE) return -1;
        return freq[n - 1];
    }

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
            if (p1.weight > p2.weight) return 1; else if (p1.weight < p2.weight) return -1; else return 0;
        }
    }
}

class Solution {

    class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // creating adjacency list from edge list
        for (int[] road : roads) {
            adjList.get(road[0]).add(new Pair(road[1], road[2]));
            adjList.get(road[1]).add(new Pair(road[0], road[2]));
        }

        int[] ways = new int[n]; // ways[i] states number of ways to reach the node i
        int[] minDistance = new int[n]; // minDistance[i] states min distance required to reach the node i
        Arrays.fill(minDistance, Integer.MAX_VALUE);

        // Pair will store the node and minDistance required to reach the node
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        // node which requires less distance to reach will be on top
        // by doing this, number of operations required to do reduces

        ways[0] = 1;
        minDistance[0] = 0;
        pq.add(new Pair(0, 0)); // 0th node requires 0 distance to reach
        int MOD = 1000000007;

        while (!pq.isEmpty()) {
            Pair p = pq.remove();
            int node = p.node;
            int dist = p.weight;

            for (Pair adj : adjList.get(node)) {
                int adjNode = adj.node;
                int wt = adj.weight;

                if (dist + wt < minDistance[adjNode]) {
                    // got a path which requires less distance to reach the node adjNode

                    minDistance[adjNode] = dist + wt;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(adjNode, minDistance[adjNode]));
                } else if (dist + wt == minDistance[adjNode]) {
                    // got another path which also requires same old minDistance

                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}
