class Solution {
    Map<Integer,Integer> map=new HashMap<>();
    public int maximumUniqueSubarray(int[] nums) {
        int l=0,r=0,n=nums.length;
        int sum=0;
        int max=0;
        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            sum+=nums[r];
            // System.out.println(r+" "+l+" sum "+(r-l+1));
            while(map.size()<r-l+1){
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l])==0)map.remove(nums[l]);
                sum-=nums[l];
                l++;
            }
            if(map.size()==r-l+1){
                max=Math.max(max,sum);
            }
            r++;
        }
        return max;
    }
}
// 5 2 1