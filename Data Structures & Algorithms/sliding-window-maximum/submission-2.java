class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] res = new int[n - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);

        int i=0,j=0;
        while(j<n){
            pq.add(new int[]{nums[j],j});
            if(j-i+1==k){
                while(pq.peek()[1]<=j-k)
                    pq.poll();
                res[i]=pq.peek()[0];
                i++;
            }
            j++;
        }
        return res;
    }
}
