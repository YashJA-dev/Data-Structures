class Solution {
    public int maxArea(int[] height) {
        int l=0,r=height.length-1;
        int max=0;
        while(l<r){
            int area=((r-l)*Math.min(height[l],height[r]));
            System.out.println(area);
            max=Math.max(area,max);
            if(height[r]>=height[l]){
                l++;      
            }else{
                r--;
            }
        }
        return max;
    }
}