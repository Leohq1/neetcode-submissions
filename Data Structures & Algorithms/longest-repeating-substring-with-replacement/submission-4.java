class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;
        int maxF = 0;
        for(int right = 0; right < s.length(); right++){
            map.merge(s.charAt(right), 1, (a, b) -> a + b);
            maxF = Math.max(maxF, map.get(s.charAt(right)));
            while(right - left + 1 - maxF > k){
                map.merge(s.charAt(left), -1, (a, b) -> a + b);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
