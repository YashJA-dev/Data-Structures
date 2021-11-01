class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] trusted=new int[N+1];
        for(int[] ar:trust){
            trusted[ar[0]]--;
            trusted[ar[1]]++;
        }
        for(int i=1;i<trusted.length;i++){
            if(trusted[i]==N-1)return i;
        }
        return -1;
    }
}