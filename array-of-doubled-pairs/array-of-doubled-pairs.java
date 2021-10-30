class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int size=arr.length;
        Map<Float,Integer> map=new HashMap<>();
        Arrays.sort(arr);
        for(int i:arr)map.put((float)i,map.getOrDefault((float)i,0)+1);
       for(Map.Entry entry:map.entrySet()){
            // if((int)!=0&&(float)!=0)return false;
           System.out.println(entry.getValue()+" "+entry.getKey());
        }
        for(int i=0;i<size;i++){
            float value=arr[i];
            if(value<0){
                if(map.get(value)!=0){
                    if(map.containsKey(value/2)&&map.get(value/2)>0){
                        map.put((value/2),map.get((value/2))-1);
                        map.put(value,map.get(value)-1);
                    }  
                }
            }else{
                System.out.println(value+" "+map.get(value));
                if(map.get(value)!=0){
                    if(map.containsKey(value*2)&&map.get(value*2)>0){
                        map.put(value*2,map.get(value*2)-1);
                        map.put(value,map.get(value)-1);
                    }   
                }
            }
            
        }
        for(Map.Entry entry:map.entrySet()){
            if((int)entry.getValue()!=0&&(float)entry.getKey()!=0)return false;
        }
        return true;
    }
}

