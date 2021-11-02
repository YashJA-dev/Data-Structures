class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int odd=0,even=0;
        int[] arr=nums.clone();
        for(int i=0;i<nums.length;i++){
            if(((i%2)!=0)&&nums[i-1]>=nums[i]){
                int val=nums[i-1]-(nums[i]-1);
                nums[i-1]=(nums[i]-1);
                odd+=val;
            }
            if(((i%2)!=0)&&(i+1)<nums.length&&nums[i+1]>=nums[i]){
                int val=nums[i+1]-(nums[i]-1);
                nums[i+1]=(nums[i]-1);
                odd+=val;
            }
        }
        nums=arr.clone();
        // System.out.println(Arrays.toString(nums));

        for(int i=0;i<nums.length;i++){
            if(i==0){
                if(i+1<nums.length&&nums[i+1]>=nums[i]){
                    int val=nums[i+1]-(nums[i]-1);
                    nums[i+1]=(nums[i]-1);
                    even+=val;
                }else{
                    continue;
                }
            }else if(i==nums.length-1){
                if((i%2==0)&&nums[i-1]>=nums[i]){
                    int val=nums[i-1]-(nums[i]-1);
                    nums[i-1]=(nums[i]-1);
                    even+=val;
                }else{
                    continue;
                }
            }else if((i%2==0)){
                if(nums[i-1]>=nums[i]){
                    int val=nums[i-1]-(nums[i]-1);
                    nums[i-1]=(nums[i]-1);
                    even+=val;
                }if(nums[i+1]>=nums[i]){
               
                    int val=nums[i+1]-(nums[i]-1);
                    nums[i+1]=(nums[i]-1);
                    even+=val;
                    
               }
            }
            System.out.println(Arrays.toString(nums)+" "+even);
        }
        System.out.println(even+" "+odd);
        return Math.min(even,odd);
    }
}