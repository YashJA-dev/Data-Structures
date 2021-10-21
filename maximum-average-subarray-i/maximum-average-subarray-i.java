class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l=0,r=0;
        double sum=0;
        double avg=(double)-10e20;
        // if(nums.length==1)return (double)0;
        while(r<nums.length){
            sum+=nums[r];
            if((r-l+1)>k){
                sum-=nums[l];
                l++;
            }
            if((r-l+1)==k){
                avg=Math.max(avg,sum/k);
            }
            r++;
        }
        return avg;
        
    }
}