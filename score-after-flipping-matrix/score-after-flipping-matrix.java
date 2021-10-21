class Solution {
    public int matrixScore(int[][] nums) {
        int n=nums.length;
        int m=nums[0].length;
        for(int i=0;i<nums.length;i++){
            if(nums[i][0]==0){
                for(int j=0;j<m;j++){
                    nums[i][j]=nums[i][j]==0?1:0;
                }
            }
        }
        for(int i=1;i<m;i++){
            int ci=0;
            for(int j=0;j<n;j++){
                if(nums[j][i]==1)ci++;
            }
            // System.out.println("cin "+ci);
            if(ci<=(n/2)){
                for(int j=0;j<n;j++){
                    nums[j][i]=nums[j][i]==0?1:0;
                }    
            }
        }
        for(int[] ar:nums){
            System.out.println(Arrays.toString(ar));
        }
        int sum=0;
        for(int i=0;i<n;i++){
            int csum=0;
            int tempn=m-1;
            System.out.println(tempn+" n");
            for(int j=0;j<m;j++){
                csum+=(Math.pow(2,(tempn--)))*nums[i][j];
            }
            System.out.println(csum+" csum");
            sum+=csum;
        }
        return sum;
    }
}