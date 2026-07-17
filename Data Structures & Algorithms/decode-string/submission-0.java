class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();
        for(char c:s.toCharArray()){
            if(c!=']')
                st.push(String.valueOf(c));
            else{
                StringBuilder temp =new StringBuilder();
                while(!st.peek().equals("["))
                    temp.insert(0,st.pop());
                st.pop();
                StringBuilder num = new StringBuilder();
                while (!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                    num.insert(0, st.pop());
                }
                int k = Integer.parseInt(num.toString());
                st.push(temp.toString().repeat(k));
            }
        }
        StringBuilder ans =new StringBuilder();
        while(!st.isEmpty())
            ans.insert(0,st.pop());

        return ans.toString();
    }
}