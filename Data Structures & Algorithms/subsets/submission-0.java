class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        result.add(Arrays.asList());
        for(int i : nums){
            backtrack(i);
        }
        return result;
    }

    private void backtrack(int val){
        int size = result.size();
        for(int i = 0; i < size; i++){
            List<Integer> cur = new ArrayList<>(result.get(i));
            cur.add(val);
            result.add(cur);
        }
    }
}