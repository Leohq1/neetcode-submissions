class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            map.merge(s.charAt(right), 1, (a, b) -> a + b);
            int max = 0;
            for(char key : map.keySet()){
                max = Math.max(max, map.get(key));
            }
            while(right - left + 1 - max > k){
                map.merge(s.charAt(left), -1, (a, b) -> a + b);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
