class Solution {
    public boolean isSubsequence(String s, String t) {
     int[] ans=new int[t.length()];
        if(s.length()>t.length())return false;
         return chk(ans,t,s);   
    }
      public boolean chk(int[] remo,String s,String p){
       int j=0;
        if(p.equals(""))return true;
        if(s.equals(""))return false;

          for(int i=0;i<s.length();i++){
            if(remo[i]>0)continue;
            if(j<p.length()&&s.charAt(i)==p.charAt(j))j++;
        }
          System.out.println(j);
        return (j==p.length());
    }
}