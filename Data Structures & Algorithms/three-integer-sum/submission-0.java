class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int index = 0; index < nums.length - 2; index++){
            if(index > 0 && nums[index] == nums[index - 1]){
                continue;
            }
            int left = index + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[index] + nums[left] + nums[right];
                if(sum > 0){
                    right--;
                } else if(sum < 0){
                    left++;
                } else{
                    if(left == index + 1 || nums[left] != nums[left - 1]){
                        result.add(new ArrayList<Integer>(List.of(nums[index], nums[left], nums[right])));
                    }
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
