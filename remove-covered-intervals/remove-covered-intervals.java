class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,new Compare());
        int j=0;
        for(int[] i:intervals)System.out.println(Arrays.toString(i)+" "+j++);
        int n=intervals.length,c=0;
        for(int i=0;i<intervals.length;i++){
            int l=i;
            while(((i+1)<n)&&(intervals[l][1]>=intervals[i+1][1])){
                c++;
                i++;
            }
        }
        return n-c;
    }
    class Compare implements Comparator<int[]>{
        public int compare(int[] p1,int[] p2){
            if(p1[0]>p2[0]){
                return 1;
            }else if(p1[0]<p2[0]){
                return -1;
            }else{
                if(p1[1]>p2[1])return -1;
                else return 1;
            }
        }
    }
}


    