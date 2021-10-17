class Solution {
    public int minStoneSum(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums)pq.add(i);
        while(k--!=0){
            float a=pq.poll();
            pq.add((int)Math.ceil(a/2));
        }
        int sum=0;
        while(!pq.isEmpty()){
            sum+=pq.poll();
        }
        return sum;
    }
}
