class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
     if(nums.length==0||k<=0)return false;
        TreeSet<Long> set=new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Long floor=set.floor(1L*nums[i]);
            Long ciel=set.ceiling(1L*nums[i]);
            if(floor!=null&&Math.abs(floor-nums[i])<=t)return true;
            if(ciel!=null&&Math.abs(ciel-nums[i])<=t)return true;
            set.add(1L*nums[i]);
            if(set.size()>k){
                set.remove(1L*nums[i-k]);
            }
        }
        return false;
    }
}