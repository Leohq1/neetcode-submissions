class Solution {
    public String longestPalindrome(String s) {
        int center = 0;
        int max = 1;
        boolean even = false;
        for(int i = 0; i < s.length(); i++){
            int left = i;
            int right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if(right - left + 1 > max){
                    even = false;
                    center = i;
                    max = right - left + 1;
                }
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                if(right - left + 1 > max){
                    even = true;
                    center = i;
                    max = right - left + 1;
                }
                left--;
                right++;
            }
        }
        String result = (even) ? s.substring(center - max / 2 + 1, center + max / 2 + 1) : s.substring(center - max / 2, center + max / 2 + 1);
        return result;
    }
}