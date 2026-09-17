class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.merge(i, 1, (a, b) -> a + b);
        }
        int size = nums.length / 3;
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > size) result.add(entry.getKey());
        }
        return result;
    }
}