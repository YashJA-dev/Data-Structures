class Solution {
    public int maxFreq(String s, int maxchar, int minsize, int maxSize) {
        Map<Character,Integer> map=new HashMap<>();
        Map<String,Integer> substring=new HashMap<>();
        int l=0,r=0;
        while(r<s.length()){
            char ch=s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while((r-l+1)>minsize){
                ch=s.charAt(l);
                map.put(ch,map.getOrDefault(ch,0)-1);
                if(map.get(ch)==0)map.remove(ch);
                l++;
            }
            if(map.size()<=maxchar&&(r-l+1)==minsize){
                System.out.println(s.substring(l,r));
                substring.put(s.substring(l,r+1),substring.getOrDefault(s.substring(l,r+1),0)+1);
            }
            r++;
        }
       int ans=0;
        return (substring.size()==0)?0:(Collections.max(substring.values()));
    }
}