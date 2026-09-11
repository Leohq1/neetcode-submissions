class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length())
        return "";

        int minLeft = 0;
        int minRight = Integer.MAX_VALUE;
        boolean exist = false;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.merge(c, 1, (a, b) -> a + b);
        }

        int match = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++){
            char key = s.charAt(right);
            if(map.containsKey(key)){
                if(map.get(key) > 0){
                    match++;
                }
                map.merge(key, -1, (a, b) -> a + b);
                while(match == t.length()){
                    exist = true;
                    if((right - left) < (minRight - minLeft)){
                        minLeft = left;
                        minRight = right;
                    }
                    if(map.containsKey(s.charAt(left)) && map.get(s.charAt(left)) >= 0){
                        match--;
                    }
                    if(map.containsKey(s.charAt(left)))
                    map.merge(s.charAt(left), 1, (a, b) -> a + b);
                    left++;
                }
            }
        }
        if(!exist){
            return "";
        }
        return s.substring(minLeft, minRight + 1);
    }
}
