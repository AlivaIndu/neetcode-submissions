class Solution {
    public int timeTaken(int x,int[] piles){
        int time=0;
        for(int p:piles){
            time += (int)Math.ceil((double)p/x);
        }
        return time;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int p:piles)
            maxPile = Math.max(maxPile,p);

        int l=1,u=maxPile;
        while(l<u){
            int mid = l+(u-l)/2;
            if(timeTaken(mid,piles)>h){
                l=mid+1;
            }
            else if(timeTaken(mid,piles)<=h){
                u=mid;
            }
        }
        return u;
    }
}
