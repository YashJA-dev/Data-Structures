class Solution {
    public int minOperations(int[][] nums, int x) {
        List<Integer> li=new ArrayList<>();
        int prevmod=nums[0][0]%x;           
       for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
                if((nums[i][j]%x)!=prevmod){
                    return -1;
                }else{
                    prevmod=(nums[i][j]%x);
                    li.add(nums[i][j]/x);
                }
                
            }
        }
        Collections.sort(li);
        int to=li.get(li.size()/2);
        int ans=0;
        for(int i:li){
            ans+=Math.abs(to-i);
        }
        return ans;
    }
}
// 1
// 2
// 3
// 4