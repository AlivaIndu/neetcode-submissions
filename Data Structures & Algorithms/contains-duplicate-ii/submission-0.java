class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if(n==1) return false;

        Set<Integer> appeared = new HashSet<>();
        int i=0;
        for(int j=0;j<n;j++){
            while(j-i>k){
                appeared.remove(nums[i]);
                i++;
            }
            if(appeared.contains(nums[j]))
                return true;
            appeared.add(nums[j]);
        }
        return false;
    }
}