class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        int left = 0;
        char maxChar = s.charAt(0);
        Map<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            char rightChar = s.charAt(right);
            map.merge(rightChar, 1, (a, b) -> a + b);

            if(map.get(rightChar) > map.get(maxChar)){
                maxChar = rightChar;
            }
            while(!isValid(map, left, right, k, maxChar)){
                map.merge(s.charAt(left), -1, (a, b) -> a + b);
                maxChar = findMaxChar(map, maxChar);
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }

    private char findMaxChar(Map<Character, Integer> map, char maxChar){
        for(char key : map.keySet()){
            if(map.get(key) > map.get(maxChar)){
                maxChar = key;
            }
        }
        return maxChar;
    }

    private boolean isValid(Map<Character, Integer> map, int left, int right, int k, char maxChar){
        int num = map.get(maxChar);
        return (right - left + 1 - num) <= k;
    }
}
