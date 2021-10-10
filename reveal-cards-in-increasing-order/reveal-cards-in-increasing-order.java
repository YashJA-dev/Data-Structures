class Solution {
    public int[] deckRevealedIncreasing(int[] nums) {
        Deque<Integer> de=new LinkedList<>();
        int [] desc=new int[nums.length];
        desc=nums.clone();
        Arrays.sort(desc);
        int i=desc.length-1;
        de.offerFirst(desc[i--]);
        while(de.size()!=desc.length){
            int t=de.pollLast();
            de.offerFirst(t);
            de.offerFirst(desc[i--]);        
        }
        i=0;
        while(!de.isEmpty()){
            desc[i++]=de.pollFirst();    
        }
        return desc;
    }
}