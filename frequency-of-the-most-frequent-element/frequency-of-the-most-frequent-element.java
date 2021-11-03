class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int sum=0;
        int max=0;
        int l=0;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            while((((r-l+1)*nums[r])-sum)>k){
                sum-=nums[l];
                l++;

            }
            max=Math.max((r-l+1),max);
        }
        return max;
    }
}
// K=2
// 4 4 8
//     4*2


