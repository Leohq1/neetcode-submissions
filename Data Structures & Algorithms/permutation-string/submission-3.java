class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] one = new int[26];
        int[] two = new int[26];
        for(char c : s1.toCharArray()){
            one[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        for(; right < s1.length(); right++){
            two[s2.charAt(right) - 'a']++;
        }
        if(Arrays.equals(one, two)) return true;
        while(right < s2.length()){
            two[s2.charAt(right) - 'a']++;
            two[s2.charAt(left) - 'a']--;
            right++;
            left++;
            if(Arrays.equals(one, two)) return true;
        }
        return false;
    }
}