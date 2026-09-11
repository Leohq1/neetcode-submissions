class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int result = 0;
        Set<Character> set = new HashSet<>();
        for(int right = 0; right < s.length(); right++){
            if(set.contains(s.charAt(right))){
                while(s.charAt(left) != s.charAt(right)){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            set.add(s.charAt(right));
            result = Math.max(result, set.size());
        }
        return result;
    }
}
