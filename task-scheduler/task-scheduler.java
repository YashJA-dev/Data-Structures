class Solution {
           public int leastInterval(char[] nums, int n) {
        Map<Character,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(char c:nums)map.put(c,map.getOrDefault(c,0)+1);
        for(Map.Entry entry:map.entrySet()){
            pq.add((int)entry.getValue());
        }

        int c=0;
        while(!pq.isEmpty()){
            PriorityQueue<Integer> temp=new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0;i<=n;i++){
                if(!pq.isEmpty()){
                    int val=pq.poll();
                    System.out.println(val);
                    if(val!=1)temp.add(val-1);
                    c++;
                }else if(pq.size()!=0||temp.size()!=0) c++;
            }
            pq.addAll(temp);
        }
        return c;
    }
   class Pair{
        int key;
       int val;
       Pair(int key,int val){
           this.key=key;
           this.val=val;
       }
    }
    class Compair implements Comparator<Pair>{
        public int compare(Pair p1,Pair p2){
            if(p1.key>p2.key)return 1;
            else if(p1.key<p2.key)return -1;
            return 0;
        }
    }
}