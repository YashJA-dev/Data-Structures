class Solution {
    int mod=((int)1e9)+7;
    public int countHomogenous(String s) {
        int l=0,r=0,ct=0,n=s.length();
        Map<Character,Integer> map=new HashMap<>();
        while(r<n){
            char c=s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);
            while(map.size()>1){
                char tm=s.charAt(l);
                map.put(tm,map.get(tm)-1);
                if(map.get(tm)==0)map.remove(tm);
                l++;
            }
            ct=(ct+(r-l+1))%mod;
            r++;
        }
        return ct;
    }
}