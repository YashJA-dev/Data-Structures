class Solution {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int[] pre=new int[n];
        int max=0;
        for(int i=nums.length-1;i>=0;i--){
            max=Math.max(nums[i],max);
            pre[i]=max;;
        }
        max=0;
        for(int i=0;i<n;i++){
            int ans=pre[i]-nums[i];
            max=Math.max(ans,max);
        }
        return max==0?-1:max;
    }
}