class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0;
        int sum=0,max=Integer.MAX_VALUE;
        while(r<nums.length){
            if(sum<target){
                sum+=nums[r];
                r++;
                if(sum>=target)max=Math.min(max,r-l);
            }else{
                max=Math.min(max,r-l);
                sum-=nums[l++];
            }
        }
        while(sum>=target){
            max=Math.min(max,r-l);
                sum-=nums[l++];
            
        }
                          
        return max==Integer.MAX_VALUE?0:max;
    }
}