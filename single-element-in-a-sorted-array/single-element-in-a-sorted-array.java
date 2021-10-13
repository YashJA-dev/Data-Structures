class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l=0,r=nums.length-1;
        if(nums.length==1)return nums[0];
        while(l<=r){
            int mid=l+(r-l)/2;
            int prabhu=vishnuJimerepyarecharano_mai_aapke_maaf_karDo_aapka_mai_pls(nums,nums[mid]);
            System.out.println(nums[mid]+" "+prabhu);
            if(prabhu!=nums.length-1&&nums[prabhu]==nums[prabhu+1]){
                if(prabhu%2==0){
                    l=prabhu+2;
                }else{
                    r=prabhu-1;
                }
            }else{
                return nums[prabhu];
            }
        }
        return -1;
    }
    public int vishnuJimerepyarecharano_mai_aapke_maaf_karDo_aapka_mai_pls(int[] nums,int val){
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=(l+r)/2;
            if(nums[mid]>=val){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        return l;
    }
}
// 1,1,2,3,3,4,4,8,8