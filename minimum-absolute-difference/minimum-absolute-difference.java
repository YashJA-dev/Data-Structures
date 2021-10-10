class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> li=new ArrayList<>();
        int temp=nums[nums.length-1]-nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]<temp){
                temp=nums[i]-nums[i-1];
                li.removeAll(li);
                List<Integer> t=new ArrayList<>();
                t.add(nums[i-1]);
                t.add(nums[i]);
                li.add(t);
            }else if(nums[i]-nums[i-1]==temp){
                List<Integer> t=new ArrayList<>();
                t.add(nums[i-1]);
                t.add(nums[i]);
                li.add(t);                 
            }
        }
        return li;
    }
}
// -14 -10 -4 3 8 19 23 27
    