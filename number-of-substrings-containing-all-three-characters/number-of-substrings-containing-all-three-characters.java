class Solution {
    public int numberOfSubstrings(String s) {
        int l=0,r=0,n=s.length();
        Map<Character,Integer> map=new HashMap<>();
        int c=0;
        while(r<n){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.size()==3){
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)-1);
                if(map.get(s.charAt(l))==0)map.remove(s.charAt(l));
                c+=n-r;
                System.out.println(c);
                l++;
            }
            r++;
        }
        return c;
    }
//     public int atMostK(Map<Character,Integer> map,Set<Character> set,String s){
//         int l=0,r=0,n=s.length();
//         while(r<n){
//            char ch=s.charAt(r);
                  
//         }
//     }
}