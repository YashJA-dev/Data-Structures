class Solution {

    public int minimumOperations(int[] nums, int started, int goal) {
        Queue<Pair> qu = new LinkedList<>();
        boolean[] vis = new boolean[10001];
        qu.offer(new Pair(started, 0));
        char[] arr = new char[] { '-', '+', '^' };
        int start = 0;
        Set<Integer> set = new HashSet<>();
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                Pair p = qu.poll();
                int val = p.val;
                int steps = p.steps;
                if (p.val == goal) return steps;
                if(val<0||val>1000||set.contains(val))continue;
                set.add(val);
                for (int j = 0; j < nums.length; j++) {
                    int sub = val - nums[j];
                    int add = val + nums[j];
                    int xor = val ^ nums[j];
                    if (!set.contains(sub)) qu.add(new Pair(sub, steps + 1));
                    if (!set.contains(add)) qu.add(new Pair(add, steps + 1));
                    if (!set.contains(xor)) qu.add(new Pair(xor, steps + 1));
                }
            }
        }
        return -1;
    }

    class Pair {
        int val;
        int steps;

        Pair(int val, int steps) {
            this.val = val;
            this.steps = steps;
        }
    }
}
