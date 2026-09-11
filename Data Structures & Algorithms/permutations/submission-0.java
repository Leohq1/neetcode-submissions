class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] left = new boolean[nums.length];
        for(int i = 0; i < nums.length; i++){
            left[i] = true;
        }
        dfs(new ArrayList<>(), left, 0, nums);
        return result;
    }
    
    private void dfs(List<Integer> cur, boolean[] left, int used, int[] nums){
        if(used == nums.length){
            result.add(new ArrayList<>(cur));
            return;
        }
        for(int j = 0; j < left.length; j++){
            if(!left[j]) continue;
            cur.add(nums[j]);
            left[j] = false;
            dfs(cur, left, used + 1, nums);
            left[j] = true;
            cur.remove(cur.size() - 1);
        }
    }
}
