class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums,new Compare());
        return nums[nums.length-k];
    }
    class Compare implements Comparator<String>{
        public int compare(String p1,String p2){
             if(p1.length()<p2.length())
                 return -1;
            else if(p1.length()>p2.length()) return 1;
            int i=0,j=0;
            while(i<p1.length()&&j<p2.length()){
                int p=Integer.valueOf(String.valueOf(p1.charAt(i)));
                int q=Integer.valueOf(String.valueOf(p2.charAt(j)));
                if(p>q)return 1;
                else if(p<q)return -1;
                i++;
                j++;
            }
            return 0;
        }
    }
}