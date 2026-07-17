class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        Stack<int[]> st = new Stack<>();
        int[] ans = new int[n];

        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                ans[i]=0;
            }else{
                while(!st.isEmpty() && st.peek()[0]<=temperatures[i])
                    st.pop();
                if(st.isEmpty())
                    ans[i]=0;
                else
                    ans[i] = st.peek()[1]-i;
            }
            st.push(new int[]{temperatures[i],i});
        }
        return ans;
    }
}
