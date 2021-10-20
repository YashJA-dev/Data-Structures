class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String,Integer> m = new HashMap<>();
        int ss = 0 ;
        int ee = 0;
        Map<Character,Integer> cnt = new HashMap<>();

        while( ee < s.length())
        {
            Character cur =s.charAt(ee);
            cnt.put(cur,cnt.getOrDefault(cur,0)+1);
             while( ee-ss+1 > minSize  )
             {
                 Character c =s.charAt(ss);
                 if(cnt.get(c)==1)
                     cnt.remove(c);
                 else
                     cnt.put(c,cnt.get(c)-1);
                 ss++;
             }
             if(cnt.size()<=maxLetters &&ee-ss+1==minSize )
                m.put(s.substring(ss,ee+1),m.getOrDefault(s.substring(ss,ee+1),0)+1);
             ee++;
        }
        int ans  = 0 ;
        for( int it : m.values())
            ans= Math.max(ans,it);
        return ans;
    }
}