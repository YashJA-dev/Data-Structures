class Solution {
   int m=0;
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        m=arr[(arr.length-1)/2];
        Integer[] sorted=new Integer[arr.length];
        for(int i=0;i<arr.length;i++)sorted[i]=arr[i];
                Arrays.sort(sorted, new Comparator<Integer>() {
                    public int compare(Integer p1, Integer p2) {
                        if(Math.abs(p1-m)>Math.abs(p2-m))return -1;
                        else if(Math.abs(p1-m)<Math.abs(p2-m)) return 1;
                        else{
                            if(p1>p2){
                                return -1;
                            }else{
                                return 1;
                            }
                        }
                    }
                });
        System.out.println(Arrays.toString(sorted));
        int[] ans=new int[k];
        for(int i=0;i<k;i++)ans[i]=sorted[i];
        return ans;
    }
    class Compare implements Comparator<Integer>{
        public int compare(Integer p1,Integer p2){
            if(Math.abs(p1-m)>Math.abs(p2-m))return -1;
            else if(Math.abs(p1-m)<Math.abs(p2-m)) return 1;
            else{
                if(p1>p2){
                    return -1;
                }else{
                    return 1;
                }
                // return 0;
            }
        }
    }
}
// |arr[i] - m| > |arr[j] - m|
    
    
// |arr[i] - m| == |arr[j] - m|
    
//  arr[i] is said to be stronger than arr[j] if arr[i] > arr[j].