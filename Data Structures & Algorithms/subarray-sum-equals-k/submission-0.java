class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        int sum = 0;
        for(int i : nums){
            sum += i;
            result += dp.getOrDefault(sum - k, 0);
            dp.merge(sum, 1, (a, b) -> a + b);
        }
        return result;
    }
}