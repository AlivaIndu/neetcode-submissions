class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(st.isEmpty()){
                if(c==']' || c==')' || c=='}')
                    return false;
                else
                    st.push(c);
            }
            else{
                if(c==']' || c==')' || c=='}'){
                    if(c==']' && st.peek()!='[')
                        return false;
                    else if(c=='}' && st.peek()!='{')
                        return false;
                    else if(c==')' && st.peek()!='(')
                        return false;
                    st.pop();
                }
                else
                    st.push(c);
            }
        }
        return st.size()==0;
    }
}
