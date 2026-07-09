class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int a:asteroids){
            boolean destroyed = false;
            if(st.isEmpty() || a>0)
                st.push(a);
            else{
                while(!st.isEmpty() && st.peek()>0 && !destroyed){
                    if(Math.abs(a)>st.peek())
                        st.pop();
                    else{
                        destroyed = true;
                        if(st.peek()==Math.abs(a))
                            st.pop();
                    }
                }
                if(!destroyed)
                    st.push(a);
            }
        }
        int n = st.size();
        int[] ans = new int[n];
        for(int i=n-1;i>=0;i--){
            ans[i]=st.pop();
        }
        return ans;
    }
}