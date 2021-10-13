class Solution {
    public boolean mergeTriplets(int[][] nums, int[] t) {
        int c=0;
        // int[][] arr=new int[nums.length][3];
        // for(int i=0;i<nums.length;i++){
        //     if((nums[i][0]==t[0])||(nums[i][1]==t[1])||(nums[i][2]==t[2])){
        //         System.out.println(Arrays.toString(nums[i]));
        //     }
        // }
        boolean[] see=new boolean[3];
        Arrays.fill(see,true);
        for(int i=0;i<nums.length;i++){
            if((nums[i][0]==t[0]||nums[i][1]==t[1]||nums[i][2]==t[2])&&
              nums[i][0]<=t[0]&&nums[i][1]<=t[1]&&nums[i][2]<=t[2]){
                if(nums[i][0]==t[0]&&nums[i][1]==t[1]&&nums[i][2]==t[2])return true;
                else if((nums[i][0]==t[0]&&nums[i][1]==t[1])&&see[0]&&see[1]){
                    c+=2;
                    see[0]=false;
                    see[1]=false;
                }else if(nums[i][1]==t[1]&&nums[i][2]==t[2]&&see[1]&&see[2]){
                    c+=2;
                    see[1]=false;
                    see[2]=false;
                }else if(nums[i][0]==t[0]&&nums[i][2]==t[2]&&see[0]&&see[2]){
                    c+=2;
                    see[0]=false;
                    see[2]=false;
                }else if((nums[i][0]==t[0])&&see[0]){
                    see[0]=false;
                    c++;
                }else if(nums[i][1]==t[1]&&see[1]){
                       System.out.println(c+" in");
                    see[1]=false;
                    c++;
                }else if(nums[i][2]==t[2]&&see[2]){
                    c++;
                    see[2]=false;
                }
            }
            System.out.println(c+" "+see[0]+" "+see[1]+" "+see[2] );
            if(c>=3)return true;
        }
        return c>=3;
    }
}