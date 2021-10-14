class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l=1,r=1000000000;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(canMove(dist,hour,mid)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    private boolean canMove(int[] nums,double time,int speed){
        double val=0;
        for(int i=0;i<nums.length;i++){
            if(i!=nums.length-1){
                val+=Math.ceil((double)nums[i]/(double)speed);                
            }else{
                val+=(double)nums[i]/(double)speed;
            }
        }
        return val<=time;
    }
}
