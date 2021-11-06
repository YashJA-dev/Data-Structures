class Solution {
    int mod=(1000000007);
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> li=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum=(sum+nums[j])%mod;
                li.add(sum);
            }
        }
        Collections.sort(li);
        int sum=0;
         for(int i=left-1;i<right;i++){
                sum=(sum+li.get(i))%mod;
        }
        return sum;
    }
}