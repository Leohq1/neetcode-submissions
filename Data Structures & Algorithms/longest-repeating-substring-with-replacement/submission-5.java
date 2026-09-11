class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int result = 0;
        int left = 0;
        int maxF = 0;
        for(int right = 0; right < s.length(); right++){
            freq[s.charAt(right) - 'A']++;
            maxF = Math.max(maxF, freq[s.charAt(right) - 'A']);
            while(right - left + 1 - maxF > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
