class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res = new int[n - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int i=0,j=0;
        while(j<n){
            pq.add(nums[j]);
            if(j-i+1==k){
                res[i]=pq.peek();
                pq.remove(nums[i]);
                i++;
            }
            j++;
        }
        return res;
    }
}
