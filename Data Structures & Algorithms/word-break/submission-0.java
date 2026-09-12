class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()]; // -1 can't, 1 can, 0 don't know
        outer:
        for(int i = 0; i < dp.length; i++){
            middle:
            for(String st : wordDict){
                if(i - st.length() == -1 || (i - st.length() >= 0 && dp[i - st.length()] == 1)){
                    for(int j = 0; j < st.length(); j++){
                        if(s.charAt(i - j) != st.charAt(st.length() - 1 - j)){
                            continue middle;
                        }
                    }
                    dp[i] = 1;
                    continue outer;
                }
            }
            dp[i] = -1;
        }
        if(dp[dp.length - 1] == 1) return true;
        return false;
    }
}