class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            if(nums[i]>0) break;

            int left=i+1;
            int right=n-1;
            int target = 0-nums[i];
            while(left<right){
                if(nums[left]+nums[right]>target)
                    right--;
                else if(nums[left]+nums[right]<target)
                    left++;
                else{
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;

                    while(left<right && nums[left]==nums[left-1]) left++;
                    while(right>left && nums[right]==nums[right+1]) right--;
                }
            }
        }
        return res;
    }
}
