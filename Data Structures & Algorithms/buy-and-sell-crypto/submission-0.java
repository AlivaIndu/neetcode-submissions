class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        if(n==2) return (prices[1]-prices[0]>0?prices[1]-prices[0]:0);

        int maxProfit=0;
        int i=0;
        for(int j=1;j<n;j++){
            if(prices[j]-prices[i]>0)
                maxProfit=Math.max(maxProfit,prices[j]-prices[i]);
            else{
                while(i<=j && prices[j]-prices[i]<0)
                i++;
            }
        }
        return maxProfit;
    }
}
