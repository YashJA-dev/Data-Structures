class Solution {
public int findPairs(int[] nums, int k) {

    int c=0;
    
    Map<Integer,Integer>hs=new HashMap<>();
    
    for(int i=0;i<nums.length;i++)
    {
        
    if(hs.containsKey(nums[i]))
      {
          int x=hs.get(nums[i]);
          hs.put(nums[i],x+1);
      }
    else
    {
       hs.put(nums[i],1);
    }
        
    }
    


    if(k==0)
    {
      for(Map.Entry<Integer,Integer>entry:hs.entrySet())
      {
          if(entry.getValue()>1)
              c++;
      }
    }
  else{
    for(Map.Entry<Integer,Integer> entry:hs.entrySet())
    {
      //  if(nums.contains(entry.getKey()+k))
        //    c++;
        if(hs.containsKey(entry.getKey()+k))
            c++;
    }
  }
    return c;
}
}