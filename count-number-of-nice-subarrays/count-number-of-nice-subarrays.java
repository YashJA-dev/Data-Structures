class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            int val=nums[i]%2;
            nums[i]=val;
        }
        System.out.println(Arrays.toString(nums));
        int l=0,r=0,sum=0,c=0;
        
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                c+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return c;
    }
}