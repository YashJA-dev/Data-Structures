class Solution {
    public int numberOfWeakCharacters(int[][] nums) {
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                
                return a[0] - b[0];
                // return 0;
            }
        });
        int c=0;
        // TreeMap<Integer,Set<Integer>> map=new TreeMap<>();        
        int max=Integer.MIN_VALUE;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i][1]<max){
                c++;
            }
            max=Math.max(nums[i][1],max);
        }
        return c;
        
    }
    class Pair{
        int a;
        int b;
        Pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    
}
