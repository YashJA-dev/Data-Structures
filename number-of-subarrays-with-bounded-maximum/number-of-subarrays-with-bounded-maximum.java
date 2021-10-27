class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int l=0,r=0,n=nums.length;
        int prev=0,c=0;
        while(r<n){
            if(nums[r]<=right&&nums[r]>=left){
                prev=r-l+1;
                c+=prev;
            }else if(nums[r]<left){
                c+=prev;                
            }else{
                prev=0;
                l=r+1;
            }
            r++;
        }
        return c;
    }
}