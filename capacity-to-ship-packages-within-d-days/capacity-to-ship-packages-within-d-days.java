class Solution {
    public int shipWithinDays(int[] nums, int days) {
        int l=1;
        int r=0;
        
        for(int i:nums){
            r+=i;
            l=Math.max(l,i);
        }
        int ans=r;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(vishnuJi_canShip_sath(nums,days,mid)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    public boolean vishnuJi_canShip_sath(int[] nums,int days,int val){
        int c=1;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]>val){
                sum=nums[i];
                c++;
            }else{
                sum+=nums[i];
            }
        }
        return c<=days;
    }
}