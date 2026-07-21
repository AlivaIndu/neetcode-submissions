class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1,n=nums.length;

        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int pivot = l;

        if(target>nums[n-1]){
            return binarySearch(nums,target,0,pivot-1);
        }else
            return binarySearch(nums,target,pivot,n-1);
    }

    public int binarySearch(int[] nums, int t,int l,int r){
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==t) return mid;
            else if(nums[mid]<t) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }
}
