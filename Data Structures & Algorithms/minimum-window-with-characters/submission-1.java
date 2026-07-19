class Solution {
    public String minWindow(String s, String t) {
        int ns = s.length();
        int nt = t.length();
        if(ns<nt) return "";

        HashMap<Character,Integer> freqt = new HashMap<>();
        HashMap<Character,Integer> freqs = new HashMap<>();
        for(char c:t.toCharArray())
            freqt.put(c,freqt.getOrDefault(c,0)+1);

        int required = freqt.size();
        int formed=0;
        int i=0,j=0,min=Integer.MAX_VALUE;
        int left=0,right=0;

        while(j<ns){
            char c = s.charAt(j);
            freqs.put(c,freqs.getOrDefault(c,0)+1);

            if(freqt.containsKey(c) && freqt.get(c).intValue()==freqs.get(c).intValue())
                formed++;

            while(required==formed && i<=j){

                if(j-i+1<min){
                    min=j-i+1;
                    left=i;
                    right=j;
                }

                char ch = s.charAt(i);
                freqs.put(ch,freqs.get(ch)-1);
                if(freqt.containsKey(ch) && freqs.get(ch).intValue()<freqt.get(ch).intValue())
                    formed--;

                i++;
            }
            j++;
        }
        if(min==Integer.MAX_VALUE) return "";
        return s.substring(left,right+1);
    }
}
