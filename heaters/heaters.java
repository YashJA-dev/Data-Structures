class Solution {
    public int findRadius(int[] hous, int[] heat) {
        Arrays.sort(hous); 
        Arrays.sort(heat);
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<heat.length;i++){
            set.add(heat[i]);
        }
        int max=0;
        // max=ciel(hous,0);
        for(int i=0;i<hous.length;i++){
            int floor=floor(heat,hous[i]);
            int ciel=ciel(heat,hous[i]);
            System.out.println(floor+" "+ciel);
            if(floor==-1)max=Math.max(max,Math.abs(hous[i]-ciel));
            else if(ciel==-1)max=Math.max(max,Math.abs(hous[i]-floor));
            else{
                max=Math.max(max,Math.min(Math.abs(hous[i]-floor),Math.abs(hous[i]-ciel)));
            }
        }
        return max;
    }
    public int ciel(int[] nums,int val){
        int l=0,r=nums.length-1;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if((nums[mid])<val){
                l=mid+1;
            }else{
                ans=nums[mid];
                r=mid-1;
            }
        }
        return ans;
    }
    public int floor(int[] nums,int val){
        int l=0,r=nums.length-1;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            // System.out.println(nums[mid]+" "+val);
            if((nums[mid])>val){
                r=mid-1;
            }else{
                ans=nums[mid];
                l=mid+1;
            }
        }
        return ans;
    }
}