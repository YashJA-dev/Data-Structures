class Solution {
    public int splitArray(int[] nums, int m) {
        int l=0;
        int r=0;
        for(int i=0;i<nums.length;i++){
            l=Math.max(l,nums[i]);
            r+=nums[i];
        }
        int min=r;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(maxDivisions(nums,mid,m)>m){
                l=mid+1;
            }else{
                min=mid;
                r=mid-1;
            }
        }
        return min;
    }
    private int maxDivisions(int[]nums, int mid,int m){
        int sum=0;
        int c=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>mid)return nums[i];
            if(sum+nums[i]>mid){
                c++;
                sum=nums[i];
            }else{
                sum+=nums[i];
            }
        }
        return c;
    }
}