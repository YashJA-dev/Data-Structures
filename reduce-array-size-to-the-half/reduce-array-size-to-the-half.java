class Solution {
    public int minSetSize(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums)map.put(i,map.getOrDefault(i,0)+1);
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry entry:map.entrySet()){
            pq.add((int)entry.getValue());
        }
        int sum=0;
        int c=0;
        int n=nums.length/2;
        while(sum<n){
            sum+=pq.poll();
            c++;
        }
        return c;
    }
}