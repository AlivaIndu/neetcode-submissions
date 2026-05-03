class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int max = 0,maxFreq=0;
        int[] freq = new int[26];
        
        int i=0;
        for(int j=0;j<n;j++){
            freq[s.charAt(j)-'A']+=1;
            maxFreq = Math.max(maxFreq,freq[s.charAt(j)-'A']);

            while(j-i+1-maxFreq>k){
                freq[s.charAt(i)-'A']-=1;
                i++;
            }

            max = Math.max(j-i+1,max);
        }
        return max;
    }
}
