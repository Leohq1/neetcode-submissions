class Solution {
    public int uniquePaths(int m, int n) {
        int total = m + n - 2;
        int count = Math.min(m, n) - 1;
        long result = 1;
        for(int i = 1; i <= count; i++){
            result *= total - i + 1;
            result /= i;
        }
        return (int) result;
    }
}