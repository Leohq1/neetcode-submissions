class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }
        int[] one = new int[26];
        int matches = 0;
        for(char c : s1.toCharArray()){
            one[c - 'a']++;
        }
        for(char right : s2.substring(0, s1.length()).toCharArray()){
            if(one[right - 'a'] > 0){
                matches++;
            }
            one[right - 'a']--;
        }
        if(matches == s1.length()){
            return true;
        }
        int left = 0;
        for(char right : s2.substring(s1.length()).toCharArray()){
            if(one[right - 'a'] > 0){
                matches++;
            }
            one[right - 'a']--;
            if(one[s2.charAt(left) - 'a'] >= 0){
                matches--;
            }
            one[s2.charAt(left) - 'a']++;
            left++;
            if(matches == s1.length()){
                return true;
            }
        }
        return false;
    }
}
