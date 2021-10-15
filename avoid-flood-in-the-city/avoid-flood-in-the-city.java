class Solution {
  public int[] avoidFlood(int[] nums) {
        TreeSet<Integer> set=new TreeSet<>();
        Map<Integer,Integer> map=new HashMap<>();
        int c=0;
        int[] ans=new int[nums.length];
        Arrays.fill(ans,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0&&map.size()==0){
                ans[i]=1;
                continue;
            }else if(nums[i]==0)set.add(i);
            else if(map.containsKey(nums[i])){
                if(set.size()>0){
                    Integer floor=set.ceiling((Integer)map.get(nums[i]));
                    if(floor==null)return new int[0];
                    set.remove(floor);
                    ans[floor]=nums[i];
                    map.remove(nums[i]);
                    map.put(nums[i],i);
                }else{
                    return new int[0];
                }
            }else{
                map.put(nums[i],i);
            }
        }
        for(int k:set){
            ans[k]=1;
        }
        return ans;
    }
}
