class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        int n=s.length();
        int[] freq = new int[128];

        int maxLen=0;
        int i=0;
        for(int j=0;j<n;j++){
            freq[s.charAt(j)]++;
            while(freq[s.charAt(j)]>1)
            {
                freq[s.charAt(i)]--;
                i++;
            }
            maxLen = Math.max(maxLen,j-i+1);
        }
        return maxLen;
    }
}
