class Solution {
    public int numRabbits(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int c=0;
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])&&map.get(nums[i])!=nums[i]+1){
                System.out.println(1);
                map.put(nums[i],map.get(nums[i])+1);
            }else if(!map.containsKey(nums[i])){
                System.out.println(2);
                map.put(nums[i],1);
            }else if(map.containsKey(nums[i])&&map.get(nums[i])==nums[i]+1){
                c+=nums[i]+1;
                System.out.println(3);

                map.remove(nums[i]);
                 map.put(nums[i],1);
            }
        }
        for(Map.Entry entery:map.entrySet()){
            c+=(int)entery.getKey()+1;
        }
        return c;
    }
}