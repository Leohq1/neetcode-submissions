class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> cur){
        if(index == nums.length){
            result.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[index]);
        backtrack(nums, index + 1, cur);
        cur.remove(cur.size() - 1);
        
        int num = nums[index];
        while(index < nums.length && nums[index] == num){
            index++;
        }
        if(index <= nums.length) backtrack(nums, index, cur);
    }
}