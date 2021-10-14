class Solution {
    public int[][] diagonalSort(int[][] nums) {
        int[] count=new int[101];
        int m=nums.length,n=nums[0].length;
        for(int i=m-1;i>=0;i--){
            int tm=i;
            for(int j=0;j<n&&tm<m;j++){
                count[nums[tm][j]]++;
                tm++;
            }
            tm=i;
            int j=0;
            for(int k=0;k<count.length;k++){
                while(count[k]!=0){
                    nums[tm][j]=k;
                    count[k]--;
                    tm++;
                    j++;
                }
            }

        }
        for(int i=1;i<n;i++){
            int tm=0;
            for (int j=i; j<n&&tm<m ; j++) {
                count[nums[tm][j]]++;
                tm++;
            }
            int j=i;
            tm=0;
            for(int k=0;k<count.length;k++){
                while(count[k]!=0){
                    nums[tm][j]=k;
                    count[k]--;
                    tm++;
                    j++;
                }
            }
        }



        return nums;
    }
}