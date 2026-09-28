class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        outer:
        while(true){
            if(i >= strs[0].length()) break;
            char c = strs[0].charAt(i);
            for(String str : strs){
                if(i >= str.length() || str.charAt(i) != c){
                    break outer;
                }
            }
            sb.append(c);
            i++;
        }
        return sb.toString();
    }
}