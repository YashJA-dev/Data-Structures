class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
       int l=0,r=removable.length;
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(krishnJi_k_charan(removable,new StringBuilder(s),new StringBuilder(p),mid)){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return ans;
    }
    
    // simple check for subsequence
    public boolean krishnJi_k_charan(int[] nums,StringBuilder s,StringBuilder t,int k){
        for(int i=0;i<k;i++){
            s.setCharAt(nums[i],'?');
        }
        int j=0;
        for(int i=0;i<s.length();i++){
            if(j<t.length()&&s.charAt(i)==t.charAt(j)){
                j++;
            }
        }
        return j==t.length();
    }
}
