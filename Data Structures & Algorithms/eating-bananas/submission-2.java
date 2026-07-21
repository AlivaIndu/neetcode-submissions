class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0;
        for(int p:piles){
            high = Math.max(high,p);
        }

        int res = high;
        int low=1;
        while(low<=high){
            int mid = (high+low)/2;

            int total=0;
            for(int p:piles){
                total += Math.ceil((double)p/mid);
            }

            if(total>h) low = mid+1; 
            else if(total<=h){
                res = mid;
                high = mid-1;
            } 

        }

        return res;

    }
}
