class Solution {
    public int hIndex(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length&&(nums.length-i)>nums[i]){
            i++;
        }
        return nums.length-i;
    }
    public int findLeftMost(int[] nums,int val){
        int l=0,r=nums.length;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]>=val){
                r=mid;
            }else if(nums[mid]<val){
                l=mid+1;
            }
        }
        return l;
    }
}