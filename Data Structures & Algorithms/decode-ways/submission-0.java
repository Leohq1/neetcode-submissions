class Solution {

    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for(int i = 1; i < s.length() + 1; i++){
            int index = i - 1;
            int val = s.charAt(index) - '0';
            int valBefore = (index == 0) ? 0 : s.charAt(index - 1) - '0';
            if(val == 0){ // val = 0
                dp[i] = (valBefore == 1 || valBefore == 2) ? dp[i - 2] : 0;
            } else if(val > 6){ // val = 7,8,9
                dp[i] = dp[i - 1];
                dp[i] += (valBefore == 1) ? dp[i - 2] : 0;
            } else if(val > 2){ // val = 3,4,5,6
                dp[i] = dp[i - 1];
                dp[i] += (valBefore == 1 || valBefore == 2) ? dp[i - 2] : 0;
            } else{ // 1,2
                dp[i] = dp[i - 1];
                dp[i] += (valBefore == 1 || valBefore == 2) ? dp[i - 2] : 0;
            }
        }
        return dp[s.length()];
    }
}