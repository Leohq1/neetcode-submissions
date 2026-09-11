class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int tar;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        tar = target;
        dfs(nums, 0, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> cur, int sum){
        if(sum == tar){
            result.add(new ArrayList<>(cur));
            return;
        }
        if(sum > tar || index >= nums.length) return;
        
        cur.add(nums[index]);
        dfs(nums, index, cur, sum + nums[index]);
        cur.remove(cur.size() - 1);
        
        if(index == nums.length - 1) return;

        dfs(nums, index + 1, cur, sum);
    }
}
