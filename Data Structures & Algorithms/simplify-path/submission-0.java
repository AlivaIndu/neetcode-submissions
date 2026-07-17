class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] parts = path.split("/+");

        for(String p:parts){
            if(p.equals(".") || p.equals(""))
                continue;
            if(p.equals("..")){
                if(!st.isEmpty())
                    st.pop();
            }else{
                st.push(p);
            }
        }

        if(st.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0,"/"+st.pop());
        }
        return sb.toString();
    }
}