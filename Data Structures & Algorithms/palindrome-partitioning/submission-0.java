class Solution {
    public List<List<String>> partition(String s) {
        int size = s.length();
        boolean[][] dp = new boolean[size][size]; // start to end
        for(int i = 0; i < size; i++){
            dp[i][i] = true;
        }
        for(int len = 2; len < size + 1; len++){
            for(int start = 0; start < size - len + 1; start++){
                int end = start + len - 1;
                if(s.charAt(start) == s.charAt(end) && 
                    (len == 2 || dp[start + 1][end - 1])){
                    dp[start][end] = true;
                }
            }
        }
        List<List<String>> result = new ArrayList<>();
        //System.out.println(Arrays.deepToString(dp));
        backtrack(dp, s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(boolean[][] dp, String s, int index, List<String> path, List<List<String>> result){
        if(index == s.length()){
            result.add(new ArrayList<>(path));
            return;
        }
        for(int end = index; end < s.length(); end++){
            if(dp[index][end]){
                path.add(s.substring(index, end + 1));
                backtrack(dp, s, end + 1, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}