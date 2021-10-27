class Solution {
    public int findMin(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=(l+r)/2;
            System.out.println("mid"+mid);
            if(nums[mid]>nums[r]){
                System.out.println(nums[mid]+" "+nums[r]);
                l=mid+1;
                System.out.println(l+" "+r);
            }else{
                r=mid;
            }
        }
        return nums[r];
    }
}