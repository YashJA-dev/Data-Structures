class Solution {

    public int countVowelSubstrings(String s) {
        int count = 0;
        // Vishnu JI k charan
        // Yash Ishu
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        int at5=findAtMost(s,5,set,map);
        map.clear();
        int at4=findAtMost(s,4,set,map);
        return at5-at4;
    }
    public int findAtMost(String s,int k,Set<Character> set,Map<Character, Integer> map){
        int i=0,j=0,n=s.length();
        int c=0;
        while(j<n){
            char ch=s.charAt(j);
            if(!set.contains(ch)){
                map.clear();
                j++;
                i=j;
                continue;
            }
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.size()>k){
                char car=s.charAt(i);
                map.put(car,map.get(car)-1);
                if(map.get(car)==0)map.remove(car);
                i++;
            }
           
            c+=j-i+1;
            j++;
        }
        System.out.println(c);
        return c;
    }
}
