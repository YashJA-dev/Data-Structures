class Solution {
     public int minDays(int[] nums, int m, int k) {
        long l=1,r=0;
        for(int i=0;i<nums.length;i++){
            r=Math.max(r,nums[i]);
        }
        long ans=-1;
        while(l<=r){
            long mid=(l+(r-l)/2);
            if(canFormAtPerticularDate(nums,(int)mid,k,m)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
         System.out.println(r);
        // if(ans==-1&&canFormAtPerticularDate(nums,(int) r,k,m)){
        //     return (int)r;
        // }
        return (int)ans;
    }
    //m=no of buket
    //k=no of flowers
    public boolean canFormAtPerticularDate(int[] nums,int days,int flower,int bucket){
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=days){
                c++;
            }else{
                c=0;
            }
            if(c==flower){
                bucket--;
                c=0;
            }
        }
        return bucket<=0;
    }
}
