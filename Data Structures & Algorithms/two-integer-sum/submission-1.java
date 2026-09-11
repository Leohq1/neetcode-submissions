class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i++){
            left = target - nums[i];
            if(map.containsKey(left)){
                return new int[] {map.get(left), i};
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
