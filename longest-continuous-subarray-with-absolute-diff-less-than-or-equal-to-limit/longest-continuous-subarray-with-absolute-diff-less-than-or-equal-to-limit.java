class Solution {
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((p1, p2) -> p1.value - p2.value);
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> p2.value - p1.value);
        int s = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            minHeap.add(new Pair(i, nums[i]));
            maxHeap.add(new Pair(i, nums[i]));
            while(minHeap.isEmpty() == false && (Math.abs(nums[i] - minHeap.peek().value) > limit)) {
                Pair p = minHeap.poll();
                s = Math.max(s, p.index+1);
            }
            while(maxHeap.isEmpty() == false && (Math.abs(nums[i] - maxHeap.peek().value) > limit)) {
                Pair p = maxHeap.poll();
                s = Math.max(s, p.index+1);
            }
            max = Math.max(max, i - s + 1);
        }
        return max;
    }
    
    class Pair{
        int index, value;
        public Pair(int i, int v){
            index = i;
            value = v;
        }
    }
}