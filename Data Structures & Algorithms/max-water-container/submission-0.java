class Solution {
    public int maxArea(int[] heights) {
        int n=heights.length;
        int max = 0;
        int left = 0,right=n-1;

        while(left<right){
            int amt = Math.min(heights[left],heights[right])*(right-left);
            max = Math.max(max,amt);

            if(heights[left]>heights[right])
                right--;
            else 
                left++;
        }
        return max;
    }
}
