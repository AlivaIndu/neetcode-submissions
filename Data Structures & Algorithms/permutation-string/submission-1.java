class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        if(n>s2.length()) return false;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i=0;i<n;i++){
            freq1[s1.charAt(i)-'a']++;
            freq2[s2.charAt(i)-'a']++;
        }

        if(Arrays.equals(freq1,freq2)) return true;

        int i=0;
        for(int j=n;j<s2.length();j++){
            freq2[s2.charAt(j)-'a']++;
            freq2[s2.charAt(i++)-'a']--;
            if(Arrays.equals(freq1,freq2)) return true;
        }
        return false;
    }
}
