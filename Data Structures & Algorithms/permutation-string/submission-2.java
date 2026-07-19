class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n2<n1) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int c:s1.toCharArray())
            freq1[c-'a']++;

        int i=0;
        int j=0;

        while(j<n2){
            char c = s2.charAt(j);
            freq2[c-'a']++;

            if(j-i+1>n1){
                freq2[s2.charAt(i)-'a']--;
                i++;
            }

            if(Arrays.equals(freq1,freq2)) return true;
            j++;
        }
        return false;
    }
}
