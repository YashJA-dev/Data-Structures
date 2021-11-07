class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int atk=countAtMost(new HashMap<>(),nums,k);        
        int atkone=countAtMost(new HashMap<>(),nums,k-1);
        return atk-atkone;
    }
    public int countAtMost(Map<Integer,Integer> map,int[] nums,int k){
        int l=0,r=0,n=nums.length,c=0;
        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()>k){
                map.put(nums[l],map.getOrDefault(nums[l],0)-1);
                if(map.get(nums[l])==0)map.remove(nums[l]);
                l++;
            }
            c+=r-l+1;
            r++;
        }
        return c;
    }
}
    
    