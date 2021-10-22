class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int n=matrix.length,m=matrix[0].length,c=0;
        int min=(int)10e9;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum+=Math.abs(matrix[i][j]);
                if(matrix[i][j]<=0){
                    c++;
                }
                    min=Math.min(Math.abs(matrix[i][j]),min);                
            }
        }
        if((c&1)==0){
            return sum;
        }
        return sum-(2*min);
    }
}
// [2,9, 3]
// [5,4,-4]
// [1,7, 1]