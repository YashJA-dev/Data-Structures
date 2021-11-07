class Solution {
 public int numMatchingSubseq(String st, String[] words) {
        HashMap<Character,List<Integer>> map=new HashMap<>();
        for(int i=0;i<st.length();i++){
            char ch=st.charAt(i);
            if(map.containsKey(ch)){
                List<Integer> li=map.get(ch);
                li.add(i);
                map.put(ch,li);
            }else{
                List<Integer> li=new ArrayList<>();
                li.add(i);
                map.put(ch,li);
            }
        }
        int c=0;
        for(String s:words){
            int n=s.length(),i=0;
            Map<Character,Integer> count=new HashMap<>();
                int pre=0;
            for(i=0;i<n;i++){
                char ch=s.charAt(i);
                if(!count.containsKey(ch))count.put(ch,0);
                if(map.containsKey(ch)){
                    List<Integer> li=map.get(ch);
                    int ind=count.get(ch);
                    System.out.println(ind+" "+li.size()+" "+ch+" ");
                    if(li.size()>ind){
                        int ind_li=li.get(ind);
                        ind++;
                        while(pre>ind_li&&li.size()>ind){
                            ind_li=li.get(ind++);
                        }
                        System.out.println(ind_li);
                        if(li.size()>=ind&&pre>ind_li){
                            i--;
                            break;
                        }
                        pre=ind_li;
                        count.put(ch,ind);
                    }else{
                        i--;
                        break;
                    }
                }else{
                    i--;
                    break;
                }
            }
            if(i==n)c++;
        }
        return c;
    }
  
}