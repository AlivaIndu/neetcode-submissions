class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int sum=0;
        int i=0;
        for(int j=0;j<n;j++){
            sum+=nums[j];
            while(i<=j && sum>=target){
                minLen = Math.min(minLen,j-i+1);
                sum-=nums[i];
                i++;
            }
        }
        return (minLen == Integer.MAX_VALUE?0:minLen);
    }
}